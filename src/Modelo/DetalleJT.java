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
 * @author FEWL
 */
public class DetalleJT extends AbstractTableModel{
    private String[] columnNames = {"DESCRIPCIÓN","CANTIDAD","PRECIO","SUBTOTAL $", "ACCIÓN"};
    ArrayList<Detalle> data;
    
    public ArrayList<Detalle> getLstdatos(){
        return data;
    }
    
    public void setLstdatos(ArrayList<Detalle> lstdoc){        
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
    
    public Detalle getFila(int row){
        return (Detalle)(data.get(row));
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
        Detalle macData = (Detalle) (data.get(row));
        switch(col){
            case 0:
                macData.setDtDescripcion((String)value);
                break;
        case 1:
                macData.setDtCantidad((int)value);
                break;  
        case 2:
                macData.setDtPrecio((float)value);
                break;
        case 3:
                macData.setDtSubTotal((float) value);
                break;  
        case 4:
           macData.setDtPCProducto((int) value);
           break;  
           
        }
      
    }
    
   @Override
    public Object getValueAt(int row, int col) {
      Detalle macData = (Detalle) (data.get(row));
        switch(col){
            case 0:
               return macData.getDtDescripcion();                        
        case 1:
                return macData.getDtCantidad();
         
        case 2:
                return macData.getDtPrecio();
           
        case 3:
               return  macData.getDtSubTotal();  
            
        case 4:
           return  macData.getDtSubTotal();  
                          
        }
        return new String();
    }
}
