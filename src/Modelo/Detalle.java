/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Map;
/**
 *
 * @author Leam
 */
public class Detalle {
    private String  dtDescripcion;
    private int     dtCantidad;
    private float  dtPrecio;
    private int   dtPCProducto;
    private int   dtCFactura; 
    private float dtSubTotal;

   

    public Detalle() {
    }

    public Detalle(String dtDescripcion, int dtCantidad, float dtPrecio, int dtPCProducto, int dtCFactura) {
        this.dtDescripcion = dtDescripcion;
        this.dtCantidad = dtCantidad;
        this.dtPrecio = dtPrecio;
        this.dtPCProducto = dtPCProducto;
        this.dtCFactura = dtCFactura;
    }

    /**
     * @return the dtDescripcion
     */
    public String getDtDescripcion() {
        return dtDescripcion;
    }

    /**
     * @param dtDescripcion the dtDescripcion to set
     */
    public void setDtDescripcion(String dtDescripcion) {
        this.dtDescripcion = dtDescripcion;
    }

    /**
     * @return the dtCantidad
     */
    public int getDtCantidad() {
        return dtCantidad;
    }

    /**
     * @param dtCantidad the dtCantidad to set
     */
    public void setDtCantidad(int dtCantidad) {
        this.dtCantidad = dtCantidad;
    }

    /**
     * @return the dtPrecio
     */
    public float getDtPrecio() {
        return dtPrecio;
    }

    /**
     * @param dtPrecio the dtPrecio to set
     */
    public void setDtPrecio(float dtPrecio) {
        this.dtPrecio = dtPrecio;
    }

    /**
     * @return the dtPCProducto
     */
    public int getDtPCProducto() {
        return dtPCProducto;
    }

    /**
     * @param dtPCProducto the dtPCProducto to set
     */
    public void setDtPCProducto(int dtPCProducto) {
        this.dtPCProducto = dtPCProducto;
    }

    /**
     * @return the dtCFactura
     */
    public int getDtCFactura() {
        return dtCFactura;
    }

    /**
     * @param dtCFactura the dtCFactura to set
     */
    public void setDtCFactura(int dtCFactura) {
        this.dtCFactura = dtCFactura;
    }
    
     public float getDtSubTotal() {
        return dtSubTotal;
    }

    public void setDtSubTotal(float dtSubTotal) {
        this.dtSubTotal = dtSubTotal;
    }
    
    
    
    
}
