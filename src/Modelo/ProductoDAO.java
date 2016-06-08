/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FEWL
 */
public class ProductoDAO {
    String msg;
    boolean lError;
    private dbConexion conexion;
   
    
     public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }

    public ProductoDAO(dbConexion conexion) {
        this.conexion = conexion;
    }
    public boolean insert(Producto p)  throws SQLException {
        boolean result = false;
        String sql = "INSERT INTO producto (prDescripcion, prCantidad, prPrecio, prEstado) values (?,?,?,?)";
         java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
               pst.setString(1, p.getPrDescripcion());
               pst.setInt(2, p.getPrCantidad());
               pst.setFloat(3, p.getPrPrecio());            
               pst.setString(4, p.getPrEstado());

        if (pst.executeUpdate() > 0) {
               conexion.Commit();
               result = true;
           }
        return result;
    }
    
    public ArrayList<Producto> getRecords() throws SQLException {
       ArrayList<Producto> lst = new ArrayList<Producto>();
        Producto p=null;        
        String sql = "select * from producto";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            p = MapearObjeto(rs);
            lst.add(p);
        }
        rs.close();
        return lst;
    }
     
    public Producto getProductoPorId(int idProducto) throws SQLException {
       
        Producto p = null;
        String sql = "select * from producto where prCodigo= "+idProducto;
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            p = MapearObjeto(rs);
        }
        rs.close();
        return p;
    }
    
    private Producto MapearObjeto(ResultSet rs) throws SQLException {
        Producto pr = new Producto();        
        pr.setPrCodigo(rs.getInt("prCodigo"));
        pr.setPrDescripcion(rs.getString("prDescripcion"));
        pr.setPrCantidad(rs.getInt("prCantidad"));
        pr.setPrPrecio(rs.getFloat("prPrecio"));
        pr.setPrEstado(rs.getString("prEstado"));        
        return pr;
    } 
}
