package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.AccountCreateDto;
import vsu.solodovnikova.bank.data.dto.AccountDto;
import vsu.solodovnikova.bank.data.entity.ClientEntity;
import vsu.solodovnikova.bank.data.mapper.AccountMapper;
import vsu.solodovnikova.bank.data.storage.AccountStorage;
import vsu.solodovnikova.bank.data.storage.ClientStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountStorage accountStorage;
    private final ClientStorage clientStorage;
    private final AccountMapper accountMapper;

    @Transactional
    public void addAccount(AccountCreateDto accountCreateDto) {
        ClientEntity client = clientStorage.findClientEntityById(accountCreateDto.getClientId());
        accountStorage.save(accountMapper.toEntity(accountCreateDto, client));
    }

    @Transactional
    public List<AccountDto> getAccounts() {
        return accountStorage.findAll()
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteAccount(Integer number) {
        accountStorage.delete(accountStorage.findAccountEntityByNumber(number));
    }
}
