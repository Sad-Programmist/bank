package vsu.solodovnikova.bank.data.storage;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.mapper.AccountMapper;
import vsu.solodovnikova.bank.data.mapper.RequestMapper;

import java.util.List;

@AllArgsConstructor
@Repository
public class AccountStorage {
    private JdbcTemplate jdbcTemplate;

    public void addAccount(Integer number, Integer clientId, double amount) {
        String SQL = "insert into Account (number, client_id, amount) values (?, ?, ?)";
        jdbcTemplate.update(SQL, number, clientId, amount);
    }

    public List<AccountEntity> getAccounts() {
        String SQL = "select * from Account";
        List<AccountEntity> accounts = jdbcTemplate.query(SQL, new AccountMapper());
        for (AccountEntity account : accounts){
            SQL = "select * from Request where account_number = ?";
            account.setRequests(jdbcTemplate.query(SQL, new Object[]{account.getNumber()}, new RequestMapper()));
        }
        return accounts;
    }

    public void deleteAccount(Integer number) {
        String SQL = "delete from Request where account_number = ?";
        jdbcTemplate.update(SQL,number);
        SQL = "delete from Account where number = ?";
        jdbcTemplate.update(SQL,number);
    }
}
