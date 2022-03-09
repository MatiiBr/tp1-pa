package Hibernate;
import Modelos.Gestion.Cargo;
import Modelos.Gestion.Cliente;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Contacto;
import Modelos.Gestion.Personal;
import Modelos.Gestion.Proyecto;
import Modelos.Gestion.TipoProyecto;
import Modelos.Gestion.Perfil;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
        if(crit.list().isEmpty()){
            return null;
        }
        return (Contacto) crit.list().get(0);
     }
     public List buscarContactos(Class clase, String nombre, String apellido, Date fechaDesde, Date fechaHasta){
        Criteria crit = getSession().createCriteria(clase)
                 .add(Restrictions.like("nombre",  "%"+nombre+"%"));
        crit.add(Restrictions.like("apellido", "%"+apellido+"%"));
        if (fechaDesde != null) {
            crit.add(Restrictions.ge("fechaNacimiento", fechaDesde));
        }
        if (fechaHasta != null) {
            crit.add(Restrictions.le("fechaNacimiento", fechaHasta));
        }
        if (crit.list().isEmpty()) {
            return null;
        }
        return crit.list();
    }
     public Proyecto buscarProyectoPorId(Class clase, Long valor){        
         Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("id", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (Proyecto) crit.list().get(0);
     }
      
    public List buscarProyectos(Class clase, String nombre, Cliente cliente, TipoProyecto tipoProyecto, Personal personal, Date fechaDesde, Date fechaHasta){
         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.like("nombre",  "%"+nombre+"%"));
         if(cliente != null){
             crit.add( Restrictions.eq("cliente", cliente));
         }
         if(tipoProyecto != null){
             crit.add( Restrictions.eq("tipoProyecto", tipoProyecto));
         }
         if(personal != null){
             crit.add( Restrictions.eq("personal", personal));
         }
         if (fechaDesde != null) {
            crit.add(Restrictions.ge("fechaCarga", fechaDesde));
        }
        if (fechaHasta != null) {
            crit.add(Restrictions.le("fechaCarga", fechaHasta));
        }
        if (crit.list().isEmpty()){
            return null;
        }
        return crit.list();
     }
    public Proyecto buscarProyectoPorNombre(Class clase, String valor){        
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (Proyecto) crit.list().get(0);
     }
    public List buscarClientes(Class clase, String nombre, String apellido, Date fechaDesde, Date fechaHasta){
        Criteria crit = getSession().createCriteria(clase)
                 .add(Restrictions.like("nombre",  "%"+nombre+"%"));
        crit.add(Restrictions.like("apellido", "%"+apellido+"%"));
        if (fechaDesde != null) {
            crit.add(Restrictions.ge("fechaNacimiento", fechaDesde));
        }
        if (fechaHasta != null) {
            crit.add(Restrictions.le("fechaNacimiento", fechaHasta));
        }
        if (crit.list().isEmpty()) {
            return null;
        }
        return crit.list();
    }
      public Cliente buscarCliente(Class clase, String valor){        
         Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (Cliente) crit.list().get(0);
     }
      
      public Personal buscarPersonal(Class clase, String valor){
         Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (Personal) crit.list().get(0);
     }
    public List buscarPersonales(Class clase, String nombre, String apellido, Cargo cargo, Date fechaDesde, Date fechaHasta){
        Criteria crit = getSession().createCriteria(clase)
                 .add(Restrictions.like("nombre",  "%"+nombre+"%"));
        crit.add(Restrictions.like("apellido", "%"+apellido+"%"));
        if(cargo != null){
             crit.add( Restrictions.eq("cargo", cargo));
         }
        if (fechaDesde != null) {
            crit.add(Restrictions.ge("fechaNacimiento", fechaDesde));
        }
        if (fechaHasta != null) {
            crit.add(Restrictions.le("fechaNacimiento", fechaHasta));
        }
        if (crit.list().isEmpty()) {
            return null;
        }
        return crit.list();
    }
     
    public Perfil buscarPerfil(Class clase, String valor){     
       Criteria crit = getSession().createCriteria(clase)
          .add( Restrictions.eq("nombre", valor));
      if (crit.list().isEmpty()){
          return null;
      }
      return (Perfil) crit.list().get(0);
   }
    public List buscarPerfiles(Class clase, String nombre, String descripcion){
        Criteria crit = getSession().createCriteria(clase)
                 .add(Restrictions.like("nombre",  "%"+nombre+"%"));
        crit.add(Restrictions.like("descripcion", "%"+descripcion+"%"));
        if (crit.list().isEmpty()) {
            return null;
        }
        return crit.list();
    }
       public TipoProyecto buscarTipoProyecto(Class clase, String valor){        
         System.out.println(valor);
         Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.eq("nombre", valor));
        if (crit.list().isEmpty()){
            return null;
        }
        return (TipoProyecto) crit.list().get(0);
     }
    public List buscarTipoProyecto(Class clase, String nombre, String descripcion){
        Criteria crit = getSession().createCriteria(clase)
                 .add(Restrictions.like("nombre",  "%"+nombre+"%"));
        crit.add(Restrictions.like("descripcion", "%"+descripcion+"%"));
        if (crit.list().isEmpty()) {
            return null;
        }
        return crit.list();
    }
     public List listarClase(Class clase){
        Criteria crit = getSession().createCriteria(clase);
        if (crit.list().isEmpty()){
            return null;
        }
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
