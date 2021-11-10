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
public class Contrato {
    
    public Contrato(){
        
    }
    
    
    // metodos para busquedas pedidas
    public static String Buscar_contrato(Statement mysql, int numContrato) throws SQLException{
        
        String returnValue = "";
        String comando = "SELECT * FROM contrato WHERE ( contrato.numero_contrato ="+String.valueOf(numContrato)+");";
        
        
        mysql.executeQuery(comando);  // devuelve un set, por ende debe parsearse la entrada
        
        
        returnValue = "Falta por implementar :u";
        
        return returnValue;
    }
    
    public static String Mostrar_contratosActivos(Statement mysql){
        String returnValue = "";
        String comando = "";
        
        // pedir fecha actual con DATE y buscar segun contratos con fecha posterior (los contratos temp y membresia son los que vencen)
        
        
        return returnValue;
              
        
        
    }
    
    public static String Contratos_proximosAVecencer(Statement mysql){
        String returnValue = "";
        
        // devolver todos los contratos que les quede un mes o menos antes de que venzan
        
        return returnValue;
    }
    
    
    // metodos para contratos
    public static void Registrar_Contrato(Statement mysql, int poliza, String localAsignado, int codigoPuestoAlmacenamiento, int contratante) throws SQLException{
        String comando = "INSERT INTO contrato ( poliza_amparo, local_asignado, codigo_puesto_almacenamiento, contratante) VALUES ( "+
                String.valueOf(poliza) + ", \"" + localAsignado + "\", " + String.valueOf(codigoPuestoAlmacenamiento) + ", " + contratante + ");";
        
        
        mysql.execute(comando);
    }
    
    public static void Registrar_Contrato_temporal(Statement mysql, int numContrato, String fechaInicio, String fechaFinalizacion, char frecuenciaPago, int poliza, String localAsignado) throws SQLException{
        String comando = "INSERT INTO temporal ( numero_contrato, fecha_inicio, fecha_finalizacion, frecuencia_pago, poliza_amparo, local_asignado) VALUES ( " +
                String.valueOf(numContrato)+", \"" +fechaInicio + "\", \""+ fechaFinalizacion + "\", \'"+ String.valueOf(frecuenciaPago) + "\', " + poliza + ", \"" + localAsignado + "\");";
        
        mysql.execute(comando);
        
    }
    
    public static void Registrar_Contrato_membresia(Statement mysql, int numContrato, char seguroMecanica, String fechaFinalizacion, char frecuenciaPago, String fechaPoliza, String fechaTerminacionPoliza) throws SQLException{{
        String comando = "INSERT INTO membresia ( numero_contrato, seguro_mecanica, fecha_finalizacion, frecuencia_pago, fecha_poliza, fecha_terminacion_poliza) VALUES ( "+
              String.valueOf(numContrato) + ", \'"+ String.valueOf(seguroMecanica) + ", \""+ fechaFinalizacion +"\", \'"+
                String.valueOf(frecuenciaPago)+ "\' , \""+ fechaPoliza +"\", \""+fechaTerminacionPoliza+"\");";
        
        mysql.execute(comando);
                     
    }
        
    }
    
    public static void Registrar_contrato_propietario(Statement mysql, int numContrato, String tipoPersona, String tipoUso) throws SQLException{
        String comando = "INSERT INTO propietario (numero_contrato, tipo_persona, tipo_uso) VALUES ( " +
                String.valueOf(numContrato) + ", \""+ tipoPersona + "\", \""+tipoUso + "\");";
        
        mysql.execute(comando);
        
    }
    
    
}
