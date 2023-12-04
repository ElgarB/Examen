package com.bm.ws.core.interfaceService;

import com.examenws.bm.schema.StatusInsert;
import com.examenws.bm.schema.VoHistoricoVentas;
import com.examenws.bm.schema.VoParametrosProdRs;

public interface ConsultaBdMsqlService {

	/**
	 * 
	 * @return
	 */
	public VoParametrosProdRs obtenTotalVentasRequest();
	
	/**
	 * 
	 * @param parIdCarrier
	 * @return
	 */
	public VoParametrosProdRs obtenMontoPorCarrierRequest(int parIdCarrier);
	
	/**
	 * 
	 * @param parIdMonto
	 * @return
	 */
	public VoParametrosProdRs obtenVentasPorMontoRequest(int parIdMonto);

	/**
	 * 
	 * @param voHistoricoVentas
	 * @return
	 */
	public StatusInsert insertVentasRequest(VoHistoricoVentas voHistoricoVentas);
	
}
