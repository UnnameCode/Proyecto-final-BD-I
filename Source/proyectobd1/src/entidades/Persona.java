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
public class Persona {
    
    
    public Persona(){
        
    }
    
        // metodos para entidad persona
    // Registrar persona
    
    public static void Registrar_persona(Statement mysql, int numero_identificacion, String tipo, String nombreCompleto, String direccion, String telefono) throws SQLException{
        String comando = "INSERT INTO persona (numero_identificacion, tipo, nombre_completo, direccion,"
                + " telefono) VALUES ("+ String.valueOf(numero_identificacion)+", "
                + tipo+", "+ nombreCompleto+","+ direccion+ "," + telefono + ");";
        
        mysql.execute(comando);
    }
    
    public static void Registrar_licenciaPersona(Statement mysql, int identificacion, int licenciaConduccion) throws SQLException{
        String comando = "UPDATE persona set registro_conduccion = " + String.valueOf(licenciaConduccion)+
                " WHERE (persona.numero_identificacion = " + String.valueOf(identificacion)+ " );";
        
        mysql.execute(comando);
    }
    
    public static void Registrar_empleo(Statement mysql, int contrato, int identificacion) throws SQLException{
        String comando = "UPDATE persona set numero_contrato_empleo = " + String.valueOf(contrato)+
                " WHERE (persona.numero_identificacion = " + String.valueOf(identificacion)+ " );";
        
        mysql.execute(comando);
    }
    
    
    
}
