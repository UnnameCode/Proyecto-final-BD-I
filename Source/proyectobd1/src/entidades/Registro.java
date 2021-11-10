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
public class Registro {
    
    
    public Registro(){
        
    }
    
     
    // metodos para entidad registro
    public static void Registrar_ingreso(Statement mysql, String licenciaConductor, int cedulaConductor, String placaVehiculo, String tipoVehiculo, String localIngreso, String tipoUsuario, String date) throws SQLException{
        String comando = "INSERT INTO registro ( licencia_conductor, cedula_conductor,  placa_vehiculo, tipo_vehiculo,"
                + "local_ingreso, tipo_usuario, tiempo_entrada ) VALUES (" + licenciaConductor +","+ String.valueOf(cedulaConductor)+", "
                + placaVehiculo + ", " + tipoVehiculo + ", " + localIngreso + ", " + tipoUsuario + ", " + date + ");";
        
        mysql.execute(comando);
    }
    
    public static void Registrar_salida(Statement mysql, String placa, String date) throws SQLException{
        String comando = "UPDATE registro set tiempo_salida = " + date+
                " WHERE (vehiculo.placa = " + placa + " AND (vehiculo.tiempo_salida IS NULL)  );";
        
        mysql.execute(comando);
    }
    
    // sobrecarga salida con producto  TODO TERMINAR
    public static void Registrar_salida(Statement mysql, String placa, String date, int codigoProducto) throws SQLException{
        String comando = "UPDATE registro set tiempo_salida = " + date+
                " WHERE (vehiculo.placa = " + placa + " );";
        
        mysql.execute(comando);
    }
    
}
