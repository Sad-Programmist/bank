package vsu.solodovnikova.bank.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClerkDto {
    final private Integer id;
    final private String name;
    final private String surname;
    final private int workspace;
}
