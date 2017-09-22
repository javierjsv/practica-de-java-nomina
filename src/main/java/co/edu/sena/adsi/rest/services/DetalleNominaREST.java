package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.DetalleNomina;
import co.edu.sena.adsi.jpa.entities.Nomina;
import co.edu.sena.adsi.jpa.entities.Usuario;
import co.edu.sena.adsi.jpa.sessions.DetalleNominaFacade;
import co.edu.sena.adsi.jpa.sessions.NominaFacade;
import co.edu.sena.adsi.jpa.sessions.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rootbean
 */
@Path("detalle_nominas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DetalleNominaREST {

    @EJB
    private DetalleNominaFacade detalleNominaEJB;

    @EJB
    private UsuarioFacade usuarioEJB;

    @EJB
    private NominaFacade nominaEJB;

    @GET
    public List<DetalleNomina> findAll() {
        return detalleNominaEJB.findAll();
    }

    @GET
    @Path("{id}")
    public DetalleNomina findById(@PathParam("id") Integer id) {
        return detalleNominaEJB.find(id);
    }

    @POST
    public void create(
            @QueryParam("idUsuario") Integer idUsuario,
            @QueryParam("diasLaborados") Integer diasLaborados,
            @QueryParam("idNomina") Integer idNomina
    ) 
    
    {

        DetalleNomina newDetalleNomina = new DetalleNomina();

        Usuario empleado = usuarioEJB.find(idUsuario);
        Nomina nomina = nominaEJB.find(idNomina);

        try {
            newDetalleNomina.setSueldoDevengado(empleado.getSueldoBasico() / 30 * diasLaborados);
            
            //auxlio Trasporte
            
            newDetalleNomina.setAuxilioTransporte(AuxTransporte(empleado.getSueldoBasico() , diasLaborados));
            
            //horas extras   sueldoDevengado * 10 %
            
            newDetalleNomina.setValorHorasExtras(newDetalleNomina.getSueldoDevengado() * 0.10);

             newDetalleNomina.setSueldoDevengado(newDetalleNomina.getSueldoDevengado()* 0.10);
             
             //total devengado  = sueldo devengado + au transporte + horas extras
             
             newDetalleNomina.setTotalDevengado(
             newDetalleNomina.getSueldoDevengado()+
             newDetalleNomina.getAuxilioTransporte()+
             newDetalleNomina.getValorHorasExtras()
             
             );
             
         
             //El sistema debe calcular el aporte a salud por empleado.
             //(Para este concepto se debe restar el aux_transporte al total devengado y el resultado multiplicarlo por el 4%).
             
             newDetalleNomina.setDescuentoSalud((newDetalleNomina.getTotalDevengado()-newDetalleNomina.getAuxilioTransporte()) * 0.04);
             
             
             //El sistema debe calcular el aporte a pensión por empleado.(
             //Para este concepto se debe restar el aux_transporte al total devengado y el resultado multiplicarlo por el 4%).

             
             newDetalleNomina.setDescuentoPension((newDetalleNomina.getAuxilioTransporte() - newDetalleNomina.getTotalDescuento()) * 0.04);
             
             
         
           // descuento adicionales = 300000
            //El sistema debe calcular los descuentos adicionales. (Para este caso asignar un valor de $300.000).
            
            newDetalleNomina.setOtrosDescuentos(300000);
            
            
            // fonso solidaridad  1 %  suedo basico > 4 salarios mimos 
            //El sistema debe calcular el fondo_solidaridad. (Se debe tener en cuenta que un empleado debe pagar por fondo_solidaridad el 1% del total devengado
            //si su sueldo_basico supera o es igual a 4 salarios mínimos)
            
            newDetalleNomina.setDescuentoFondoSolidaridad(fondoSolidario(empleado.getSueldoBasico(),newDetalleNomina.getTotalDevengado()));
            
            
            //El sistema debe calcular el total_descuentos (aporte_salud + aporte_pension + fondo_solidaridad + descuentos_adicionales).

            newDetalleNomina.setTotalDescuento(
            newDetalleNomina.getDescuentoSalud() +
            newDetalleNomina.getDescuentoPension() +
            newDetalleNomina.getDescuentoFondoSolidaridad() +
            newDetalleNomina.getOtrosDescuentos()
            );
            
            //El sistema debe calcular  el neto a pagar (total_devengado - total_descuento).
            
//            newDetalleNomina.setNetoPagar(newDetalleNomina.getTotalDevengado()- newDetalleNomina.getOtrosDescuentos());
            newDetalleNomina.setNetoPagar(newDetalleNomina.getTotalDevengado()- newDetalleNomina.getTotalDescuento());
            
            
            
            newDetalleNomina.setNomina(nomina);
            newDetalleNomina.setEmpleado(empleado);
//            newDetalleNomina.setId(1);
            newDetalleNomina.setDiasLaborados(diasLaborados);
            
            detalleNominaEJB.create(newDetalleNomina);
             
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    private double AuxTransporte(double sueldoBasico, int diasLaborados) {
        double auxTransporte = 0;
        if (sueldoBasico <= 737717 * 2) {
            auxTransporte = 83140 / 30 * diasLaborados;

        }
        return auxTransporte;

    }
    
    
    // fonso solidaridad  1 %  suedo basico > 4 salarios mimos 
            //El sistema debe calcular el fondo_solidaridad. (Se debe tener en cuenta que un empleado debe pagar por fondo_solidaridad el 1% del total devengado
            //si su sueldo_basico supera o es igual a 4 salarios mínimos)
    
    private double fondoSolidario(double sueldoBasico,double sueldoDevengado){
           double fondoSolidario = 0;
    if(sueldoBasico >= 737317 * 4){
       fondoSolidario = sueldoDevengado * 0.01 ;
    
        
    }
    return fondoSolidario;
    }
            

}
