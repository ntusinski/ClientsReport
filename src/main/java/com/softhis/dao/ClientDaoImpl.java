package com.softhis.dao;

import com.softhis.model.Client;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao implements ClientDao {
    @Override
    public List<Client> getClients() {
        Criteria criteria = getSession().createCriteria(Client.class);
        return criteria.list();
    }

    @Override
    public void saveClients(List<Client> clients) {
        for (Client client : clients) {
            getSession().persist(client);
        }
    }
}
