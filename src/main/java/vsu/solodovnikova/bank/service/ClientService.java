package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.data.entity.ClientEntity;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientStorage clientStorage;
    @Transactional
    public void addClient(ClientCreateDto clientCreateDto) {
        ClientEntity client = new ClientEntity();
        client.setName(clientCreateDto.getName());
        client.setSurname(clientCreateDto.getSurname());
        clientStorage.save(client);
    }

    @Transactional
    public List<ClientDto> getClients() {
        return clientStorage.findAll()
                .stream()
                .map(client -> new ClientDto(client.getId(), client.getName(), client.getSurname()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeClient(Integer id, ClientChangeDto clientChangeDto) {
        ClientEntity client = clientStorage.findClientEntityById(id);
        client.setName(clientChangeDto.getName());
        client.setSurname(clientChangeDto.getSurname());
        clientStorage.save(client);
    }

    @Transactional
    public void deleteClient(Integer id) {
        clientStorage.delete(clientStorage.findClientEntityById(id));
    }
}
