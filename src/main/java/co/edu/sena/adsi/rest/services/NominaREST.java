package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Nomina;
import co.edu.sena.adsi.jpa.sessions.NominaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rootbean
 */
@Path("nominas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NominaREST {
    
    @EJB
    private NominaFacade nominaEJB;
    
    @GET
    public List<Nomina> findAll(){
        return nominaEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Nomina findById(@PathParam("id") Integer id){
        return nominaEJB.find(id);
    }
    
    @POST
    public void create(Nomina nomina){
        nominaEJB.create(nomina);
    }
    
}
