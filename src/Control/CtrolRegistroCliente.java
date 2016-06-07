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
         
        if (!esidentificacionClietValido(c.getIdentificacion())){
            return "Longitud de la identificacion inválido ";
        }
         if (!esNombreClientValido(c.getNombre())){
            return "Nombre Vacio";
        }
        if (!esApellidoValido(c.getApellidos())){
            return "Apellido Vacio";
        }
        if (!esdireccionValido(c.getDireccion())){
            return "No existe ninguna direccion";
        }
        if (!esTelefonoValido(c.getTelefono())){
            return "Escriba un telefono";
        }
       
         if (!esMunicipio_CodigoMunValido(c.getCiudad())){
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
    private boolean esApellidoValido(String apellidos) {
        return apellidos.trim().length()>0;
    }
    /*
    private boolean esNombreValido(String nombre) {
        return nombre.trim().length()>0;
        
    }
    
    public boolean esUsernameValido(String userName) {
        return userName.trim().length()>4 && userName.trim().length()<8;
    }
    **/

   public boolean esidentificacionClietValido(String Identificacion) {
      return Identificacion.trim().length()<12;  
    }

    private boolean esNombreClientValido(String nombre) {
       return nombre.trim().length()>0;
    }

    private boolean esdireccionValido(String direccion) {
      return direccion.trim().length()>0;
    }

    private boolean esTelefonoValido(String telefono) {
      return telefono.trim().length()>5 && telefono.trim().length()<11;  
    }

    private boolean esMunicipio_CodigoMunValido(String ciudad) {
       return ciudad.trim().length()>0; //To change body of generated methods, choose Tools | Templates.
    }
    
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
}
