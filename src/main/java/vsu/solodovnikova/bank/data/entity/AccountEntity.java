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
public class AccountEntity {
    @Id
    private final Integer number;
    private final double amount;
    @MappedCollection(idColumn = "number")
    private List<RequestEntity> requests;
}
