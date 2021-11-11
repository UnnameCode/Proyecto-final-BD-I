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
    
    
    // queries
    
    // consultar visitantes fecha especifica
    
    public static String ConsultarVisitantesFecha(Statement mysql, String Date) throws SQLException{
        String returnValue = "";
        String comando = "SELECT * FROM ;";
        
        mysql.executeQuery(comando);  // devuelve un set, por ende debe parsearse la entrada
        
        return returnValue;
    }
    
    public static String ConsultarRegistrosVehiculo(Statement mysql, String placa) throws SQLException{
        String returnValue = "";
        String comando = "SELECT * FROM registro WHERE ( registro.placa_vehiculo="+ placa+ ");";
        
        mysql.executeQuery(comando);  // devuelve un set, por ende debe parsearse la entrada
        
        return returnValue;
    }
    
     
    // metodos para entidad registro
    
    public static void Registrar_ingreso(Statement mysql, String licenciaConductor, int cedulaConductor, String placaVehiculo, String tipoVehiculo, String localIngreso, String tipoUsuario, String HoraEntrada) throws SQLException{
        String comando = "INSERT INTO registro ( licencia_conductor, cedula_conductor,  placa_vehiculo, tipo_vehiculo,"
                + "local_ingreso, tipo_usuario, tiempo_entrada ) VALUES (\"" + licenciaConductor +"\","+ String.valueOf(cedulaConductor)+", \""
                + placaVehiculo + "\" , \"" + tipoVehiculo + "\" , \"" + localIngreso + "\", \"" + tipoUsuario + "\", \'" + HoraEntrada + "\');";
        
        
        // todo verificar que el vehiculo este autorizado (verificar el num de contrato asociado a la placa)
        
        mysql.execute(comando);
    }
    public static void Registrar_ingresoVehiculo(Statement mysql, String licenciaConductor, int cedulaConductor, String placaVehiculo, String marca, double VolCarga, double CapacidadCarga,  String tipoVehiculo, String localIngreso, String tipoUsuario, String HoraEntrada) throws SQLException{
        String comando = "INSERT INTO registro ( licencia_conductor, cedula_conductor,  placa_vehiculo, tipo_vehiculo,"
                + "local_ingreso, tipo_usuario, tiempo_entrada ) VALUES (\"" + licenciaConductor +"\","+ String.valueOf(cedulaConductor)+", \""
                + placaVehiculo + "\" , \"" + tipoVehiculo + "\" , \"" + localIngreso + "\", \"" + tipoUsuario + "\", \'" + HoraEntrada + "\');";
        
        
        // todo verificar que el vehiculo este autorizado (verificar el num de contrato asociado a la placa)
        
        mysql.execute(comando);
    }
    
    //verificar si date se pasa entre 'date' o "date"
    public static void Registrar_salida(Statement mysql, String placa, String date) throws SQLException{
        String comando = "UPDATE registro set tiempo_salida = \'" + date+
                "\' WHERE (vehiculo.placa = \"" + placa + "\" AND (vehiculo.tiempo_salida IS NULL)  );";
        
         // todo verificar que el vehiculo este autorizado (verificar el num de contrato asociado a la placa) ignorar
        
        mysql.execute(comando);
    }
    
    // sobrecarga salida con producto  TODO TERMINAR
    public static void Registrar_salida(Statement mysql, String placa, String date, int codigoProducto) throws SQLException{
        String comando = "UPDATE registro set tiempo_salida = " + date+
                " WHERE (vehiculo.placa = " + placa + " );";
        
        mysql.execute(comando);
    }
    
}
