package vsu.solodovnikova.bank.data.storage;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.StateEntity;
import vsu.solodovnikova.bank.data.mapper.StateMapper;

import java.util.*;

@AllArgsConstructor
@Repository
public class StateStorage {
    private JdbcTemplate jdbcTemplate;

    public void addState(Date date, double amount) {
        String SQL = "insert into State (date, amount) values (?, ?)";
        jdbcTemplate.update(SQL, date, amount);
    }

    public List<StateEntity> getStates() {
        String SQL = "select * from State";
        return jdbcTemplate.query(SQL, new StateMapper());
    }
}
