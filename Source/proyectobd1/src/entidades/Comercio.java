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
public class Comercio {
    
    
    public Comercio(){
        
    }
    
    
     // metodos para entidad referencia comercial
    
    public static void Registrar_ReferenciaComercial(Statement mysql, String tipoIdentificacion, int identificacion, String nombreCompleto, String razonSocial, String direccion, int telefonoOficina) throws SQLException{
        String comando = "INSERT INTO referencia_comercial ( tipo_identificacion, identificacion, nombre_completo, razon_social"+
                ", direccion, telefono_oficina ) VALUES ( \"" + tipoIdentificacion + "\", " + String.valueOf(identificacion) + ", \""+
                nombreCompleto + "\", \"" + razonSocial + "\", \""+ direccion + "\", " + String.valueOf(telefonoOficina) + ");";
        
        mysql.execute(comando);
    }
    
}
