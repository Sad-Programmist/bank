package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.ClerkChangeDto;
import vsu.solodovnikova.bank.data.dto.ClerkCreateDto;
import vsu.solodovnikova.bank.data.dto.ClerkDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.storage.ClerkStorage;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClerkService {
    private final ClerkStorage clerkStorage;

    @Transactional
    public void addClerk(ClerkCreateDto clerkCreateDto) {
        clerkStorage.addClerk(clerkCreateDto.getName(), clerkCreateDto.getSurname(), clerkCreateDto.getWorkspace());
    }

    @Transactional
    public List<ClerkDto> getClerks() {
        return clerkStorage.getClerks()
                .stream()
                .map(clerk -> new ClerkDto(clerk.getId(), clerk.getName(), clerk.getSurname(), clerk.getWorkspace(),
                        clerk.getRequests()
                                .stream()
                                .map(request -> new RequestDto(request.getId(), request.getAmount(),
                                        request.getPercent(), request.getDate(),
                                        request.getPeriod()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeWorkspace(Integer id, ClerkChangeDto clerkChangeDto) {
        clerkStorage.changeWorkspace(id, clerkChangeDto.getWorkspace());
    }
    @Transactional
    public void deleteClerk(Integer id) {
        clerkStorage.deleteClerk(id);
    }
}
