/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author norma
 */
public class PuestoAlmacenamiento {
    
    
    public PuestoAlmacenamiento(){
        
        
        
    }
    
    // metodo para puesto almacenamiento
    
    public static void Registrar_PuestoAlmacenamiento(Statement mysql, String localizacionCuadrante, String consecutivo, String nitBodega, char tipoLocal) throws SQLException{
        String comando = "INSERT INTO puesto_almacenamiento ( localizacion_cuadrante, consecutivo, bodega_nit, tipo_local) VALUES (  " +
                localizacionCuadrante +", " + consecutivo + ", " + nitBodega + ", " + tipoLocal + ");";
        
        mysql.execute(comando);
    }
    
    public static void Registrar_PuestoAlmacenamiento_dentro(Statement mysql, int codigoPuestoContiene){
        // no mamen wey
    }
}
