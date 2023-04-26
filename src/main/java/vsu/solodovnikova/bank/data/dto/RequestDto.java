package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RequestDto {
    private final Integer id;
    private final double amount;
    private final int percent;
    private final Date date;
    private final int period;
}
