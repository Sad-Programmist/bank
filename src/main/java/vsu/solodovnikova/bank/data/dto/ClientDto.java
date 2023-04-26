package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class ClientDto {
    private final int id;
    private final String name;
    private final String surname;
    private final List<AccountDto> accounts;
}
