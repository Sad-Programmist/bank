package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ClerkDto {
    final private UUID id;
    final private String name;
    final private String surname;
    final private int workspace;
}
