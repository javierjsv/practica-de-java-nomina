
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Cargo;
import co.edu.sena.adsi.jpa.sessions.CargoFacade;
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
@Path("cargos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CargosREST {
    
    @EJB
    private CargoFacade cargoEJB;
    
    @GET
    public List<Cargo> findAll(){
        return cargoEJB.findAll();
    }
    
}
