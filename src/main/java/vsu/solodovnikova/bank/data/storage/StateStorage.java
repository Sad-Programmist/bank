package vsu.solodovnikova.bank.data.storage;

import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.StateEntity;

import java.util.*;

@Repository
public class StateStorage {
    private final Map<Date, StateEntity> states = new HashMap<>();

    public void addState(StateEntity stateEntity){
        states.put(stateEntity.getDate(), stateEntity);
    }

    public List<StateEntity> getStates(){
        return states.values().stream().toList();
    }
}
