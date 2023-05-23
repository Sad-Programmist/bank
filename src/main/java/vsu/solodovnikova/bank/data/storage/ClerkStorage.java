package vsu.solodovnikova.bank.data.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;


@Repository
public interface ClerkStorage extends JpaRepository<ClerkEntity, Integer> {
    ClerkEntity findClerkEntityById(Integer id);
}
