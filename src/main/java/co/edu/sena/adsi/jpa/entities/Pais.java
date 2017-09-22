
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rootbean
 */
@Entity
@Table(name = "paises")
public class Pais implements Serializable{
    
    @Id
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    
    //Relación OneToMany con Departamentos
    @OneToMany(mappedBy = "pais")
    private List<Departamento> departamentosList;

    public Pais() {
    }

    public Pais(String id) {
        this.id = id;
    }

    public Pais(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Departamento> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamento> departamentosList) {
        this.departamentosList = departamentosList;
    }
    
    @Override
    public String toString() {
        return "Pais{" + "id=" + id + '}';
    }
    
}
