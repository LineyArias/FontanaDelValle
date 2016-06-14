/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Rol;
import Modelo.RolDAO;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leam
 */
public class CtrRol {
     dbConexion conexion;  
     
     public ArrayList<Rol> getRecords () throws ClassNotFoundException{
        try{
            conexion = new dbConexion();
            RolDAO cDao =  new RolDAO(conexion);
            return cDao.getRecords();
            
        } catch (SQLException ex){
            Logger.getLogger(CtrRol.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
}
}
