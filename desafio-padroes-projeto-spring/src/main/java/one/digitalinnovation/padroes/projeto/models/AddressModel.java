package one.digitalinnovation.padroes.projeto.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "addres_tb")
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;
}
