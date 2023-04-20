package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AccountCreateDto {
    final private UUID number;
    final private UUID idClient;
    final private double amount;
}
