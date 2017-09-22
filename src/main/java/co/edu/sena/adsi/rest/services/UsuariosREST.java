package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Usuario;
import co.edu.sena.adsi.jpa.sessions.DetalleNominaFacade;
import co.edu.sena.adsi.jpa.sessions.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rootbean
 */
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosREST {
    
    @EJB
    private UsuarioFacade usuarioEJB;
    
    @EJB
    private DetalleNominaFacade DetalleNominaFacadeEJB;
    
    
    @GET
    public List<Usuario> findAll(){
        return usuarioEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Usuario findById(@PathParam("id") Integer id){
        return usuarioEJB.find(id);
    }
    
    @POST
    public void create(Usuario usuario){
        usuarioEJB.create(usuario);
        
        
        
        
        
    }
}
