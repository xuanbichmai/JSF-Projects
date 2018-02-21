package ejb;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Client;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "ClientEjb", mappedName = "jsf1-ejb-ClientEjb")
public class ClientEjb
implements ClientEjbLocal, ClientEjbRemote
{

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName="jsf1-ejb")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public ClientEjb() {
	}



	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult,
			int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public Client persistClient(Client client) {
		em.persist(client);
		return client;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Client mergeClient(Client client) {
		return em.merge(client);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeClient(Client client) {
		client = em.find(Client.class, client.getId());
		em.remove(client);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Client> getClientFindAll() {
		return em.createNamedQuery("Client.findAll").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Client identifierUnClient(Client client){
		String jpqlStmt = "select x from Client x where x.nom = ";
		jpqlStmt = jpqlStmt +"'" + client.getNom()+"'"+ "and ";
		jpqlStmt = jpqlStmt +"x.motdepasse = "+"'" + client.getMotdepasse()+"'";
		List<Client> lesclients = (List<Client>)queryByRange(jpqlStmt,0,0);
		if (lesclients.size()==1)
			return lesclients.get(0);
		else return null ;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Client rechercherUnClient(Client client){
		String jpqlStmt = "select x from Client x where x.nom = ";
		jpqlStmt = jpqlStmt +"'" + client.getNom()+"'"+ "and ";
		jpqlStmt = jpqlStmt +"x.prenom = "+"'" + client.getPrenom()+"'" + "and ";
		jpqlStmt = jpqlStmt +"x.age = "+"'" + client.getAge()+"'";
		List<Client> lesclients = (List<Client>)queryByRange(jpqlStmt,0,0);
		if (lesclients.size()==1)
			return lesclients.get(0);
		else return null ;
	}

}
