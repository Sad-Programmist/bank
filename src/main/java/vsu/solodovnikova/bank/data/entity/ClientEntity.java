package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {
    final private UUID id;
    final private String name;
    final private String surname;
}
