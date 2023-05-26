package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RequestDto {
    final private Integer id;
    final private Integer accountNumber;
    final private Integer clerkId;
    final private double requestAmount;
    final private int percent;
    final private Date date;
    final private int period;
}
