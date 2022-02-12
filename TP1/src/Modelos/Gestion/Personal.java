/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "personal_perfil",
            joinColumns = @JoinColumn(name = "personal_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles = new ArrayList<>();
    public void addEmployee(Perfil perfil) {
        perfiles.add(perfil);
        perfil.getPersonales().add(this);
    }
    public void removeEmployee(Perfil perfil) {
        perfiles.remove(perfil);
        perfil.getPersonales().remove(this);
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
}
