package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class RequestEntity {
    final private UUID id;
    final private UUID idClient;
    final private UUID idClerk;
    final private double amount;
    final private int percent;
    final private Date date;
    final private int period;

}
