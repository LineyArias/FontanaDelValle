/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;


/**
 *
 * @author Leam
 */
public class dbConexion {
    private static Connection conn = null;
    private int FilasAfectadas = 0;
    
    public dbConexion() throws SQLException, ClassNotFoundException  {
       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fontanaNuevo", "root", "root");
            if (conn == null) {
                throw new SQLException("Problema de conexion con el Servidor");
            } else {
                conn.setAutoCommit(false); // Modo de Autocommit deshabilitado
            }
    
      
   
    }
    
    public Connection getConnection() {
        return conn;
    }

    public ResultSet Query(String sql) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet Query(PreparedStatement pst) throws SQLException {
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    

    public int Update(String sql) throws SQLException {
        Statement st = conn.createStatement();
        FilasAfectadas = st.executeUpdate(sql);
        return FilasAfectadas;
    }
    
    public int Update(PreparedStatement pst) throws SQLException {
        FilasAfectadas = pst.executeUpdate();
        return FilasAfectadas;
    }

    public int Update(String sql, int Modo) throws SQLException {
        Statement st = conn.createStatement();
        FilasAfectadas = st.executeUpdate(sql);
        if (Modo == 1) {  // efectuar el Commit
            this.Commit();
        }
        return FilasAfectadas;
    }

    public void Close() throws SQLException {
        conn.close();
    }

    public void Commit() throws SQLException {
        conn.commit();
    }

    public void Rollback() throws SQLException {
        conn.rollback();
    }
    
    public int getLastId() throws SQLException {
    	int last_id = -1;
    	String sql = "SELECT LAST_INSERT_ID()";
    	ResultSet rs = this.Query(sql);
    	if (rs.next()) {
    		last_id = rs.getInt(1);
    	}
    	rs.close();
    	return last_id;
    }
    
    public String current_date() throws SQLException {
        String sql = "select date_format(current_date,'%Y/%m/%d') as today;";
        java.sql.ResultSet rs = this.Query(sql);
        if (rs.next()) {
            return rs.getString("today");
        }else {
            return "";
        }

    }
}
