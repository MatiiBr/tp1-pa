package Hibernate;
import GUtilr.Util;
import com.sun.mail.imap.protocol.Item;
import java.awt.Component;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author Usuario
 */
public class GestorHibernate extends HibernateUtil {
    private Transaction tx;
    
     public void guardarObjeto(Object objeto){
        try{
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        s.save(objeto);        
        tx.commit();
         //System.out.println(" guardaractualizarObjeto() " +objeto.getClass()+": "+objeto.toString());  
        } catch(Exception ex){
            System.out.println("error "+ex);
            //System.out.println("Repositorio.guardarObjeto(Object objeto)"+objeto.getClass()+": "+objeto.toString()+ex);
            ex.printStackTrace();
            getTx().rollback();
        }
    }
     public List listarUltimo(Class clase) {
         CriteriaBuilder crit = getSession().getCriteriaBuilder();
         CriteriaQuery<Item> cr = crit.createQuery(Item.class);
         Root<Item> root = cr.from(Item.class);
         cr.select(root);
         
        Query<Item> query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        return results; 
    }
     
     public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }
}
