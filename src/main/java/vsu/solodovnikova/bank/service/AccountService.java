package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.AccountCreateDto;
import vsu.solodovnikova.bank.data.dto.AccountDto;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.storage.AccountStorage;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountStorage accountStorage;
    private final ClientStorage clientStorage;

    @Transactional
    public void addAccount(AccountCreateDto accountCreateDto) {
        accountStorage.save(new AccountEntity(accountCreateDto.getNumber(), clientStorage.findClientEntityById(accountCreateDto.getClientId()), accountCreateDto.getAmount(), null));
    }

    @Transactional
    public List<AccountDto> getAccounts() {
        return accountStorage.findAll()
                .stream()
                .map(account -> new AccountDto(account.getNumber(), account.getClient().getId(), account.getAmount()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteAccount(Integer number) {
        accountStorage.delete(accountStorage.findAccountEntityByNumber(number));
    }
}
