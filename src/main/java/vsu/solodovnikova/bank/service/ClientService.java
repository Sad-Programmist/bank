package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientStorage clientStorage;
    @Transactional
    public void addClient(ClientCreateDto clientCreateDto) {
        clientStorage.addClient(clientCreateDto.getName(), clientCreateDto.getSurname());
    }

    @Transactional
    public List<ClientDto> getClients() {
        return clientStorage.getClients()
                .stream()
                .map(client -> new ClientDto(client.getId(), client.getName(), client.getSurname(),
                        client.getAccounts()
                                .stream()
                                .map(account -> new AccountDto(account.getNumber(), account.getAmount(),
                                        account.getRequests()
                                                .stream()
                                                .map(request -> new RequestDto(request.getId(), request.getAmount(),
                                                        request.getPercent(), request.getDate(),
                                                        request.getPeriod()))
                                                .collect(Collectors.toList())))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeClient(Integer id, ClientChangeDto clientChangeDto) {
        clientStorage.changeClient(id, clientChangeDto.getName(), clientChangeDto.getSurname());
    }

    @Transactional
    public void deleteClient(Integer id) {
        clientStorage.deleteClient(id);
    }
}
