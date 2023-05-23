package vsu.solodovnikova.bank.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "request")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_number", nullable=false)
    private AccountEntity account;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="clerk_id", nullable=true)
    private ClerkEntity clerk;
    @Column(name = "amount")
    private double amount;
    @Column(name = "percent")
    private int percent;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "period")
    private int period;

}
