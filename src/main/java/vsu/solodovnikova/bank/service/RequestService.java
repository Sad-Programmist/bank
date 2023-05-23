package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.RequestCreateDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.RequestEntity;
import vsu.solodovnikova.bank.data.entity.StateEntity;
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

    @Transactional
    public void addRequest(RequestCreateDto requestCreateDto) {
        RequestEntity request = new RequestEntity();
        AccountEntity account = accountStorage.findAccountEntityByNumber(requestCreateDto.getAccountNumber());
        request.setAccount(account);
        if (requestCreateDto.getClerkId() != null)
            request.setClerk(clerkStorage.findClerkEntityById(requestCreateDto.getClerkId()));
        double amount = account.getAmount() + requestCreateDto.getAmount();
        request.setAmount(amount);
        request.setPercent(requestCreateDto.getPercent());
        request.setDate(requestCreateDto.getDate());
        request.setPeriod(requestCreateDto.getPeriod());
        requestStorage.save(request);

        stateStorage.save(new StateEntity(requestCreateDto.getDate(), stateStorage.findLastState().getAmount() -
                requestCreateDto.getAmount()));
    }

    @Transactional
    public List<RequestDto> getRequests() {
        return requestStorage.findAll()
                .stream()
                .map(request -> new RequestDto(request.getId(), request.getAccount().getNumber(), request.getClerk().getId(),
                        request.getAmount(), request.getPercent(), request.getDate(), request.getPeriod()))
                .collect(Collectors.toList());
    }
}
