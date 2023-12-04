package com.bm.ws.core.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.bm.ws.core.bdmysql.ConsExamen;
import com.examenws.bm.schema.StatusInsert;
import com.examenws.bm.schema.VoHistoricoVentas;
import com.examenws.bm.schema.VoParametrosProdRs;
import com.mysql.jdbc.Statement;

public class ConsultaBdMsql {

	/**
	 * 
	 */
	private Connection conexionMySql;
	
	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(ConsultaBdMsql.class.getName());
	
	/**
	 * 
	 * @return
	 */
	public VoParametrosProdRs obtenTotalVentas() {
		
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		logger.info("Inicia en obtenTotalVentas()");
		
		try {
			//Class.forName(com.mysql.jdbc.Driver.class.getName());
			conexionMySql = DriverManager.getConnection(
					ConsExamen.URL_MySQL_GIS, 
					ConsExamen.USER_MySQL_GIS, 
					ConsExamen.PWD_MySQL_GIS);
			
	        if (conexionMySql == null) {
	        	throw new SQLException("No hay Conexion a " + ConsExamen.URL_MySQL_GIS);
	        }
	        
			String query = new String();
			PreparedStatement pstat;
			ResultSet rs;

			query = "" + 
				"SELECT SUM(PGS.MONTO) " + 
				"FROM examen.T_HISTORICO_VENTAS HISV, examen.c_pagos PGS, examen.C_PROVEEDOR PRV " + 
				"WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR " + 
				"AND HISV.ID_PAGOS = PGS.ID_PAGOS  " + 
				"AND DATE(HISV.FCH_CREACION) = DATE(NOW()) " + 
				//"AND HISV.ID_PROVEEDOR = 2" + 
				"";

			pstat = conexionMySql.prepareStatement(query);
			rs = pstat.executeQuery();
			
			Date current_date = new Date();
			while (rs.next()) {
				
				voParametrosProdRs.setCarrier("Ventas Totales");
				current_date = Calendar.getInstance().getTime();
				voParametrosProdRs.setMontoTotal(rs.getInt(1));
			}

			XMLGregorianCalendar xmlDate = null;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(current_date);

			try {
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				try {
					if(conexionMySql != null) {
						conexionMySql.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}

			}
			
			rs.close();
			pstat.close();
			voParametrosProdRs.setFecha(xmlDate);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			voParametrosProdRs.setCarrier(e.getMessage());
			voParametrosProdRs.setMontoTotal(0);
			voParametrosProdRs.setFecha(null);
		} 

		logger.info(voParametrosProdRs.getCarrier());
		logger.info(String.valueOf(voParametrosProdRs.getMontoTotal()));
		logger.info(voParametrosProdRs.getFecha() == null ? "" : voParametrosProdRs.getFecha().toString());
		
		return voParametrosProdRs;
	}
	
	/**
	 * 
	 * @param idCarrier
	 * @return
	 */
	public VoParametrosProdRs obtenMontoPorCarrier(int idCarrier) {
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		logger.info("Inicia en obtenMontoPorCarrier()");
		
		try {
			//Class.forName(com.mysql.jdbc.Driver.class.getName());
			conexionMySql = DriverManager.getConnection(
					ConsExamen.URL_MySQL_GIS, 
					ConsExamen.USER_MySQL_GIS, 
					ConsExamen.PWD_MySQL_GIS);
			
	        if (conexionMySql == null) {
	        	throw new SQLException("No hay Conexion a " + ConsExamen.URL_MySQL_GIS);
	        }
	        
			String query = new String();
			PreparedStatement pstat;
			ResultSet rs;

			query = "" + 
				"SELECT PRV.NOMBRE_PROV, HISV.FCH_CREACION, SUM(PGS.MONTO) TOTAL " + 
				"FROM examen.T_HISTORICO_VENTAS HISV, examen.c_pagos PGS, examen.C_PROVEEDOR PRV " + 
				"WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR " + 
				"AND HISV.ID_PAGOS = PGS.ID_PAGOS  " + 
				"AND DATE(HISV.FCH_CREACION) = DATE(NOW()) " + 
				"AND HISV.ID_PROVEEDOR = ? " +  
				"GROUP BY PRV.NOMBRE_PROV, HISV.FCH_CREACION " + 
				"";

			pstat = conexionMySql.prepareStatement(query);
			pstat.setInt(1, idCarrier);						//1		ID_PROVEEDOR
			rs = pstat.executeQuery();

			Date current_date = new Date();
			while (rs.next()) {
				voParametrosProdRs.setCarrier(		rs.getString(1));
				current_date = 						rs.getDate(2);
				voParametrosProdRs.setMontoTotal(	rs.getInt(3));
			}

			XMLGregorianCalendar xmlDate = null;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(current_date);

			try {
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			} catch (Exception e) {
				e.printStackTrace();
			}

			rs.close();
			pstat.close();
			voParametrosProdRs.setFecha(xmlDate);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			voParametrosProdRs.setCarrier(e.getMessage());
			voParametrosProdRs.setMontoTotal(0);
			voParametrosProdRs.setFecha(null);
		} finally {
			
			try {
				if(conexionMySql != null) {
					conexionMySql.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}

		}
		
		logger.info(voParametrosProdRs.getCarrier());
		logger.info(String.valueOf(voParametrosProdRs.getMontoTotal()));
		logger.info(voParametrosProdRs.getFecha().toString());
		return voParametrosProdRs;
	}
	
	/**
	 * 
	 * @param idMonto
	 * @return
	 */
	public VoParametrosProdRs obtenVentasPorMonto(int idMonto) {
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		logger.info("Inicia en obtenVentasPorMonto()");		
		
		try {
			//Class.forName(com.mysql.jdbc.Driver.class.getName());
			conexionMySql = DriverManager.getConnection(
					ConsExamen.URL_MySQL_GIS, 
					ConsExamen.USER_MySQL_GIS, 
					ConsExamen.PWD_MySQL_GIS);
			
	        if (conexionMySql == null) {
	        	throw new SQLException("No hay Conexion a " + ConsExamen.URL_MySQL_GIS);
	        }
	        
			String query = new String();
			PreparedStatement pstat;
			ResultSet rs;

			query = "" + 
				"SELECT PGS.MONTO, PGS.DESCRIPCION, SUM(PGS.MONTO) TOTAL " + 
				"FROM examen.T_HISTORICO_VENTAS HISV, examen.c_pagos PGS, examen.C_PROVEEDOR PRV " + 
				"WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR " + 
				"AND HISV.ID_PAGOS = PGS.ID_PAGOS  " + 
				"AND DATE(HISV.FCH_CREACION) = DATE(NOW()) " + 
				"AND HISV.ID_PAGOS = ? " + 
				"GROUP BY PGS.MONTO, PGS.DESCRIPCION, HISV.FCH_CREACION" + 
				"";

			pstat = conexionMySql.prepareStatement(query);
			pstat.setInt(1, idMonto);						//1		ID_PAGOS
			rs = pstat.executeQuery();

			Date current_date = new Date();
			while (rs.next()) {
				voParametrosProdRs.setCarrier(		rs.getInt(1) + " - " + rs.getString(2) );
				current_date = 						Calendar.getInstance().getTime();
				voParametrosProdRs.setMontoTotal(	rs.getInt(3));
			}

			XMLGregorianCalendar xmlDate = null;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(current_date);

			try {
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			} catch (Exception e) {
				e.printStackTrace();
			}

			rs.close();
			pstat.close();
			voParametrosProdRs.setFecha(xmlDate);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			voParametrosProdRs.setCarrier(e.getMessage());
			voParametrosProdRs.setMontoTotal(0);
			voParametrosProdRs.setFecha(null);
		} finally {
			
			try {
				if(conexionMySql != null) {
					conexionMySql.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}

		}
		
		logger.info(voParametrosProdRs.getCarrier());
		logger.info(String.valueOf(voParametrosProdRs.getMontoTotal()));
		logger.info(voParametrosProdRs.getFecha().toString());
		return voParametrosProdRs;
	}

	/**
	 * 
	 * @param voHistoricoVentas
	 * @return
	 */
	public StatusInsert insertVentas(VoHistoricoVentas voHistoricoVentas) {

		StatusInsert status = new StatusInsert();
		logger.info("Inicia en insertVentas()");
		logger.info(voHistoricoVentas.getTelefono());

		try {
			//Class.forName(com.mysql.jdbc.Driver.class.getName());
			conexionMySql = DriverManager.getConnection(
					ConsExamen.URL_MySQL_GIS, 
					ConsExamen.USER_MySQL_GIS, 
					ConsExamen.PWD_MySQL_GIS);
			
	        if (conexionMySql == null) {
	        	throw new SQLException("No hay Conexion a " + ConsExamen.URL_MySQL_GIS);
	        }
	        
			String query = new String();
			PreparedStatement pstat;

			query = "" + 
				"INSERT INTO examen.T_HISTORICO_VENTAS (ID_HIST_VENT, ID_PROVEEDOR, ID_PAGOS, TELEFONO, FCH_CREACION) " + 
				"VALUES (NULL, ?, ?, ?, NOW() )" + 
				"";

			pstat = conexionMySql.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstat.setInt(1, voHistoricoVentas.getIdProveedor());	//1		IdProveedor
			pstat.setInt(2, voHistoricoVentas.getIdPagos());		//2		ID_PAGOS
			pstat.setString(3, voHistoricoVentas.getTelefono());	//3		TELEFONO	
			pstat.executeUpdate();
	
			ResultSet result = pstat.getGeneratedKeys();
			if (result.next()) {
			    int idDevuelto = result.getInt(1);
			    logger.info("Se guardo con el ID_HIST_VENT:" + idDevuelto);
			}
			
			status.setStatus("OK");
			pstat.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			status.setStatus(e.getMessage());
		} finally {
			
			try {
				if(conexionMySql != null) {
					conexionMySql.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}

		}

		logger.info(status.getStatus());

		return status;
	}
	
}
