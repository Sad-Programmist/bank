package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class StateEntity {
    final private Date date;
    final private double amount;
}
