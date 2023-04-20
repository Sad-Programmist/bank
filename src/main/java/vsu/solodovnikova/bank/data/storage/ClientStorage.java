package vsu.solodovnikova.bank.data.storage;

import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.ClientEntity;

import java.util.*;

@Repository
public class ClientStorage {
    private final Map<UUID, ClientEntity> clients = new HashMap<>();

    public void addClient(ClientEntity clientEntity){
        clients.put(clientEntity.getId(), clientEntity);
    }

    public List<ClientEntity> getClients(){
        return clients.values().stream().toList();
    }
}
