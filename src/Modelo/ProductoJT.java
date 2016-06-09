package Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FEWL
 */
public class ProductoJT extends AbstractTableModel{
    private String[] columnNames = {"CÓDIGO","NOMBRE","CANTIDAD","PRECIO $"};;
    ArrayList<Producto> data;
    
    public ArrayList<Producto> getLstdatos(){
        return data;
    }
    
    public void setLstdatos(ArrayList<Producto> lstdoc){
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
    
    public Producto getFila(int row){
        return (Producto)(data.get(row));
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
        Producto macData = (Producto) (data.get(row));
        switch(col){
            case 0:
                macData.setPrCodigo((int)value);
                break;
        case 1:
                macData.setPrDescripcion((String)value);
                break;  
        case 2:
                macData.setPrCantidad((int)value);
                break;
        case 3:
                macData.setPrPrecio((float)value);
                break;  
           
        }
      
    }
    
   @Override
    public Object getValueAt(int row, int col) {
      Producto macData = (Producto) (data.get(row));
        switch(col){
            case 0:
               return macData.getPrCodigo();
        
                
        case 1:
                return macData.getPrDescripcion();
         
        case 2:
                return macData.getPrCantidad();
           
        case 3:
               return  macData.getPrPrecio();  
                          
        }
        return new String();
    }
}
