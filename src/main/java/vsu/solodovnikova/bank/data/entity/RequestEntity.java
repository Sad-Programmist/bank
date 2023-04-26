package vsu.solodovnikova.bank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RequestEntity {
    @Id
    private final Integer id;
    private final double amount;
    private final int percent;
    private final Date date;
    private final int period;

}
