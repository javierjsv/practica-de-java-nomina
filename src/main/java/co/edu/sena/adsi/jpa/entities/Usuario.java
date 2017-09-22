
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rootbean
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "nombres")
    private String nombres;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 8, max = 15)
    @Column(name = "num_documento")
    private String numDocumento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 50)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 100)
    @Column(name = "password")
    private String password;
    
    @Size(min = 5, max = 40)
    @Column(name = "direccion")
    private String direccion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo_basico")
    private double sueldoBasico;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Cargo cargo;
    
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
    @OneToOne(optional = false)
    private TipoDocumento tipoDocumento;
    
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Ciudad ciudad;

    //OneToMany
    @OneToMany(mappedBy = "jefeInmediato")
    private List<Usuario> usuariosList;
   
    //ManyToOne
    @JoinColumn(name = "id_jefe_inmediato", referencedColumnName = "id")
    @ManyToOne
    private Usuario jefeInmediato;

    @OneToMany(mappedBy = "empleado")
    private List<DetalleNomina> detalleNominaList;
    
    @OneToMany(mappedBy = "usuario")
    private List<UsuariosHasRoles> usuariosHasRolesList;
    
    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }
   

    public Usuario(Integer id, String nombres, String apellidos, String numDocumento, String email, String password, double sueldoBasico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numDocumento = numDocumento;
        this.email = email;
        this.password = password;
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    @XmlTransient
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }
   

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Usuario getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(Usuario jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }
     @XmlTransient
    public List<DetalleNomina> getDetalleNominaList() {
        return detalleNominaList;
    }

    public void setDetalleNominaList(List<DetalleNomina> detalleNominaList) {
        this.detalleNominaList = detalleNominaList;
    }

    public List<UsuariosHasRoles> getUsuariosHasRolesList() {
        return usuariosHasRolesList;
    }
    
    public void setUsuariosHasRolesList(List<UsuariosHasRoles> usuariosHasRolesList) {
        this.usuariosHasRolesList = usuariosHasRolesList;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + '}';
    }
    
}
