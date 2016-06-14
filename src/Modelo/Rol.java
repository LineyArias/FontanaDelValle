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
public class Rol {
    
     private String codRol;
    private String NombreRol;

    public Rol(String codRol, String NombreRol) {
        this.codRol = codRol;
        this.NombreRol = NombreRol;
    }

    public Rol() {
    }

    /**
     * @return the codRol
     */
    public String getCodRol() {
        return codRol;
    }

    /**
     * @param codRol the codRol to set
     */
    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    /**
     * @return the NombreRol
     */
    public String getNombreRol() {
        return NombreRol;
    }

    /**
     * @param NombreRol the NombreRol to set
     */
    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }
    
    @Override
    public String toString()
    {
    return NombreRol;
    }
    
}
