package vsu.solodovnikova.bank.data.storage;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.ClientEntity;
import vsu.solodovnikova.bank.data.mapper.AccountMapper;
import vsu.solodovnikova.bank.data.mapper.ClientMapper;
import vsu.solodovnikova.bank.data.mapper.RequestMapper;

import java.util.List;

@AllArgsConstructor
@Repository
public class ClientStorage {
    private JdbcTemplate jdbcTemplate;

    public void addClient(String name, String surname) {
        String SQL = "insert into Client (name, surname) values (?, ?)";
        jdbcTemplate.update(SQL, name, surname);
    }

    public List<ClientEntity> getClients() {
        String SQL = "select * from Client";
        List<ClientEntity> clients = jdbcTemplate.query(SQL, new ClientMapper());
        for (ClientEntity client : clients){
            SQL = "select * from Account where client_id = ?";
            client.setAccounts(jdbcTemplate.query(SQL, new Object[]{client.getId()}, new AccountMapper()));
            for (AccountEntity account : client.getAccounts()){
                SQL = "select * from Request where account_number = ?";
                account.setRequests(jdbcTemplate.query(SQL, new Object[]{account.getNumber()}, new RequestMapper()));
            }
        }
        return clients;
    }

    public void changeClient(Integer id, String name, String surname) {
        String SQL = "update Client set name = ?, surname = ? where id = ?";
        jdbcTemplate.update(SQL, name, surname, id);
    }

    public void deleteClient(Integer id) {
        String SQL = "select * from Account where client_id = ?";
        List<AccountEntity> accounts = jdbcTemplate.query(SQL, new Object[]{id}, new AccountMapper());
        SQL = "delete from Request where account_number = ?";
        for (AccountEntity account : accounts){
            jdbcTemplate.update(SQL, account.getNumber());
        }
        SQL = "delete from Account where client_id = ?";
        jdbcTemplate.update(SQL,id);
        SQL = "delete from Client where id = ?";
        jdbcTemplate.update(SQL,id);
    }
}
