/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.dbConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrolRegistroCliente {
    dbConexion conexion; 
     public String insert(Cliente c) {  
         
        if (!esclIdentificacionValido(c.getIdentificacion())){
            return "Longitud de la identificacion inválido ";
        }
         if (!esclNombreValido(c.getNombre())){
            return "Nombre Vacio";
        }
        if (!esclApellidoValido(c.getApellidos())){
            return "Apellido Vacio";
        }
        if (!esclDireccionValido(c.getDireccion())){
            return "Por favor escriba una direccion ";
        }
        if (!esclTelefonoValido(c.getTelefono())){
            return "El telefono debe contener mas de 6 digitos";
        }
       
         if (!esclCorreoValido(c.getEmail())){
            return "Escriba";
        }
        
         if (!esclMunicipioValido(c.getCiudad())){
            return "Seleccione una ciudad";
        }
         
        
         
        try {
            conexion = new dbConexion();
            ClienteDAO CDao= new ClienteDAO(conexion);
            CDao.insert(c);
            
            return "Guardado Satisfactoriamente";
        } catch (SQLException ex) {
            Logger.getLogger(CtrolRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrolRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        
        
        
     
    }
    
   // private boolean esMunicipio_CodigoMunValido(String ciudad) {
    //   return ciudad.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    //}
    
    public ArrayList<Cliente> getRecords () throws ClassNotFoundException{
        try{
            conexion = new dbConexion();
            ClienteDAO cDao =  new ClienteDAO(conexion);
            return cDao.getRecords();
            
        } catch (SQLException ex){
            Logger.getLogger(CtrolRegistroCliente.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }

    public boolean esclIdentificacionValido(String identificacion) {
       return identificacion.trim().length()<12;   //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclNombreValido(String nombre) {
         return nombre.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclApellidoValido(String apellidos) {
        return apellidos.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclDireccionValido(String direccion) {
        return direccion.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclTelefonoValido(String telefono) {
        return telefono.trim().length()>5 && telefono.trim().length()<11;  //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclCorreoValido(String email) {
        return email.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclMunicipioValido(String ciudad) {
        return ciudad.trim().length()>0 ; //To change body of generated methods, choose Tools | Templates.
    }

    private boolean esclEstadoValido(String estado) {
         return estado.trim().length()>0 ;//To change body of generated methods, choose Tools | Templates.
    }
}
