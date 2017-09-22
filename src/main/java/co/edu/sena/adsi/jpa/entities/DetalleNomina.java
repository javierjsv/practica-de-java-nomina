
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rootbean
 */
@Entity
@Table(name = "detalle_nomina")
public class DetalleNomina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_laborados")
    private int diasLaborados;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo_devengado")
    private double sueldoDevengado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "auxilio_transporte")
    private double auxilioTransporte;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_horas_extras")
    private double valorHorasExtras;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_salud")
    private double descuentoSalud;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_pension")
    private double descuentoPension;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_fondo_solidaridad")
    private double descuentoFondoSolidaridad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "otros_descuentos")
    private double otrosDescuentos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_devengado")
    private double totalDevengado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_descuento")
    private double totalDescuento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "neto_pagar")
    private double netoPagar;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario empleado;
    
    @JoinColumn(name = "id_nomina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nomina nomina;

    public DetalleNomina() {
    }

    public DetalleNomina(Integer id) {
        this.id = id;
    }

    public DetalleNomina(Integer id, int diasLaborados, double sueldoDevengado, double auxilioTransporte, double valorHorasExtras, double descuentoSalud, double descuentoPension, double descuentoFondoSolidaridad, double otrosDescuentos, double totalDevengado, double totalDescuento, double netoPagar) {
        this.id = id;
        this.diasLaborados = diasLaborados;
        this.sueldoDevengado = sueldoDevengado;
        this.auxilioTransporte = auxilioTransporte;
        this.valorHorasExtras = valorHorasExtras;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.descuentoFondoSolidaridad = descuentoFondoSolidaridad;
        this.otrosDescuentos = otrosDescuentos;
        this.totalDevengado = totalDevengado;
        this.totalDescuento = totalDescuento;
        this.netoPagar = netoPagar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public double getSueldoDevengado() {
        return sueldoDevengado;
    }

    public void setSueldoDevengado(double sueldoDevengado) {
        this.sueldoDevengado = sueldoDevengado;
    }

    public double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public double getValorHorasExtras() {
        return valorHorasExtras;
    }

    public void setValorHorasExtras(double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }

    public double getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(double descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public double getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(double descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    public double getDescuentoFondoSolidaridad() {
        return descuentoFondoSolidaridad;
    }

    public void setDescuentoFondoSolidaridad(double descuentoFondoSolidaridad) {
        this.descuentoFondoSolidaridad = descuentoFondoSolidaridad;
    }

    public double getOtrosDescuentos() {
        return otrosDescuentos;
    }

    public void setOtrosDescuentos(double otrosDescuentos) {
        this.otrosDescuentos = otrosDescuentos;
    }

    public double getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(double totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public double getNetoPagar() {
        return netoPagar;
    }

    public void setNetoPagar(double netoPagar) {
        this.netoPagar = netoPagar;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    @Override
    public String toString() {
        return "DetalleNomina{" + "id=" + id + '}';
    }
   
    
}
