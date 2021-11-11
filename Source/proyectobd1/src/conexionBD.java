/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Santi
 */
public class conexionBD {
    Connection cn;
    public Connection conexion(){
        
        try{
            String usuario = " ";
            String Contraseña = "";
            usuario = JOptionPane.showInputDialog(null, "Ingrese Nombre usuario");
            Contraseña = JOptionPane.showInputDialog(null, "Ingrese Contraseña");
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_projectfinal?useSSL=false",usuario,Contraseña);
            System.out.println("Conexion Establecida");
            
        }
        catch(Exception e){
                System.out.println(e.getMessage());
                }
            return cn;
        }
    }

