/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Contacto;

import javax.persistence.*;

@Entity
@Table (name="contacto") 
/**
 *
 * @author Usuario
 */
public class Contacto implements Comparable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellido;
    private int estado;
    
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Contacto() {
    }

    public Contacto(String nombre, String apellido) {
        this.setNombre(nombre);
        this.setApellido(apellido);
    }
    
    @Override
    public int compareTo(Object o) {
        Contacto p = (Contacto) o;
        return this.getNombre().compareTo(p.getNombre());
    }
}
