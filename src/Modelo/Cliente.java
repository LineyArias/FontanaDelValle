/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    private String ciudad;
    private String email;  
   
   // constructor sobrecargado

    public Cliente(String identificacion, String nombre, String apellidos, String direccion, String telefono, String ciudad,String email) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad=ciudad;
        this.email = email;
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
    
    
    
    
}