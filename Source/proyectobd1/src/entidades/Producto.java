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
public class Producto {
    
    
    public Producto(){
        
    }
    
    
    
    // metodos para producto
    
    public static void Registrar_producto(Statement mysql, char tipo, double valorAsegurado, String descripcion, char estadoPoliza, String placaVehiculo ) throws SQLException{
        String comando = "INSERT INTO puesto_almacenamiento ( tipo, valor_asegurado, descripcion, estado_poliza, vehiculo_placa) VALUES ( " +
                String.valueOf(tipo)+", "+ String.valueOf(valorAsegurado)+ ", "+ descripcion +", " +String.valueOf(estadoPoliza) +
                        ", " + placaVehiculo + ");";
     
        
        
        
        
        mysql.execute(comando);
    }
    
    public static void Registrar_producto_mercancia(Statement mysql, int codigoProducto, double fragilidad, double peso, double volumen, String fechaEmpaque, double valorNominal, int empacador ) throws SQLException{
        String comando = "INSERT INTO mercancia ( codigo, fragilidad, peso, volumen, fecha_empaque, valor_nominal, empacador) VALUES ( " + 
                String.valueOf(codigoProducto) + ", " + String.valueOf(fragilidad) + ", " +String.valueOf(peso) + String.valueOf(volumen) +
                "," + fechaEmpaque +", " + valorNominal +"," + String.valueOf(empacador) + ");";
        
        mysql.execute(comando);
    }
    
    public static void Registrar_producto_contenedor(Statement mysql, int codigoProducto, char tipoContenedor, double largo, double ancho, double alto, double capacidadCarga, String empresaResponsable, String polizaManejo) throws SQLException{
        String comando = "INSERT INTO contenedor ( codigo, tipo_contenedor, largo, ancho, alto, capacidad_carga, empresa_responsable, poliza_manejo) VALUES (" +
                String.valueOf(codigoProducto) + "," + String.valueOf(tipoContenedor)+ ", "+ String.valueOf(largo)+","+ String.valueOf(ancho)+","+
                String.valueOf(alto)+"," +String.valueOf(capacidadCarga) + ", "+ empresaResponsable + "," + polizaManejo +");";
        
        mysql.execute(comando); 
    }
    
    public static void Registrar_producto_maquinaria(Statement mysql, int codigoProducto, String marca, double peso, String modelo, double valorNominal  ) throws SQLException{
        String comando = "INSERT INTO maquinaria( codigo, marca, peso, modelo, valor_nominal) VALUES ( " +
                String.valueOf(codigoProducto)+", " + marca +", " + String.valueOf(peso) + ", " + modelo + ", "+ String.valueOf(valorNominal) +");";
     
        
        mysql.execute(comando); 
    }
    
}
