package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AccountEntity {
    final private UUID number;
    final private UUID idClient;
    final private double amount;
}
