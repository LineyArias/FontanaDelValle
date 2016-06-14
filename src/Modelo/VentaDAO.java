/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Leam
 */
public class VentaDAO {
      String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public VentaDAO(dbConexion conexion) {
        this.conexion = conexion;
    }
    
     public int insert(Ventas c) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        int result = 0;
        String sql = "insert into factura (ftSubtotal,tfTotal,ftEstado,ftCliente,ftTrabajador) values (?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setFloat(1, c.getSubtotal());
        pst.setFloat(2, c.getTotal());
        pst.setString(3, c.getEstado());
        pst.setString(4, c.getCliente());
        pst.setString(5, c.getTrabajador());
        if (pst.executeUpdate() > 0) {
            conexion.Commit();            
            result = conexion.getLastId();
        }
        return result;
    }
    
       public ArrayList<Ventas> getRecords() throws SQLException {
        ArrayList<Ventas> lst = new ArrayList<Ventas>();
        Ventas c =null;
        String sql = "select * from factura ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            c= MapearObjeto(rs);
            lst.add(c);
        }
        rs.close();
        return lst;
    }

           public Ventas getPk(int idFactura) throws SQLException {
        Ventas c=null;
        String sql = "select * from factura where idFactura=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setInt(1, idFactura);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           c = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return c;
    }
    
    
     private Ventas MapearObjeto(ResultSet rs) throws SQLException {
       Ventas c = new Ventas();
        c.setSubtotal(rs.getFloat("ftSubtotal"));
        c.setTotal(rs.getFloat("tfTotal"));
        c.setEstado(rs.getString("ftEstado"));
        c.setCliente(rs.getString("ftCliente"));
        c.setTrabajador(rs.getString("ftTrabajador"));   
        return c;
    }
    
    
    
    
    
    
  
}
