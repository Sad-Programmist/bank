package vsu.solodovnikova.bank.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClerkMapper implements RowMapper<ClerkEntity> {
    @Override
    public ClerkEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClerkEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getInt("workspace"),
                null
        );
    }
}
