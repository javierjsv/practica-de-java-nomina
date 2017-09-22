
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rootbean
 */
@Entity
@Table(name = "nominas")
public class Nomina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    private int mes;
    
    @OneToMany(mappedBy = "nomina")
    private List<DetalleNomina> detalleNominaList;

    public Nomina() {
    }

    public Nomina(Integer id) {
        this.id = id;
    }

    public Nomina(Integer id, String descripcion, int mes) {
        this.id = id;
        this.descripcion = descripcion;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public List<DetalleNomina> getDetalleNominaList() {
        return detalleNominaList;
    }

    public void setDetalleNominaList(List<DetalleNomina> detalleNominaList) {
        this.detalleNominaList = detalleNominaList;
    }
    
    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + '}';
    }
    

}
