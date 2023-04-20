package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ClerkEntity {
    final private UUID id;
    final private String name;
    final private String surname;
    private final int workspace;
}
