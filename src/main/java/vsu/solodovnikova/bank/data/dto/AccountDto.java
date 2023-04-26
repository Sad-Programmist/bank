package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AccountDto {
    private final Integer number;
    private final double amount;
    private final List<RequestDto> requests;
}
