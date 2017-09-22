
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Ciudad;
import co.edu.sena.adsi.jpa.sessions.CiudadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rootbean
 */
@Path("ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadesREST {
    
    @EJB
    private CiudadFacade ciudadEJB;
    
    @GET
    public List<Ciudad> findAll(){
        return ciudadEJB.findAll();
    }
    
}
