package vsu.solodovnikova.bank.data.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.AccountEntity;

@Repository
public interface AccountStorage extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findAccountEntityByNumber(Integer number);
}
