package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.StateDto;
import vsu.solodovnikova.bank.data.storage.StateStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StateService {
    private final StateStorage stateStorage;

    @Transactional
    public List<StateDto> getStates() {
        return stateStorage.findAll()
                .stream()
                .map(state -> new StateDto(state.getDate(), state.getAmount()))
                .collect(Collectors.toList());
    }
}
