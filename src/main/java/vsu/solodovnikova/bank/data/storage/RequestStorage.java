package vsu.solodovnikova.bank.data.storage;

import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.RequestEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class RequestStorage {
    private final Map<UUID, RequestEntity> queue = new HashMap<>();

    public void addReception(RequestEntity requestEntity){
        queue.put(requestEntity.getId(), requestEntity);
    }

    public List<RequestEntity> getQueue(){
        return queue.values().stream().toList();
    }
}
