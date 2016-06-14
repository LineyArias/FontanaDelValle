/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Trabajador;
import Modelo.TrabajadorDao;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leam
 */
public class CtrTrabajador {
     dbConexion conexion; 
     
      public String insert(Trabajador c) {  
         
        if (!estrCedulaValido(c.getCedula())){
            return "Longitud de la identificacion inválido ";
        }
         if (!estrNombresValido(c.getNombres())){
            return "Nombre Vacio";
        }
        if (!estrApellidosValido(c.getApellidos())){
            return "Apellido Vacio";
        }
        if (!estrDireccionValido(c.getDireccion())){
            return "Por favor escriba una direccion ";
        }
        if (!estrTelefonoValido(c.getTelefono())){
            return "El telefono debe contener mas de 6 digitos";
        }
       
         if (!estrRolValido(c.getRol())){
            return "Seleccione un rol";
        }
       
         
        try {
            conexion = new dbConexion();
            TrabajadorDao CDao= new TrabajadorDao(conexion);
            CDao.insert(c);
            
            return "Guardado Satisfactoriamente";
        } catch (SQLException ex) {
            Logger.getLogger(CtrTrabajador.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrTrabajador.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }  
     
    }
     
     
     
    public ArrayList<Trabajador> getRecords () throws ClassNotFoundException{
        try{
            conexion = new dbConexion();
            TrabajadorDao cDao =  new TrabajadorDao(conexion);
            return cDao.getRecords();
            
        } catch (SQLException ex){
            Logger.getLogger(CtrTrabajador.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }

    private boolean estrCedulaValido(String cedula) {
       return cedula.trim().length()<12;
    }

    private boolean estrNombresValido(String nombres) {
       return nombres.trim().length()>0; 
    }

    private boolean estrApellidosValido(String apellidos) {
         return apellidos.trim().length()>0;
    }

    private boolean estrDireccionValido(String direccion) {
         return direccion.trim().length()>0; 
    }

    private boolean estrRolValido(String rol) {
        return rol.trim().length()>0;  
    }

    private boolean estrTelefonoValido(String telefono) {
 return telefono.trim().length()>5 && telefono.trim().length()<11;    }
}
