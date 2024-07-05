package one.digitalinnovation.padroes.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.digitalinnovation.padroes.projeto.dtos.ProductRecordDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "product_tb")
@NoArgsConstructor
@Getter
@Setter
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false, length = 15)
    private String barCode;
    @Column(nullable = false, precision = 13)
    private BigInteger stock;

    public ProductModel(ProductRecordDto dto) {
        this.name = dto.name();
        this.price = dto.price();
        this.expirationDate = dto.expirationDate();
        this.barCode = dto.barCode();
        this.stock = dto.stock();
    }
}
