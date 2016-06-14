/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public ClienteDAO(dbConexion conexion) {
        this.setConexion(conexion);
    }
    
    public boolean insert(Cliente c) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        boolean result = false;
        String sql = "insert into Cliente (clIdentificacion,clNombre,clApellido,clDireccion,clTelefono,clCorreo,clMunicipio,clEstado) values (?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, c.getIdentificacion());
        pst.setString(2, c.getNombre());
        pst.setString(3, c.getApellidos());
        pst.setString(4, c.getDireccion());
        pst.setString(5, c.getTelefono());
        pst.setString(6, c.getEmail());
        pst.setString(7, c.getCiudad());
        pst.setString(8, c.getEstado());
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            result = true;
        }
        return result;
    }

    public ArrayList<Cliente> getRecords() throws SQLException {
        ArrayList<Cliente> lst = new ArrayList<Cliente>();
        Cliente c =null;
        String sql = "select * from Cliente ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            c= MapearObjeto(rs);
            lst.add(c);
        }
        rs.close();
        return lst;
    }

    public Cliente getPk(String identificacion) throws SQLException {
       Cliente c=null;
        String sql = "select * from Cliente where clIdentificacion=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, identificacion);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           c = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return c;
    }

    public void update(String pk,Cliente c) throws SQLException {
        // actualizar objeto de la lista
        boolean result = false;
        String sql = "update Cliente set clIdentificacion= ?, clNombre=?,clApellido=?,clDireccion=?,clTelefono=?, clCorreo=?, clMunicipio=?, clEstado=? where identificacionCliet=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1, c.getIdentificacion());
        pst.setString(2, c.getNombre());
        pst.setString(3, c.getApellidos());
        pst.setString(4, c.getDireccion());
        pst.setString(5, c.getTelefono());
        pst.setString(7, c.getCiudad());
        pst.setString(6, c.getEmail());
        pst.setString(8, c.getEstado());
        pst.setString(9, pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
    }

    public void delete(String pk) throws SQLException {
        //eleminar objeto de la lista
        String sql = "delete from Cliente where clIdentificacion=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1,pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
	
    }

    private Cliente MapearObjeto(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setIdentificacion(rs.getString("clIdentificacion"));
        c.setNombre(rs.getString("clNombre"));
        c.setApellidos(rs.getString("clApellido"));
        c.setDireccion(rs.getString("clDireccion"));
        c.setTelefono(rs.getString("clTelefono"));
        c.setCiudad(rs.getString("clCorreo"));
        c.setEmail(rs.getString("clMunicipio"));
        c.setEstado(rs.getString("clEstado"));
        return c;
    } 
}
