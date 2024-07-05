package one.digitalinnovation.padroes.projeto.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddressRecordDto(
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be blank")
        String cep,
        @NotNull(message = "This field cannot be null")
        UUID customer_id
) {
}
