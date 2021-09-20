/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import javax.persistence.*;

@Entity
@Table (name="personal") 
/**
 *
 * @author Usuario
 */
public class Personal extends Persona {
    
    @Column(name="puesto", columnDefinition = "TEXT")
        private String puesto; 

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido() + " - " + this.getPuesto();
    }
}
