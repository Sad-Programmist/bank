package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClerkCreateDto {
    private final String name;
    private final String surname;
    private final int workspace;
}
