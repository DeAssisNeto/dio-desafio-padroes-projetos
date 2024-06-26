package one.digitalinnovation.padroes.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "product_order_tb")
@NoArgsConstructor
@Getter
@Setter
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel productModel;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orderModel;
}
