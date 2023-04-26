package vsu.solodovnikova.bank.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import vsu.solodovnikova.bank.data.entity.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<AccountEntity> {
    @Override
    public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AccountEntity(
                rs.getInt("number"),
                rs.getDouble("amount"),
                null
        );
    }
}
