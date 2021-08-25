/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Hibernate.HibernateUtil;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
/**
 *
 * @author Usuario
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         HibernateUtil.inicializar();
         GestorMenuPrincipal gestorMenu = new GestorMenuPrincipal();
          gestorMenu.iniciarMenu();
        // TODO code application logic here
    }
    
}
