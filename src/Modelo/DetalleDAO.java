/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Leam
 */
public class DetalleDAO {
        String msg;
    boolean lError;
    private dbConexion conexion;
    public dbConexion getConexion() {
        return conexion;
    }
    public void setConexion(dbConexion conexion) {
        this.conexion = conexion;
    }
    public DetalleDAO(dbConexion conexion) {
        this.conexion = conexion;
    }
   
    public boolean insert(Detalle c) throws SQLException {
        boolean result = false;                
        String sql = "insert into detalle (dtDescripcion,dtCantidad,dtPrecio,dtProducto,dtFactura) values (?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, c.getDtDescripcion());
        pst.setInt(2, c.getDtCantidad());
        pst.setFloat(3, c.getDtPrecio());
        pst.setInt(4, c.getDtPCProducto());
        pst.setInt(5, c.getDtCFactura());
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            this.actualizarCantidad(c);
            result = true;
        }                                                  
        return result;                               
    }
    
  
      
    private void actualizarCantidad(Detalle det) throws SQLException {        
        String sql = "UPDATE producto  SET prCantidad = prCantidad - ? WHERE producto.prCodigo=?";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setInt(1,det.getDtCantidad());
        pst.setInt(2, det.getDtPCProducto());        
        if (conexion.Update(pst) > 0) {
            conexion.Commit();        
        }
    }

    
    
      
    /*
    
    // Registra nueva venta ademas de detalle de ventas y actualiza stock de productos
 
    public boolean RegistrarVenta( String idventa , Map productos , String total, String detalle , String nit )
    {
        try {
            //registra venta
            String q = " INSERT tventa (v_id, v_fecha, v_preciot, v_detalle, v_nit ) "
                + "values( '"+idventa+"', '"+getFecha()+"', '"+total.replace(",", ".")+"', '"+detalle+"' , '"+nit+"' );";
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            //registra venta de productos
            Iterator it = productos.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                carrito itm = (carrito) e.getValue();
                pstm = this.getConexion().prepareStatement(" INSERT INTO tpv (pv_producto,pv_venta,pv_cantidad,pv_precio)"
                        + " values( '"+itm.getIdproducto()+"' , '"+idventa+"' , '"+itm.getCantidad()+"' , '"+itm.getPrecio().replace(",", ".")+"' );");
                pstm.execute();
                pstm.close();                
                //actualiza stock
                pstm = this.getConexion().prepareStatement(" UPDATE tproducto SET p_stock=p_stock-"+itm.getCantidad()+" WHERE p_id='"+itm.getIdproducto()+"' ");
                pstm.execute();
                pstm.close();
            }
            return true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return false;
    }
    **/
}
