package vsu.solodovnikova.bank.data.storage;

import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ClerkStorage {
    private final Map<UUID, ClerkEntity> clerks = new HashMap<>();

    public void addClerk(ClerkEntity clerkEntity){
        clerks.put(clerkEntity.getId(), clerkEntity);
    }

    public List<ClerkEntity> getClerks(){
        return clerks.values().stream().toList();
    }
}
