package com.bm.ws.core.endpoint;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bm.ws.core.service.ExamenWsService;
import com.examenws.bm.schema.ParametroFechaHoy;
import com.examenws.bm.schema.ParametroIdCarrier;
import com.examenws.bm.schema.ParametroIdMonto;
import com.examenws.bm.schema.StatusInsert;
import com.examenws.bm.schema.VoHistoricoVentas;
import com.examenws.bm.schema.VoParametrosProdRs;

import jakarta.xml.bind.JAXBElement;

@Endpoint
public class ExamenWsEndPoint {

    private static final String NAMESPACE_URI = "http://examenws.com/bm/schema";	//Lo toma del XDS opBasicas.xsd
    
    @Autowired
    private ExamenWsService examenWsService;
    
    /**
     * 
     */
    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
    	return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
    
    /**
     * 
     * @param fechaHoy
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenTotalVentasRequest")	//Lo toma del XDS productos.xsd del Request
    @ResponsePayload
	public JAXBElement<VoParametrosProdRs> obtenTotalVentas(@RequestPayload JAXBElement<ParametroFechaHoy> fechaHoy) {
    	return createJaxbElement(examenWsService.obtenTotalVentas(), VoParametrosProdRs.class);
	}
    
    /**
     * 
     * @param idCarrier
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenMontoPorCarrierRequest")	//Lo toma del XDS productos.xsd del Request
    @ResponsePayload
	public JAXBElement<VoParametrosProdRs> obtenMontoPorCarrier(@RequestPayload JAXBElement<ParametroIdCarrier> idCarrier) {
    	
    	return createJaxbElement(examenWsService.obtenMontoPorCarrier(idCarrier.getValue().getIdCarrier()), VoParametrosProdRs.class);
	}
    
    /**
     * 
     * @param idMonto
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenVentasPorMontoRequest")	//Lo toma del XDS productos.xsd del Request
    @ResponsePayload
	public JAXBElement<VoParametrosProdRs> obtenVentasPorMonto(@RequestPayload JAXBElement<ParametroIdMonto> idMonto) {
    	return createJaxbElement(examenWsService.obtenVentasPorMonto(idMonto.getValue().getIdMonto()), VoParametrosProdRs.class);
	}
 
    /**
     * 
     * @param voHistoricoVentas
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "insertVentasRequest")	//Lo toma del XDS productos.xsd del Request
    @ResponsePayload
	public JAXBElement<StatusInsert> insertVentas(@RequestPayload JAXBElement<VoHistoricoVentas> voHistoricoVentas) {
    	return createJaxbElement(examenWsService.insertVentasRequest(voHistoricoVentas.getValue()), StatusInsert.class);
	}
 
}
