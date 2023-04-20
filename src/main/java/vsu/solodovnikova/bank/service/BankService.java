package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.entity.ClientEntity;
import vsu.solodovnikova.bank.data.storage.ClerkStorage;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BankService {
    final private ClientStorage clientStorage;
    final private ClerkStorage clerkStorage;

    public ClientEntity addClient(ClientCreateDto clientCreateDto) {
        ClientEntity client = new ClientEntity(UUID.randomUUID(),clientCreateDto.getName(), clientCreateDto.getSurname());
        clientStorage.addClient(client);
        return client;
    }

    public List<ClientDto> getClients() {
        return clientStorage.getClients()
                .stream()
                .map(client -> new ClientDto(client.getId(), client.getName(), client.getSurname()))
                .collect(Collectors.toList());
    }

    public ClerkEntity addClerk(ClerkCreateDto clerkCreateDto) {
        ClerkEntity clerk = new ClerkEntity(UUID.randomUUID(), clerkCreateDto.getName(), clerkCreateDto.getSurname(), clerkCreateDto.getWorkspace());
        clerkStorage.addClerk(clerk);
        return clerk;
    }

    public List<ClerkDto> getClerks() {
        return clerkStorage.getClerks()
                .stream()
                .map(clerk -> new ClerkDto(clerk.getId(), clerk.getName(), clerk.getSurname(), clerk.getWorkspace()))
                .collect(Collectors.toList());
    }
}
