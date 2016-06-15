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
public class Ventas {
    private float subtotal;
    private float total;
    private String Estado;
    private int Cliente;
    private String  trabajador;

    public Ventas() {
    }

    public Ventas(float subtotal, float total, String Estado, int Cliente, String trabajador) {
        this.subtotal = subtotal;
        this.total = total;
        this.Estado = Estado;
        this.Cliente = Cliente;
        this.trabajador = trabajador;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Cliente
     */
    public int getCliente() {
        return Cliente;
    }

    /**
     * @param Cliente the Cliente to set
     */
    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    /**
     * @return the trabajador
     */
    public String getTrabajador() {
        return trabajador;
    }

    /**
     * @param trabajador the trabajador to set
     */
    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
    
    
    
    
    
    
}
