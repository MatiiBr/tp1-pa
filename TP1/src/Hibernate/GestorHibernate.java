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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Usuario
 */
public class GestorHibernate extends HibernateUtil {
    private Transaction tx;
    
     public void guardarObjeto(Object objeto){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
         try{
            s.save(objeto);        
            tx.commit();
        } catch(Exception ex){
            System.out.println("error "+ex);
            ex.printStackTrace();
            tx.rollback();
        }
    }
     public boolean actualizarObjeto(Object objeto){
          Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try{
            s.update(objeto);
            tx.commit();
            return true;
        }catch(HibernateException e){
             System.out.println("error "+e);
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }
     
     public boolean eliminarObjeto(Object objeto){
         Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try{
            s.delete(objeto);
            tx.commit();
            return true;
        }catch(HibernateException e){
             System.out.println("error "+e);
            e.printStackTrace();
            tx.rollback();
            return false;
        }
     }
       public List buscarContacto(Class clase, String valor){        
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        return crit.list();
}  
     
     public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }
}
