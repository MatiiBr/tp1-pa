/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;
import javax.persistence.*;

@Entity
@Table (name="cargo") 
/**
 *
 * @author Usuario
 */
public class Cargo {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo_id_seq")@SequenceGenerator(name = "cargo_id_seq", sequenceName = "cargo_id_seq", allocationSize = 1)
    private long id;
    
    @Column(name="nombre", columnDefinition = "TEXT")
    private String nombre; 

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
    
    @Override
    public String toString() {
        return this.getNombre();
    }
}
