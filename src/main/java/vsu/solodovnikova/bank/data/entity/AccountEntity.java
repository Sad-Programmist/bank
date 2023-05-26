package vsu.solodovnikova.bank.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class AccountEntity {
    @Id
    private Integer number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable=false)
    private ClientEntity client;
    @Column(name = "amount")
    private double amount;
    @OneToMany(mappedBy="account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RequestEntity> requests;
}
