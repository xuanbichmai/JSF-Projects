package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Client;


/**
 * @generated DT_ID=none
 */
@Local
public interface ClientEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Client persistClient(Client client);

    /**
     * @generated DT_ID=none
     */
    public Client mergeClient(Client client);

    /**
     * @generated DT_ID=none
     */
    public void removeClient(Client client);

    /**
     * @generated DT_ID=none
     */
    public List<Client> getClientFindAll();
    
    public Client identifierUnClient(Client client);
    
    public Client rechercherUnClient(Client client);
    
    

}
