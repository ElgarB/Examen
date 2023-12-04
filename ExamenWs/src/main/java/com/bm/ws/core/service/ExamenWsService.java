package com.bm.ws.core.service;

import org.springframework.stereotype.Service;

import com.examenws.bm.schema.StatusInsert;
import com.examenws.bm.schema.VoHistoricoVentas;
import com.examenws.bm.schema.VoParametrosProdRs;

@Service
public class ExamenWsService {

	
	/**
	 * total de ventas
	 * @param idCarrier
	 * @return
	 */	
	public VoParametrosProdRs obtenTotalVentas() {
		ConsultaBdMsqlService consultaBdMsqlService = new ConsultaBdMsqlService();
		return consultaBdMsqlService.obtenTotalVentasRequest();
	}
	
	/**
	 * total de ventas por Carrier
	 * @param idCarrier
	 * @return
	 */	
	public VoParametrosProdRs obtenMontoPorCarrier(int idCarrier) {
		ConsultaBdMsqlService consultaBdMsqlService = new ConsultaBdMsqlService();
		return consultaBdMsqlService.obtenMontoPorCarrierRequest(idCarrier);		
	}
	
	/**
	 * total de venta por monto
	 * @param idCarrier
	 * @return
	 */	
	public VoParametrosProdRs obtenVentasPorMonto(int idMonto) {	
		ConsultaBdMsqlService consultaBdMsqlService = new ConsultaBdMsqlService();
		return consultaBdMsqlService.obtenVentasPorMontoRequest(idMonto);	
	}
	
	/**
	 * total de venta por monto
	 * @param idCarrier
	 * @return
	 */	
	public StatusInsert insertVentasRequest(VoHistoricoVentas voHistoricoVentas) {
		ConsultaBdMsqlService consultaBdMsqlService = new ConsultaBdMsqlService();
		return consultaBdMsqlService.insertVentasRequest(voHistoricoVentas);
	}
	
	
}
