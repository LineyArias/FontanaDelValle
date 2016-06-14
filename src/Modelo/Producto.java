package Modelo;

/**
 *
 * @author FEWL
 */
public class Producto {
    private int prCodigo;
    private String prDescripcion;
    private String prEstado;
    private int prCantidad;
    private float prPrecio;

    public Producto(int prCodigo, String prDescripcion, String prEstado, int prCantidad, float prPrecio) {
        this.prCodigo = prCodigo;
        this.prDescripcion = prDescripcion;
        this.prEstado = prEstado;
        this.prCantidad = prCantidad;
        this.prPrecio = prPrecio;
    }
    
    public Producto(int prCodigo, String prDescripcion) {
        this.prCodigo = prCodigo;
        this.prDescripcion = prDescripcion;        
    }
    

    
    public Producto(){}
    
    public int getPrCodigo() {
        return prCodigo;
    }

    public void setPrCodigo(int prCodigo) {
        this.prCodigo = prCodigo;
    }

    public String getPrDescripcion() {
        return prDescripcion;
    }

    public void setPrDescripcion(String prDescripcion) {
        this.prDescripcion = prDescripcion;
    }

    public String getPrEstado() {
        return prEstado;
    }

    public void setPrEstado(String prEstado) {
        this.prEstado = prEstado;
    }

    public int getPrCantidad() {
        return prCantidad;
    }

    public void setPrCantidad(int prCantidad) {
        this.prCantidad = prCantidad;
    }

    public float getPrPrecio() {
        return prPrecio;
    }

    public void setPrPrecio(float prPrecio) {
        this.prPrecio = prPrecio;
    }
    
     @Override
    public String toString()
    {
        return prDescripcion;
    }
    
    
}
