package vsu.solodovnikova.bank.data.storage;

import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.AccountEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class AccountStorage {
    private final Map<UUID, AccountEntity> accounts = new HashMap<>();

    public void addAccount(AccountEntity accountEntity){
        accounts.put(accountEntity.getNumber(), accountEntity);
    }

    public List<AccountEntity> getAccounts(){
        return accounts.values().stream().toList();
    }
}
