package vsu.solodovnikova.bank.data.storage;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.RequestEntity;
import vsu.solodovnikova.bank.data.entity.StateEntity;
import vsu.solodovnikova.bank.data.mapper.AccountMapper;
import vsu.solodovnikova.bank.data.mapper.RequestMapper;
import vsu.solodovnikova.bank.data.mapper.StateMapper;

import java.util.*;

@AllArgsConstructor
@Repository
public class RequestStorage {
    private JdbcTemplate jdbcTemplate;

    public void addRequest(Integer accountNumber, Integer clerkId, double amount, int percent, Date date, int period) {
        String SQL = "insert into Request (account_number, clerk_id, amount, percent, date, period) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, accountNumber, clerkId, amount, percent, date, period);

        SQL = "select * from Account where number = ?";
        AccountEntity account = jdbcTemplate.queryForObject(SQL, new Object[]{accountNumber}, new AccountMapper());
        SQL = "update Account set amount = ? where number = ?";
        jdbcTemplate.update(SQL, account.getAmount() + amount, accountNumber);

        SQL = "select * from State where id = (select max(id) from State)";
        StateEntity state = jdbcTemplate.queryForObject(SQL, new StateMapper());
        SQL = "insert into State (amount, date) values (?, ?)";
        jdbcTemplate.update(SQL, state.getAmount() + amount, date);
    }

    public List<RequestEntity> getRequests() {
        String SQL = "select * from Request";
        return jdbcTemplate.query(SQL, new RequestMapper());
    }
}
