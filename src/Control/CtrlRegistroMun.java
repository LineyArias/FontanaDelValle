/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.Municipio;
import Modelo.MunicipioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leam
 */
public class CtrlRegistroMun {
     dbConexion conexion;  
     
     public ArrayList<Municipio> getRecords () throws ClassNotFoundException{
        try{
            conexion = new dbConexion();
            MunicipioDAO cDao =  new MunicipioDAO(conexion);
            return cDao.getRecords();
            
        } catch (SQLException ex){
            Logger.getLogger(CtrlRegistroMun.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
}
}
