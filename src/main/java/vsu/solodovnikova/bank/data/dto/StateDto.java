package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class StateDto {
    private final Integer id;
    private final Date date;
    private final double amount;
}
