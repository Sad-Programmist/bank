package vsu.solodovnikova.bank.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    @Column(name = "request_amount")
    private Double requestAmount;
    @Column(name = "percent")
    private Integer percent;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "period")
    private Integer period;

}
