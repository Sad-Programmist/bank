package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RequestCreateDto {
    private final Integer accountNumber;
    private final Integer clerkId;
    private final double amount;
    private final int percent;
    private final Date date;
    private final int period;
}
