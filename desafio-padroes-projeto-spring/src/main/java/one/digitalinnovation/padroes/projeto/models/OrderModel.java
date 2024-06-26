package one.digitalinnovation.padroes.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "order_tb")
@NoArgsConstructor
@Getter
@Setter
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(nullable = false, precision = 13)
    private BigInteger productQuantity;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;
}
