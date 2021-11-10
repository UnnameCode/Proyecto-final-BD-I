/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author norma
 */
import java.sql.*;

public class Consultas {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bd_projectfinal?useSSL=false";
   static final String USER = "root";
   static final String PASS = "Premiun123";
   
    public Consultas(String[] args){
        
        try(Connection bd_projectfinal = DriverManager.getConnection(DB_URL, USER, PASS); 
                Statement stmt = bd_projectfinal.createStatement();
        ) {		      
         System.out.println("consultar los contratos vigentes de un cliente");          
         String sql = "SELECT numero_contrato, tipo_persona, tipo_uso FROM propietario WHERE fecha_finalizacion > curdate() AND numero_contrato = (SELECT numero_contrato_propietario FROM contrato WHERE numero_contrato = (SELECT numero_contrato FROM persona));\n" +
"SELECT numero_contrato, seguro_mecanica, fecha_finalizacion, frecuencia_pago, fecha_poliza, fecha_terminacion_poliza FROM membresia WHERE fecha_finalizacion > curdate() AND numero_contrato = (SELECT numero_contrato_membresia FROM contrato WHERE numero_contrato = (SELECT numero_contrato FROM persona));\n" +
"SELECT numero_contrato, fecha_inicio, fecha_finalizacion, frecuencia_pago, poliza_amparo, local_asignado FROM membresia WHERE fecha_finalizacion > curdate() AND numero_contrato = (SELECT numero_contrato_temporal FROM contrato WHERE numero_contrato = (SELECT numero_contrato FROM persona));";
         stmt.executeUpdate(sql);
         
         System.out.println("Consultar los contratos proximos a vence"); 
         sql = "SELECT numero_contrato, tipo_persona, tipo_uso FROM propietario WHERE fecha_finalizacion > curdate() ORDER BY fecha_finalizacion ASC;\n" +
"SELECT numero_contrato, seguro_mecanica, fecha_finalizacion, frecuencia_pago, fecha poliza, fecha_terminacion_poliza FROM membresia WHERE fecha_finalizacion > curdate() ORDER BY fecha_finalizacion ASC;\n" +
"SELECT numero_contrato, fecha_inicio, fecha_finalizacion, frecuencia_pago, poliza_amparo, local_asignado FROM temporal WHERE fecha_finalizacion > curdate() ORDER BY fecha_finalizacion ASC;";
         stmt.executeUpdate(sql);
         
         System.out.println("Registrar el ingreso de un vehiculo autorizado");
         sql = "INSERT INTO registro (numero_registro, licencia_conductor, cedula_conductor, placa_vehiculo, marca_vehiculo, vol_carga, capacidad_carga ,tipo_vehiculo, tiempo_entrada) VALUES ('1', (SELECT identificacion_conductor, identificador_conductor, placa, marca, volumen, capacidad, tipo FROM vehiculo), GETDATE());";
         stmt.executeUpdate(sql);
         
         System.out.println("Registrar la salida de un vehiculo autorizado");
         sql = "INSERT INTO registro (numero_registro, retiro_mercancia, tiempo_salida) VALUES ('1', 'y', (SELECT identificacion_conductor FROM vehiculo), GETDATE());";
         stmt.executeUpdate(sql);
         
         System.out.println("consultar los puestos de almacenamiento");
         sql = "SELECT cantidad_puestos FROM bodega;\n" +
"SELECT * FROM puesto_almacenamiento;";
         stmt.executeUpdate(sql);
         
         System.out.println("consultar los ingresos y salidas de un vehiculo particular");
         sql = "SELECT * FROM ingreso WHERE placa_vehiculo = 'abc123';";
         stmt.executeUpdate(sql);
         
         System.out.println("consultar los datos de los clientes por categoria y sus contratos, aqui hay dos formas");
         sql = "SELECT * FROM persona WHERE numero_contrato_empleo = (SELECT numero_contrato FROM contrato ORDER BY numero_contrato_propietario OR numero_contrato_membresia OR numero_contrato_temporal ASC);\n" +
"SELECT * FROM persona ORDER BY tipo ASC;";
         stmt.executeUpdate(sql);

         System.out.println("consultar los vehiculos autorizados para un contrato");
         sql = "SELECT * FROM vehiculo WHERE numero_contrato = (SELECT numero_contrato FROM CONTRATO;";
         stmt.executeUpdate(sql);
         
         System.out.println("Consultar los vehículos autorizados para un cliente ");
         sql = "SELECT * FROM vehiculos WHERE identificacion_conductor =(SELECT cedula_conductor FROM registro);";
         stmt.executeUpdate(sql);
         
          System.out.println("consultar los visitantes en una fecha especifica");
         sql = "SELECT numero_registro, licencia_conductor, cedula_conductor, placa_vehiculo, marca_vehiculo, vol_carga, capacidad_carga ,tipo_vehiculo, tiempo_entrada FROM registro WHERE tiempo_entrada = '2021-10-9';";
         stmt.executeUpdate(sql);
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    };
    

    
    /*
    aca colocar los metodos para las consultas requeridas en el enunciado, los que sean propios metodos de
    la entidad, colocarlos en la clase correspondiente
    
    o Crear un puesto de almacenamiento   (X) PuestoAlmacenamiento.Registrar...
    o Registrar un contrato         (X) Contrato.Registrar...
    o Consultar un contrato         (X parcial
    o Consultar los contratos vigentes de un cliente 
    o Consultar los contratos próximos a vencer
    o Registrar el ingreso de un vehículo autorizado (Z Parcialmente falta verificar si vehiculo esta autorizado (REGISTRO)
    o Registrar la salida de un vehículo autorizado (Z Parcialmente falta verificar (REGISTRO)
    o Consultar los puestos de almacenamiento (X) Falta acomodar string que devuelve (PUESTO_ALMACENAMIENTO)
    o Consultar los ingresos y salidas de un vehículo particular    ( Y ) parcial, esta en Registro (REGISTRO)
    o Consultar datos de los clientes por categoría y sus contratos (CONSULTAS)
    o Consultar los vehículos autorizados para un contrato (VEHICULOS)
    o Consultar los vehículos autorizados para un cliente  (VEHICULOS)
    o Consultar los visitantes en una fecha específica     (REGISTRO)
    
    
    
    */

    
    public static String ConsultarClientesCategoria(Statement mysql, String categoria){
        String returnValue = "";
        String querieCommand = "";
        
        System.out.println("consultar los clientes por categoria");
        String sql = "SELECT * FROM persona WHERE tipo = 'insertar algo';\n" +
"SELECT * FROM persona ORDER BY tipo ASC;";
        // desplegar clientes con datos especificos al contrato especificado
        
        return returnValue;
    }
}
    
    
    
    
   
    
   
    
    
    
    
    
    
    
    

