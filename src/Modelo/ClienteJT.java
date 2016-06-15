/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leam
 */
public class ClienteJT extends AbstractTableModel {
    
     private String[] columnNames = {"IDENTIFICACIÓN","NOMBRE","APELLIDO","DIRECCIÓN","TELEFONO", "CORREO", "CIUDAD"};
    ArrayList<Cliente> data;
    
    public ArrayList<Cliente> getLstdatos(){
        return data;
    }
    
    public void setLstdatos(ArrayList<Cliente> lstdoc){        
        this.data = lstdoc;
    }
    
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public int getRowCount() {
         return data.size();
    }

    
     @Override
    public String getColumnName(int col) {
       return columnNames[col];
    }
    
    @Override
    public Class getColumnClass(int c) {
        
       Object value = this.getValueAt(0,c);
       return (value == null ? Object.class : value.getClass());
    }
    
    public Cliente getFila(int row){
        return (Cliente)(data.get(row));
    }
     
      @Override
      public boolean isCellEditable(int row, int col){
         if(col < 4){
             return false;
         } else{
             return true;
         }
      }
 
      
    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente macData = (Cliente) (data.get(row));
        switch(col){
            case 0:
                macData.setIdentificacion((String)value);
                break;
        case 1:
                macData.setNombre((String)value);
        case 2:
                macData.setApellidos((String)value);
                break;
        case 3:
                macData.setDireccion((String) value);
                break;  
        case 4:
           macData.setTelefono((String) value);
        case 5:
           macData.setEmail((String) value);
        case 6:
           macData.setCiudad((String) value);
           break;  
           
        }
      
    }
    
   @Override
    public Object getValueAt(int row, int col) {
     Cliente macData = (Cliente) (data.get(row));
        switch(col){
            case 0:
               return macData.getIdentificacion();                        
        case 1:
                return macData.getNombre();
         
        case 2:
                return macData.getApellidos();
           
        case 3:
               return  macData.getDireccion();  
            
        case 4:
           return  macData.getTelefono();  
            
        case 5:
           return  macData.getEmail();  
            
        case 6:
           return  macData.getCiudad();        
        }
        return new String();
    }
}
