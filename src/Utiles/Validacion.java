package Utiles;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FEWL
 */
public class Validacion {
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public void soloNumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }
    public void soloLetras(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
    }
    
    
    public boolean esApellidoValido(String apellido){
        return apellido.trim().length() >0;
    }
    public boolean esNombreValido(String nombre){
        return nombre.trim().length() >0;
    }
    public boolean esUserNameValido(String username){
        return username.length() >4 && username.trim().length() <8;
    }
     public boolean esidentificacion(String username){
        return username.length() >6 && username.trim().length() <13;
    }
    
    public boolean esDiaOMesValido(String str){
        return str.length() == 2;
    }
    
    public boolean esAnioValido(String anio){
        return anio.length() == 4;
    }
    public boolean esPrecio(int precio ){
      return precio > 100;
    }
    public  boolean esEmail (String email) {
        try {
             Pattern pattern = Pattern.compile(PATTERN_EMAIL);
             Matcher matcher = pattern.matcher(email);
             return matcher.matches();
             }catch(Exception e){
                     e.printStackTrace();
             }
        return false;
    }
    public boolean esHabitacionValida(String apellido){
        return apellido.trim().length() >2;
    }   

   
}
