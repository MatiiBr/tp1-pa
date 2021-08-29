/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Contacto;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="contacto") 
/**
 *
 * @author Usuario
 */
public class Contacto implements Comparable, Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String nombre; 
    
    @Column(columnDefinition = "TEXT")
    private String apellido;
    
    @Column(columnDefinition = "TEXT")
    private String edad; 

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
     public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String edad) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
    }
    
    @Override
    public int compareTo(Object o) {
        Contacto p = (Contacto) o;
        return this.getNombre().compareTo(p.getNombre());
    }
}
