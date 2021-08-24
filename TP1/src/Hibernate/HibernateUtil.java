package Hibernate;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author Usuario
 */
public class HibernateUtil {
    public static SessionFactory sessionFactory;
    public static Session session;
    
    public static void inicializar() {
        try {
           Configuration conf = new Configuration(); 
           try{
                conf.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
                conf.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");                 
                conf.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/tp1");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de Base de Datos Nº 2001");
            }
            
            conf.setProperty("hibernate.connection.username","postgres");
            conf.setProperty("hibernate.connection.password","");

            conf.setProperty("hibernate.connection.pool_size","10");                          
//            conf.setProperty("hibernate.hbm2ddl.auto","update");

            conf.addPackage("Modelos.GestionProyecto");
            conf.addAnnotatedClass(Modelos.GestionProyecto.Proyecto.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.TipoProyecto.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.ItemProyecto.class);
           
            try {
                    sessionFactory = conf.buildSessionFactory();
                    session=sessionFactory.openSession();
                }
                catch(HibernateException e){
                    JOptionPane.showMessageDialog(null, e);
                }
        } catch (HeadlessException ex) {
            throw new ExceptionInInitializerError(ex);
        } catch (MappingException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()
    throws HibernateException {
        return session;
    }
}
