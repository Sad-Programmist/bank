package vsu.solodovnikova.bank.data.storage;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.mapper.ClerkMapper;
import vsu.solodovnikova.bank.data.mapper.RequestMapper;

import java.util.List;

@AllArgsConstructor
@Repository
public class ClerkStorage {
    private JdbcTemplate jdbcTemplate;

    public void addClerk(String name, String surname, int workspace) {
        String SQL = "insert into Clerk (name, surname, workspace) values (?, ?, ?)";
        jdbcTemplate.update(SQL, name, surname, workspace);
    }

    public List<ClerkEntity> getClerks() {
        String SQL = "select * from Clerk";
        List<ClerkEntity> clerks = jdbcTemplate.query(SQL, new ClerkMapper());

        for (ClerkEntity clerk : clerks) {
            SQL = "select * from Request where clerk_id = ?";
            clerk.setRequests(jdbcTemplate.query(SQL,new Object[]{clerk.getId()}, new RequestMapper()));
        }
        return clerks;
    }

    public void changeWorkspace(Integer id, int workspace){
        String SQL = "update Clerk set workspace = ? where id = ?";
        jdbcTemplate.update(SQL, workspace, id);
    }

    public void deleteClerk(Integer id) {
        String SQL = "delete from Request where clerk_id = ?";
        jdbcTemplate.update(SQL,id);
        SQL = "delete from Clerk where id = ?";
        jdbcTemplate.update(SQL,id);
    }
}
