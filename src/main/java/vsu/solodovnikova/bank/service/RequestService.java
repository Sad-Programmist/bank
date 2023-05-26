package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.RequestCreateDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.entity.StateEntity;
import vsu.solodovnikova.bank.data.mapper.RequestMapper;
import vsu.solodovnikova.bank.data.storage.AccountStorage;
import vsu.solodovnikova.bank.data.storage.ClerkStorage;
import vsu.solodovnikova.bank.data.storage.RequestStorage;
import vsu.solodovnikova.bank.data.storage.StateStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RequestService {
    private final RequestStorage requestStorage;
    private final AccountStorage accountStorage;
    private final ClerkStorage clerkStorage;
    private final StateStorage stateStorage;
    private final RequestMapper requestMapper;

    @Transactional
    public void addRequest(RequestCreateDto requestCreateDto) {
        AccountEntity account = accountStorage.findAccountEntityByNumber(requestCreateDto.getAccountNumber());
        ClerkEntity clerk = null;
        if (requestCreateDto.getClerkId() != null)
            clerk = clerkStorage.findClerkEntityById(requestCreateDto.getClerkId());
        requestStorage.save(requestMapper.toEntity(requestCreateDto, account, clerk));

        stateStorage.save(new StateEntity(requestCreateDto.getDate(), stateStorage.findLastState().getAmount() -
                requestCreateDto.getRequestAmount()));
    }

    @Transactional
    public List<RequestDto> getRequests() {
        return requestStorage.findAll()
                .stream()
                .map(requestMapper::toDto)
                .collect(Collectors.toList());
    }
}
