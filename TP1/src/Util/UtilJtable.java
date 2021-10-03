package Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Juan
 */
public class UtilJtable {
//     public static final boolean editable=true;
//        public static final boolean noEditable=false;
//        public static final boolean fijas=false;
//        public static final boolean noFijas=false;
//        
//    public void newModelTable(JTable tbl, String[] titulo, String[] ancho,boolean edit) {
//        if (edit==true) 
//            this.newModelJS(tbl, titulo);
//        else
//            this.newModelJSNotEdit(tbl, titulo);
//      
//        //para inmovilizar las columnas
//        tbl.getTableHeader().setReorderingAllowed(false);
//        tbl.getTableHeader().setResizingAllowed(false);
//        this.anchoTabla(tbl,ancho);
//
//    } 
//    public void newModelTableResizable(JTable tbl, String[] titulo, String[] ancho,boolean edit) {
//        if (edit==true)
//            this.newModelJS(tbl, titulo);
//        else
//            this.newModelJSNotEdit(tbl, titulo);
//
//        //para inmovilizar las columnas
//        tbl.getTableHeader().setReorderingAllowed(false);
//        tbl.getTableHeader().setResizingAllowed(true);
//        this.anchoTabla(tbl,ancho);
//
//    }
// con el tiempo hay que desabilitarlo 
//    public void newModel(JTable table, String [] titulo){
//        table.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {},titulo) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });        
//    }  
//    
    public void newModelJS(JTable table, String [] titulo){
        table.setModel(new DefaultTableModelJS(
            new Object [][] {},titulo) {
            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class, 
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class,
                java.lang.Object.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }  
//    
//    public void newModelJSNotEdit(JTable table, String [] titulo){
//        table.setModel(new DefaultTableModelJSNotEdit(
//            new Object [][] {},titulo) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//    }  
//    
//  
//    public void newModelJS(JTable table, String [] titulo,int nroColumnaEditable){
//        table.setModel(new DefaultTableModelJS(
//            new Object [][] {},titulo,nroColumnaEditable) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//    }  
//
//    public void newModelJS(JTable table, String [] titulo,int nroColumnaEditable,int nroColumnaEditable2){
//        table.setModel(new DefaultTableModelJS(
//            new Object [][] {},titulo,nroColumnaEditable,nroColumnaEditable2) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//    }
//
//    public void newModelJS(JTable table, String [] titulo,int nroColumnaEditable,int nroColumnaEditable2,int nroColumnaEditable3){
//        table.setModel(new DefaultTableModelJS(
//            new Object [][] {},titulo,nroColumnaEditable,nroColumnaEditable2,nroColumnaEditable3) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//    }
//
//    public static DefaultTableModel newModelTable(String[] titulo, boolean noEditable) {
//       return new DefaultTableModel(
//            new Object [][] {},titulo) {
//            Class[] types = new Class [] {    //aca tengo quee poner toda la cantidad de objeto//
//                               java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class, 
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class,
//                java.lang.Object.class
//            };
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        };
//    }
//    
//    public void newModelJS(JTable tbl, String[] titulo, String[] ancho, int columnaEditable) {
//        this.newModelJS(tbl, titulo, columnaEditable);
//        this.anchoTabla(tbl, ancho);
//    }
//
//    public void newModelJS(JTable tbl, String[] titulo, String[] ancho, int columnaEditable,int columnaEditable2) {
//        this.newModelJS(tbl, titulo, columnaEditable,columnaEditable2);
//        this.anchoTabla(tbl, ancho);
//    }
//
//    public void newModelJS(JTable tbl, String[] titulo, String[] ancho, int columnaEditable,int columnaEditable2,int columnaEditable3) {
//        this.newModelJS(tbl, titulo, columnaEditable,columnaEditable2,columnaEditable3);
//        this.anchoTabla(tbl, ancho);
//    }
    
    //convertidores
    public static HashSet convertToSet (JTable table ) {
         HashSet set=new HashSet();
         int i=0;
         for(i=0;i<table.getRowCount();i++){
             set.add(table.getValueAt(i, 0));
          }
         return set;  
    }
    
    public static TreeSet convertToTreeSet (JTable table ) {
        TreeSet set= new TreeSet();
        int i=0;
        for (i=0;i<table.getRowCount();i++){
            set.add(table.getValueAt(i, 0));}
        return set;  
    }   

    public static TreeSet convertToTreeSet (List table ) {
        TreeSet set= new TreeSet();
        int i=0;
        for (i=0;i<table.size();i++){
            set.add(table.get(i));}
        return set;
    }


    public static TreeSet convertirHashSetToTreeSet(Set lista){
        TreeSet set= new TreeSet();
         Iterator ite = lista.iterator();
         while(ite.hasNext()){
             set.add(ite.next());
         }
         return set;
    }
    
     public static DefaultListModel convertirTreeSetToModelo(Set lista) {
        DefaultListModel modelo= new DefaultListModel();
        Iterator it = lista.iterator();
        while(it.hasNext())
         {
            modelo.addElement(it.next());
         }
        return modelo;
    
    }   
  
     public static List convertirSetToLista(Set lista) {
        List modelo= new ArrayList();
        int i=0;
        Iterator it = lista.iterator();
        while(it.hasNext())
         {
            modelo.add(it.next());
         }
        return modelo;
    
    }
     
    public static Set convertToSet (JList list ) {
         DefaultListModel modeloLista=(DefaultListModel) list.getModel();
         Set set=new HashSet();
         int i=0;
         for(i=0;i<modeloLista.getSize();i++){
            set.add(modeloLista.getElementAt(i));  }
         
         return set;  

    }
    
   public DefaultComboBoxModel convertirArrayToModelo(String[] array) {
        DefaultComboBoxModel modeloAux= new DefaultComboBoxModel();
        int i=0;
        for(i=0;i<array.length ;i++){
          if  (array[i].equals("")){}
          else 
           modeloAux.addElement(array[i]);
         }
         return modeloAux;  
    }
      //fin convertidores 
    
    /** datos a pasar ancho de la columna, cada subindice del string es la columna que pas
     * @param tablao*/
    public void anchoTabla(JTable tabla, String[] columnas){
        TableColumn column = null;
        //Iterator ite = columnas.iterator();
        for(int i=0;i<columnas.length;i++){
            column = tabla.getColumnModel().getColumn(i);
            column.setPreferredWidth(Integer.parseInt(columnas[i]));

        }
    }

    public void columnaInvisibleTabla(JTable tabla, int indice){
        TableColumn column = null;
        column = tabla.getColumnModel().getColumn(indice);
        tabla.removeColumn(column);
    }

}
