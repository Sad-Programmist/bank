package vsu.solodovnikova.bank.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import vsu.solodovnikova.bank.data.entity.StateEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateMapper implements RowMapper<StateEntity> {
    @Override
    public StateEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StateEntity(
                rs.getInt("id"),
                rs.getDate("date"),
                rs.getDouble("amount")
        );
    }
}
