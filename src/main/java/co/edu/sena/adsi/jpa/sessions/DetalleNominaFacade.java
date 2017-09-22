package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.DetalleNomina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rootbean
 */
@Stateless
public class DetalleNominaFacade extends AbstractFacade<DetalleNomina> {

    @PersistenceContext(unitName = "co.edu.sena_EjemploNomina_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleNominaFacade() {
        super(DetalleNomina.class);
    }
    
}
