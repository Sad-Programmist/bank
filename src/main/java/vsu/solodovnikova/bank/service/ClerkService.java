package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.ClerkChangeDto;
import vsu.solodovnikova.bank.data.dto.ClerkCreateDto;
import vsu.solodovnikova.bank.data.dto.ClerkDto;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.storage.ClerkStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClerkService {
    private final ClerkStorage clerkStorage;

    @Transactional
    public void addClerk(ClerkCreateDto clerkCreateDto) {
        ClerkEntity clerk = new ClerkEntity();
        clerk.setName(clerkCreateDto.getName());
        clerk.setSurname(clerkCreateDto.getSurname());
        clerk.setWorkspace(clerkCreateDto.getWorkspace());
        clerkStorage.save(clerk);
    }

    @Transactional
    public List<ClerkDto> getClerks() {
        return clerkStorage.findAll()
                .stream()
                .map(clerk -> new ClerkDto(clerk.getId(), clerk.getName(), clerk.getSurname(), clerk.getWorkspace()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeWorkspace(Integer id, ClerkChangeDto clerkChangeDto) {
        ClerkEntity clerk = clerkStorage.findClerkEntityById(id);
        clerk.setWorkspace(clerkChangeDto.getWorkspace());
        clerkStorage.save(clerk);
    }
    @Transactional
    public void deleteClerk(Integer id) {
        clerkStorage.delete(clerkStorage.findClerkEntityById(id));
    }
}
