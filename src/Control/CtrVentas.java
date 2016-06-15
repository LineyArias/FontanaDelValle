/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Detalle;
import Modelo.DetalleDAO;
import Modelo.VentaDAO;
import Modelo.Ventas;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leam
 */
public class CtrVentas {
      dbConexion conexion; 
    public ArrayList<Ventas> getRecords () throws ClassNotFoundException{
        try{
            conexion = new dbConexion();
            VentaDAO cDao =  new VentaDAO(conexion);
            return cDao.getRecords();
            
        } catch (SQLException ex){
            Logger.getLogger(CtrVentas.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
    public int insert(Ventas v, ArrayList<Detalle> detalle){                       
        try {            
            conexion = new dbConexion();           
            VentaDAO vDao = new  VentaDAO (conexion);
            int codigo = vDao.insert(v);
            if (codigo>0){
                DetalleDAO dDao= new DetalleDAO(conexion);
                
                for (Detalle lst : detalle) {
                   Detalle det  = (Detalle)lst;
                   det.setDtCFactura(codigo);
                   dDao.insert(det);
                }                          
            } 
            return codigo;
        } catch (SQLException | ClassNotFoundException exc) {
            Logger.getLogger(CtrProductos.class.getName()).log(Level.SEVERE, null, exc);            
        }        
        return 0;
    }
}
