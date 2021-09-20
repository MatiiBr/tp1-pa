package Hibernate;
import Modelos.Gestion.Contacto;
import Modelos.Gestion.Proyecto;
import java.util.List;
import org.hibernate.*;
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
     public Contacto buscarContacto(Class clase, String valor){        
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        return (Contacto) crit.list().get(0);
     }
     
     public Proyecto buscarProyecto(Class clase, String valor){        
         System.out.println(valor);
         Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (Proyecto) crit.list().get(0);
     }
     
     public List listarClase(Class clase){
        Criteria crit = getSession().createCriteria(clase);
        return crit.list();
    }
       /*public List buscarContacto(Class clase, String valor){        
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.like("nombre",  "%"+valor+"%"));
        return crit.list();
}  
       
       public int listarUltimo(Class clase){
       Criteria crit = getSession().createCriteria(clase);
        crit.setProjection(Projections.max("codigo"));
        return crit.uniqueResult()
       }*/
     
     public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }
}
