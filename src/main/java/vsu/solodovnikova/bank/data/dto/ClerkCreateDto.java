package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClerkCreateDto {
    final private String name;
    final private String surname;
    final private int workspace;
}
