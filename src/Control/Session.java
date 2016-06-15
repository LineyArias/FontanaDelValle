package Control;

import Modelo.Trabajador;

/**
 *
 * @author FEWL
 */
public final class Session {
    private static final Session  sesion = new Session();
    private  Trabajador trabajador;
            
    public static Session GetSession (){
        return sesion;
    }
    
    public Trabajador GetTrabajador (){
        return trabajador;
    }
    
    public void SetTrabajador (Trabajador obj){
        this.trabajador = obj;
    }
}
