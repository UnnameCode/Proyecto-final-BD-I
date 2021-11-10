use bd_projectfinal;
select *  from persona;
#Consultar los contratos vigentes de un cliente
SELECT * 
FROM temporal 
WHERE fecha_finalizacion > curdate() 
ORDER BY fecha_finalizacion ASC
#Consultar contratos proximos a vencer

