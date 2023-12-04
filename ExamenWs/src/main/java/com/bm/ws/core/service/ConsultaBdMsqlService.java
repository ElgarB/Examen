package com.bm.ws.core.service;

import com.bm.ws.core.repository.ConsultaBdMsql;
import com.examenws.bm.schema.StatusInsert;
import com.examenws.bm.schema.VoHistoricoVentas;
import com.examenws.bm.schema.VoParametrosProdRs;

public class ConsultaBdMsqlService implements com.bm.ws.core.interfaceService.ConsultaBdMsqlService {

	@Override
	public VoParametrosProdRs obtenTotalVentasRequest() {
		ConsultaBdMsql consultaBdMsql = new ConsultaBdMsql();
		return consultaBdMsql.obtenTotalVentas();
	}

	@Override
	public VoParametrosProdRs obtenMontoPorCarrierRequest(int parIdCarrier) {
		ConsultaBdMsql consultaBdMsql = new ConsultaBdMsql();
		return consultaBdMsql.obtenMontoPorCarrier(parIdCarrier);
	}

	@Override
	public VoParametrosProdRs obtenVentasPorMontoRequest(int parIdMonto) {
		ConsultaBdMsql consultaBdMsql = new ConsultaBdMsql();
		return consultaBdMsql.obtenVentasPorMonto(parIdMonto);
	}
	
	@Override
	public StatusInsert insertVentasRequest(VoHistoricoVentas voHistoricoVentas) {
		ConsultaBdMsql consultaBdMsql = new ConsultaBdMsql();
		return consultaBdMsql.insertVentas(voHistoricoVentas);
	}

}
