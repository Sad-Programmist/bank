package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountCreateDto {
    final private Integer number;
    final private Integer clientId;
    final private double amount;
}
