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
public class TrabajadorDao {
    String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public TrabajadorDao(dbConexion conexion) {
        this.setConexion(conexion);
    }
    
    public boolean insert(Trabajador c) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        boolean result = false;
        String sql = "insert into trabajadores (trCedula,trNombres,trApellidos,trTelefono,trdireccion,trEstado,trRol) values (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, c.getCedula());
        pst.setString(2, c.getNombres());
        pst.setString(3, c.getApellidos());
        pst.setString(5, c.getDireccion());
        pst.setString(4, c.getTelefono());
        pst.setString(6, c.getEstado());
        pst.setString(7, c.getRol());
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            result = true;
        }
        return result;
    }
    
    public Trabajador InicioSession(String identificacion, String clave) throws SQLException {
        Trabajador c=null;
        String sql = "select * from trabajadores where trCedula=? AND trClave = SHA1(?) AND trEstado='ACTIVO' ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, identificacion);
        pst.setString(2, clave);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           c = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return c;
    }

    public ArrayList<Trabajador> getRecords() throws SQLException {
        ArrayList<Trabajador> lst = new ArrayList<Trabajador>();
        Trabajador c =null;
        String sql = "select * from trabajador ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            c= MapearObjeto(rs);
            lst.add(c);
        }
        rs.close();
        return lst;
    }

    public Trabajador getPk(String trCedula) throws SQLException {
       Trabajador c=null;
        String sql = "select * from trabajador where trCedula=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, trCedula);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           c = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return c;
    }

    public void update(String pk,Trabajador c) throws SQLException {
        // actualizar objeto de la lista
        boolean result = false;
        String sql = "update trabajador set trCedula= ?, trNombres=?,trApellidos=?,trTelefono=?,trdireccion=?, trEstado=?, trRol=? where trCedula=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1, c.getCedula());
        pst.setString(2, c.getNombres());
        pst.setString(3, c.getApellidos());
        pst.setString(4, c.getDireccion());
        pst.setString(5, c.getTelefono());
        pst.setString(6, c.getEstado());
        pst.setString(7, c.getRol());
        pst.setString(8, pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
    }

    public void delete(String pk) throws SQLException {
        //eleminar objeto de la lista
        String sql = "delete from trabajador where trCedula=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1,pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
	
    }

    private Trabajador MapearObjeto(ResultSet rs) throws SQLException {
       Trabajador c = new Trabajador();
        c.setCedula(rs.getString("trCedula"));
        c.setNombres(rs.getString("trNombres"));
        c.setApellidos(rs.getString("trApellidos"));
         c.setTelefono(rs.getString("trTelefono"));
        c.setDireccion(rs.getString("trdireccion"));
        c.setEstado(rs.getString("trEstado"));
        c.setRol(rs.getString("trRol"));
        return c;
    } 
}
