/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author Santi
 */
public class conexionBD {
    Connection cn;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_projectfinal?useSSL=false","root","Premiun123");
            System.out.println("Conexion Establecida");
            
        }
        catch(Exception e){
                System.out.println(e.getMessage());
                }
            return cn;
        }
    }

