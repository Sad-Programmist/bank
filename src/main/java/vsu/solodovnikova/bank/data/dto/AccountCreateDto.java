package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountCreateDto {
    private final Integer number;
    private final Integer clientId;
    private final double amount;
}
