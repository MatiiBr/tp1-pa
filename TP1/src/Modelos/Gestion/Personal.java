/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="personal") 
/**
 *
 * @author Usuario
 */
public class Personal extends Persona implements Serializable {
    
     @OneToOne (targetEntity = Cargo.class, cascade= CascadeType.DETACH,fetch=FetchType.LAZY)
        private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido() + " - " + this.getCargo();
    }
}
