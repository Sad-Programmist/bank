package vsu.solodovnikova.bank.data.mapper;

import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import vsu.solodovnikova.bank.data.entity.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientMapper implements RowMapper<ClientEntity> {
    @Override
    public ClientEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClientEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                null
        );
    }
}
