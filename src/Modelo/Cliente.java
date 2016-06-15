/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 *
 * @author Leam
 */
public class Cliente {
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email; 
    private String ciudad;
    private String estado;
    private int codigo;
  //  private DATE  fechaRegistro;

   
     
   
   // constructor sobrecargado

    public Cliente(String identificacion, String nombre, String apellidos, String direccion, String telefono,String email,String ciudad,String estado) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
         this.ciudad=ciudad;
         this.estado=estado;
    }
// constructor por defecto 
    public Cliente() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

   
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    
    public String getNombre() {
        return nombre;
    }

  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

   
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

   
    public String getDireccion() {
        return direccion;
    }

  
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    public String getTelefono() {
        return telefono;
    }

   
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }                
}
