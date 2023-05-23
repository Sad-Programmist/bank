package vsu.solodovnikova.bank.data.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsu.solodovnikova.bank.data.entity.ClientEntity;

import java.util.Optional;


@Repository
public interface ClientStorage extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findClientEntityById(Integer id);
}
