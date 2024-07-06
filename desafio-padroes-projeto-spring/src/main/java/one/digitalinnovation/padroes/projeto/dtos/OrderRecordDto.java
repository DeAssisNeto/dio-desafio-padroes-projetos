package one.digitalinnovation.padroes.projeto.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.UUID;

public record OrderRecordDto (
        @NotNull(message = "This field cannot be null")
        BigInteger productQuantity,
        @NotNull(message = "This field cannot be null")
        UUID customerId
) {
}
