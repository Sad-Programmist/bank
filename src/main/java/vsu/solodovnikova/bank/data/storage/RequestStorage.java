package vsu.solodovnikova.bank.data.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.RequestEntity;

@Repository
public interface RequestStorage extends JpaRepository<RequestEntity, Integer> {
}
