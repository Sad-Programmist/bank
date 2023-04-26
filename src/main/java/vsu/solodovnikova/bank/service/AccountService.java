package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.AccountCreateDto;
import vsu.solodovnikova.bank.data.dto.AccountDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.storage.AccountStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountStorage accountStorage;

    @Transactional
    public void addAccount(AccountCreateDto accountCreateDto) {
        accountStorage.addAccount(accountCreateDto.getNumber(), accountCreateDto.getClientId(), accountCreateDto.getAmount());
    }

    @Transactional
    public List<AccountDto> getAccounts() {
        return accountStorage.getAccounts()
                .stream()
                .map(account -> new AccountDto(account.getNumber(), account.getAmount(),
                        account.getRequests()
                                .stream()
                                .map(request -> new RequestDto(request.getId(), request.getAmount(), request.getPercent(),
                                        request.getDate(), request.getPeriod()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteAccount(Integer number) {
        accountStorage.deleteAccount(number);
    }
}
