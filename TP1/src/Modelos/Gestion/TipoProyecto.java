/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table (name="tipo_proyecto") 
/**
 *
 * @author Usuario
 */
public class TipoProyecto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_proyecto_id_seq")@SequenceGenerator(name = "tipo_proyecto_id_seq", sequenceName = "tipo_proyecto_id_seq", allocationSize = 1)
        private long id;
  
    @Column(name="nombre", columnDefinition = "TEXT")
        private String nombre; 

    @Column(name="descripcion", columnDefinition = "TEXT")
        private String descripcion; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.getDescripcion();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    
    
}
