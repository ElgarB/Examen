#***************************************************************************************************************

#Muestra que Compañias tienes, que Planes.

SELECT PRV.NOMBRE_PROV, PGS.MONTO
FROM `examen`.`T_PLANES` PLN, `examen`.`c_pagos` PGS, `examen`.`C_PROVEEDOR` PRV
WHERE PLN.ID_PROVEEDOR = PRV.ID_PROVEEDOR
AND PLN.ID_PAGOS = PGS.ID_PAGOS 


#***************************************************************************************************************

#Muestra el Historico de compras de planes

SELECT PRV.NOMBRE_PROV, PGS.MONTO, HISV.FCH_CREACION
FROM `examen`.`T_HISTORICO_VENTAS` HISV, `examen`.`c_pagos` PGS, `examen`.`C_PROVEEDOR` PRV
WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR
AND HISV.ID_PAGOS = PGS.ID_PAGOS 
AND HISV.ID_PROVEEDOR = 2

#***************************************************************************************************************  

#Ventas por periodo de tiempo

SELECT PRV.NOMBRE_PROV, PGS.MONTO, HISV.FCH_CREACION
FROM `examen`.`T_HISTORICO_VENTAS` HISV, `examen`.`c_pagos` PGS, `examen`.`C_PROVEEDOR` PRV
WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR
AND HISV.ID_PAGOS = PGS.ID_PAGOS 
#AND HISV.ID_PROVEEDOR = 2
#AND DATE(HISV.FCH_CREACION) = DATE(NOW())
AND DATE(HISV.FCH_CREACION) 
	BETWEEN NOW() - INTERVAL 2 DAY 
	AND NOW() + INTERVAL 0 DAY
#ORDER BY NOMBRE_PROV DESC;
ORDER BY HISV.FCH_CREACION DESC;

#***************************************************************************************************************  

#Deberá tener un servicio web que permita calcular las ganancias del día, así como estadísticas sencillas (ventas por monto y por carrier). Solo por el día actual.

#total de ventas por dia

SELECT SUM(PGS.MONTO)  
FROM examen.T_HISTORICO_VENTAS HISV, examen.c_pagos PGS, examen.C_PROVEEDOR PRV  
WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR  
AND HISV.ID_PAGOS = PGS.ID_PAGOS   
AND DATE(HISV.FCH_CREACION) = DATE(NOW());


#Total de ventas por Carrier, 

SELECT PRV.NOMBRE_PROV, HISV.FCH_CREACION, SUM(PGS.MONTO) TOTAL
FROM `examen`.`T_HISTORICO_VENTAS` HISV, `examen`.`c_pagos` PGS, `examen`.`C_PROVEEDOR` PRV
WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR
AND HISV.ID_PAGOS = PGS.ID_PAGOS 
AND DATE(HISV.FCH_CREACION) = DATE(NOW())
AND HISV.ID_PROVEEDOR = 2
GROUP BY PRV.NOMBRE_PROV, HISV.FCH_CREACION;


#Total de venta por monto

SELECT PRV.NOMBRE_PROV, PGS.MONTO, PGS.DESCRIPCION, SUM(PGS.MONTO) TOTAL
FROM `examen`.`T_HISTORICO_VENTAS` HISV, `examen`.`c_pagos` PGS, `examen`.`C_PROVEEDOR` PRV
WHERE HISV.ID_PROVEEDOR = PRV.ID_PROVEEDOR
AND HISV.ID_PAGOS = PGS.ID_PAGOS 
AND DATE(HISV.FCH_CREACION) = DATE(NOW())
AND HISV.ID_PAGOS = 4
GROUP BY PRV.NOMBRE_PROV, HISV.FCH_CREACION;

#***************************************************************************************************************  


