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
public class MunicipioDAO {
   String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public MunicipioDAO(dbConexion conexion) {
        this.setConexion(conexion);
    }
    
    public boolean insert(Municipio m) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        boolean result = false;
        String sql = "insert into municipio (muCodigo,muNombre) values (?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, m.getNombreMunicipio());
       
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            result = true;
        }
        return result;
    }

    public ArrayList<Municipio> getRecords() throws SQLException {
        ArrayList<Municipio> lst = new ArrayList<Municipio>();
        Municipio m =null;
        String sql = "select * from municipio ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            m= MapearObjeto(rs);
            lst.add(m);
        }
        rs.close();
        return lst;
    }

    public Municipio getPk(String muCodigo) throws SQLException {
       Municipio m=null;
        String sql = "select * from municipio where muCodigo=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1,muCodigo);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           m = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return m;
    }

    public void update(String pk,Municipio m) throws SQLException {
        // actualizar objeto de la lista
        boolean result = false;
        String sql = "update municipio set muNombre=? where muCodigo=?";
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
        String sql = "delete from municipio where muCodigo=?";
	java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
	pst.setString(1,pk);
        this.lError = true;
	if (conexion.Update(pst) > 0) {
            conexion.Commit();
            this.lError = false;
	}
	
    }

    private Municipio MapearObjeto(ResultSet rs) throws SQLException {
       Municipio m = new Municipio();
      m.setCodMunic(rs.getString("muCodigo"));
        m.setNombreMunicipio(rs.getString("muNombre"));
       return m;
    }  
}
