package ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import model.Client;

/**
 * Session Bean implementation class SessionAdminBean
 */
@Singleton(mappedName = "sessionAdminBean")
@LocalBean
public class SessionAdminBean {
	@EJB
	ClientEjbLocal ejbclient;
	private boolean connecte;
	private Client client;

	/**
	 * Default constructor. 
	 */
	public SessionAdminBean() {
		// TODO Auto-generated constructor stub
		client = new Client();
	}

	public boolean getConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	public boolean validerAdmin() {
		if (ejbclient.identifierUnClient(client) != null) {
			return true;
		} else
			return false;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
