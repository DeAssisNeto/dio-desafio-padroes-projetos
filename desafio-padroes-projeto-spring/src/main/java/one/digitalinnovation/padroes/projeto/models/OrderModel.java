package one.digitalinnovation.padroes.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "order_tb")
@NoArgsConstructor
@Getter
@Setter
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, precision = 13)
    private BigInteger productQuantity;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;

    public OrderModel(BigInteger productQuantity, CustomerModel customerModel) {
        this.productQuantity = productQuantity;
        this.customerModel = customerModel;
    }
}
