package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.data.mapper.ClientMapper;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientStorage clientStorage;
    private final ClientMapper clientMapper;
    @Transactional
    public void addClient(ClientCreateDto clientCreateDto) {
        clientStorage.save(clientMapper.toEntity(clientCreateDto));
    }

    @Transactional
    public List<ClientDto> getClients() {
        return clientStorage.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeClient(Integer id, ClientChangeDto clientChangeDto) {
        clientStorage.save(clientMapper.toEntity(id, clientChangeDto));
    }

    @Transactional
    public void deleteClient(Integer id) {
        clientStorage.delete(clientStorage.findClientEntityById(id));
    }
}
