package fr.exia.booxtore.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Client
 */
@Stateless
@LocalBean
public class Client implements ClientRemote {
	@PersistenceContext(unitName = "JPA-Booxtore")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public Client() {
        // TODO Auto-generated constructor stub
    }
    //Recuperer un objet avec son id avec l'entity manager
	public Client find(int id) {

		//On cherche l'objet grace a l'entity manager
		Client client = em.find(Client.class, id);

		return client;

	}

}
