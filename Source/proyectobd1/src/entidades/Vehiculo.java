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
public class Vehiculo {
    
    public Vehiculo(){
        
    }
    
    // metodos para entidad vehiculo
    
    public static void Registrar_vehiculo(Statement mysql, String placa, String tipo, String color, int modelo, int numero_contrato, int identificacion_conductor) throws SQLException{
        String comando = "INSERT INTO vehiculo (placa, tipo, color, modelo, numero_contrato, identificacion_conductor) "+
                "VALUES ( " + placa + ", " + tipo + ", " + color + ", " + String.valueOf(modelo) + "," + String.valueOf(numero_contrato)+ ","+
                String.valueOf(numero_contrato)+ ", " + String.valueOf(identificacion_conductor)+ ");";
        
         mysql.execute(comando);
    }
    
    public static void AsignarMarca_vehiculo(Statement mysql, String placa, String marca) throws SQLException{
        String comando = "UPDATE vehiculo set marca = " + marca+
                " WHERE (vehiculo.placa = " + placa + " );";
        
        mysql.execute(comando);
        
    }
    
    public static void AsignarVolumen_vehiculo(Statement mysql, String placa, double volumen) throws SQLException{
        String comando = "UPDATE vehiculo set volumen = " + volumen+
                " WHERE (vehiculo.placa = " + placa + " );";
        
        mysql.execute(comando);
        
    }
    
    public static void AsignarCapacidad_vehiculo(Statement mysql, String placa, double capacidad) throws SQLException{
          String comando = "UPDATE vehiculo set capacidad = " + capacidad+
                " WHERE (vehiculo.placa = " + placa + " );";
        
        mysql.execute(comando);
              
    }
    
}
