package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ClerkDto {
    private final Integer id;
    private final String name;
    private final String surname;
    private final int workspace;
    private final List<RequestDto> requests;
}
