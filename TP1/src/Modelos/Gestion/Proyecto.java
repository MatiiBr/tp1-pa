/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table (name="proyecto") 
/**
 *
 * @author Usuario
 */
public class Proyecto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto_id_seq")@SequenceGenerator(name = "proyecto_id_seq", sequenceName = "proyecto_id_seq", allocationSize = 1)
    private long id;
    
    @Column(name="nombre", columnDefinition = "TEXT")
        private String nombre; 
     
    @Column(name="fechaEntrega", columnDefinition = "Date")
       private Date fechaEntrega; 

    @Column(name="fechaCarga", columnDefinition = "Date")
       private Date fechaCarga; 

    @Column(name="fechaConfirmacion", columnDefinition = "Date")
       private Date fechaConfirmacion; 

    @Column(name="fechaTerminacion", columnDefinition = "Date")
       private Date fechaTerminacion; 
    
    @OneToOne (targetEntity = TipoProyecto.class, cascade= CascadeType.DETACH,fetch=FetchType.LAZY)
        private TipoProyecto tipoProyecto;
    
    @OneToOne (targetEntity = Cliente.class, cascade= CascadeType.DETACH,fetch=FetchType.LAZY)
        private Cliente cliente;
    
    @OneToOne (targetEntity = Personal.class, cascade= CascadeType.DETACH,fetch=FetchType.LAZY)
        private Personal personal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public TipoProyecto getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
}
