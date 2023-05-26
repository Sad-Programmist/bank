package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.ClerkChangeDto;
import vsu.solodovnikova.bank.data.dto.ClerkCreateDto;
import vsu.solodovnikova.bank.data.dto.ClerkDto;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.mapper.ClerkMapper;
import vsu.solodovnikova.bank.data.storage.ClerkStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClerkService {
    private final ClerkStorage clerkStorage;
    private final ClerkMapper clerkMapper;

    @Transactional
    public void addClerk(ClerkCreateDto clerkCreateDto) {
        clerkStorage.save(clerkMapper.toEntity(clerkCreateDto));
    }

    @Transactional
    public List<ClerkDto> getClerks() {
        return clerkStorage.findAll()
                .stream()
                .map(clerkMapper::toDto)
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
