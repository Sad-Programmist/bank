package vsu.solodovnikova.bank.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import vsu.solodovnikova.bank.data.entity.RequestEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<RequestEntity> {
    @Override
    public RequestEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RequestEntity(
                rs.getInt("id"),
                rs.getDouble("amount"),
                rs.getInt("percent"),
                rs.getDate("date"),
                rs.getInt("period")
        );
    }
}
