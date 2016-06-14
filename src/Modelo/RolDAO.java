/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leam
 */
public class RolDAO {
    String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public RolDAO(dbConexion conexion) {
        this.setConexion(conexion);
    }
    
    public boolean insert(Rol r) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        boolean result = false;
        String sql = "insert into rol (idRol,rolDescripcion) values (?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, r.getNombreRol());
       
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            result = true;
        }
        return result;
    }

    public ArrayList<Rol> getRecords() throws SQLException {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        Rol m =null;
        String sql = "select * from rol ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            m= MapearObjeto(rs);
            lst.add(m);
        }
        rs.close();
        return lst;
    }

    public Rol getPk(String idRol) throws SQLException {
       Rol m=null;
        String sql = "select * from rol where idRol=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1,idRol);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           m = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return m;
    }

    public void update(String pk,Rol m) throws SQLException {
        // actualizar objeto de la lista
        boolean result = false;
        String sql = "update rol set rolDescripcion=? where idRol=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(2, pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
    }

    public void delete(String pk) throws SQLException {
        //eleminar objeto de la lista
        String sql = "delete from rol where idRol=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1,pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
	
    }

    private Rol MapearObjeto(ResultSet rs) throws SQLException {
      Rol m = new Rol();
      m.setCodRol(rs.getString("idRol"));
        m.setNombreRol(rs.getString("rolDescripcion"));
       return m;
    }  
}
