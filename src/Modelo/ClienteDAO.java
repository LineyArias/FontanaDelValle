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
        String sql = "insert into Cliente (identificacionCliet,NombreClient,Apellido,direccion,Telefono,Municipio_CodigoMun,correo) values (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, c.getIdentificacion());
        pst.setString(2, c.getNombre());
        pst.setString(3, c.getApellidos());
        pst.setString(4, c.getDireccion());
        pst.setString(5, c.getTelefono());
        pst.setString(6, c.getCiudad());
        pst.setString(7, c.getEmail());
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

    public Cliente getPk(String identificacionCliet) throws SQLException {
       Cliente c=null;
        String sql = "select * from Cliente where identificacionCliet=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, identificacionCliet);
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
        String sql = "update Cliente set identificacionCliet= ?, NombreClient=?,Apellido=?,direccion=?,Telefono=?, Municipio_CodigoMun=?, correo=? where identificacionCliet=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1, c.getIdentificacion());
        pst.setString(2, c.getNombre());
        pst.setString(3, c.getApellidos());
        pst.setString(4, c.getDireccion());
        pst.setString(5, c.getTelefono());
        pst.setString(6, c.getCiudad());
        pst.setString(7, c.getEmail());
        pst.setString(8, pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
    }

    public void delete(String pk) throws SQLException {
        //eleminar objeto de la lista
        String sql = "delete from Cliente where identificacionCliet=?";
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
        c.setIdentificacion(rs.getString("identificacionCliet"));
        c.setNombre(rs.getString("NombreClient"));
        c.setApellidos(rs.getString("Apellido"));
        c.setDireccion(rs.getString("direccion"));
        c.setTelefono(rs.getString("Telefono"));
        c.setCiudad(rs.getString("Municipio_CodigoMun"));
        c.setEmail(rs.getString("correo"));
        return c;
    } 
}
