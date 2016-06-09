/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FEWL
 */
public class CtrProductos {
    dbConexion conexion;
    public String insert(Producto p){  
        
        if (p.getPrDescripcion() == ""){
            return "Ingrese la Descripción";
        }
        
        try {
            conexion = new dbConexion();
            ProductoDAO pDao = new  ProductoDAO (conexion);
            if (pDao.insert(p)){
               return "Producto Registrado Correctamente";
            }else{
                return "Error al Guardar el Producto";
            }
        } catch (SQLException | ClassNotFoundException exc) {
            Logger.getLogger(CtrProductos.class.getName()).log(Level.SEVERE, null, exc);
            return exc.getMessage();
        }        
    }
    
    public ArrayList<Producto> getRecords(){
        try {
             conexion = new dbConexion();
            ProductoDAO pDao= new ProductoDAO(conexion);
            return pDao.getRecords();
        } catch (SQLException | ClassNotFoundException exc) {
            Logger.getLogger(CtrProductos.class.getName()).log(Level.SEVERE, null, exc);            
        }   
        return null;
    } 
    
     public Producto getPk(int id){
        try {
            conexion = new dbConexion();
            ProductoDAO cDao= new ProductoDAO(conexion);
            return cDao.getProductoPorId(id);
          } catch (SQLException | ClassNotFoundException exc) {
            Logger.getLogger(CtrProductos.class.getName()).log(Level.SEVERE, null, exc);            
        }  
        return null;
  }    
}
