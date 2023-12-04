package com.bm.ws.core.bdmysql;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.examenws.bm.schema.VoParametrosProdRs;

public class ConsultaBD {


	/**
	 * 
	 * @return
	 */
	public VoParametrosProdRs obtenTotalVentas() {

		System.out.print("Entro a obtenTotalVentas");
		
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		
		voParametrosProdRs.setCarrier("TODOS");
		voParametrosProdRs.setMontoTotal(1234);

		Date current_date = Calendar.getInstance().getTime();
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(current_date);

		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		voParametrosProdRs.setFecha(xmlDate);

		return voParametrosProdRs;
	}

	/**
	 * 
	 * @param idCarrier
	 * @return
	 */
	public VoParametrosProdRs obtenMontoPorCarrier(int idCarrier) {

		System.out.print("Entro a obtenTotalVentas");
		
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		
		voParametrosProdRs.setCarrier("PILLOFON");
		voParametrosProdRs.setMontoTotal(1234);

		Date current_date = Calendar.getInstance().getTime();
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(current_date);

		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		voParametrosProdRs.setFecha(xmlDate);
		return voParametrosProdRs;
	}

	/**
	 * 
	 * @param idMonto
	 * @return
	 */
	public VoParametrosProdRs obtenVentasTotalPorMonto(int idMonto) {
		
		System.out.print("Entro a obtenTotalVentas");
		
		VoParametrosProdRs voParametrosProdRs = new VoParametrosProdRs();
		
		voParametrosProdRs.setCarrier("TODOS LOS CARRIER");
		voParametrosProdRs.setMontoTotal(1234);

		Date current_date = Calendar.getInstance().getTime();
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(current_date);

		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		voParametrosProdRs.setFecha(xmlDate);
		return voParametrosProdRs;
	}
	
	
}
