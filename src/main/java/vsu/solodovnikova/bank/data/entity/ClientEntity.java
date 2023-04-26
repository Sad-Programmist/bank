package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {
    @Id
    private final Integer id;
    private final String name;
    private final String surname;
    @MappedCollection(idColumn = "id")
    private List<AccountEntity> accounts;
}
