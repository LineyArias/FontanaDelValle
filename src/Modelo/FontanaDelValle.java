/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Leam
 */
public class FontanaDelValle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
       Connection conexion = null;
        conexion = getConnection("jdbc:mysql://localhost/fontanaNuevo","root","root");
        String sql = "select * from categorias where PadreId=? ";
			java.sql.PreparedStatement pst = conexion.prepareStatement(sql);
                        String val="1"; 
			pst.setString(1,val);
                        ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        System.out.println(rs.getString("Descripcion"));
                   } 
                    conexion.close();
        }
    
    
    public static Connection getConnection(String dbURL, String user, String password)
    throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection(dbURL, user, password);
  }
    
}
    
