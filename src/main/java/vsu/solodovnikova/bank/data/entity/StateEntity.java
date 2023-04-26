package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@Getter
public class StateEntity {
    @Id
    private final Integer id;
    private final Date date;
    private final double amount;
}
