/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import javax.persistence.*;

@Entity
@Table (name="cliente") 
/**
 *
 * @author Usuario
 */
public class Cliente extends Persona  {
    
     public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
}
