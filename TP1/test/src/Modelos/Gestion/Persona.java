/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table (name="persona") 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/**
 *
 * @author Usuario
 */
public class Persona {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_seq")@SequenceGenerator(name = "persona_id_seq", sequenceName = "persona_id_seq", allocationSize = 1)
    private long id;
    
    @Column(name="nombre", columnDefinition = "TEXT")
    private String nombre; 
    
    @Column(name="apellido", columnDefinition = "TEXT")
    private String apellido;
    @Column(name="fechaNacimiento", columnDefinition = "Date")
        private Date fechaNacimiento; 
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
