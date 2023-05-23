package vsu.solodovnikova.bank.data.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.StateEntity;

@Repository
public interface StateStorage extends JpaRepository<StateEntity, Integer> {
    @Query("select state from StateEntity state order by state.date desc FETCH FIRST 1 ROW ONLY")
    StateEntity findLastState();
}
