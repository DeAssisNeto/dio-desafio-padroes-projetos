package one.digitalinnovation.padroes.projeto.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public record ProductRecordDto(
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        String name,
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        BigDecimal price,
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        LocalDate expirationDate,
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        String barCode,
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        BigInteger stock
) {
}
