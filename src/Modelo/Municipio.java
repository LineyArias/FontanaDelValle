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
public class Municipio {
    private String codMunic;
    private String NombreMunicipio;

    public Municipio( String codMunic, String NombreMunicipio) {
        this.codMunic= codMunic;
        this.NombreMunicipio = NombreMunicipio;
    }

    public Municipio() {
    }

    /**
     * @return the NombreMunicipio
     */
    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    /**
     * @param NombreMunicipio the NombreMunicipio to set
     */
    public void setNombreMunicipio(String NombreMunicipio) {
        this.NombreMunicipio = NombreMunicipio;
    }

    /**
     * @return the codMunic
     */
    public String getCodMunic() {
        return codMunic;
    }

    /**
     * @param codMunic the codMunic to set
     */
    public void setCodMunic(String codMunic) {
        this.codMunic = codMunic;
    }
    
    @Override
    public String toString()
    {
    return NombreMunicipio;
    }
    
    
}
