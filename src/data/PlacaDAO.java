/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author odavi
 */
public class PlacaDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost: 3306/bancoEs", "root", "");
            
            return true;
            
        } catch (ClassNotFoundException |SQLException ex) {
            return false;
        }
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
           
        }
    }
    public int salvar(Placa pl){
        int status;
        
       try {
           st = conn.prepareStatement("INSERT INTO funcionario VALUES(?)");
           st.setString(1, pl.getPlaca());

            System.out.println(st);
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
}
