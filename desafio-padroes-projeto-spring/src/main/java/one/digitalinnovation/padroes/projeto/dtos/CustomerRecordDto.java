package one.digitalinnovation.padroes.projeto.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRecordDto (
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        String name,
        @NotNull(message = "This field cannot be null")
        @NotBlank(message = "This field cannot be null")
        String cpf
) {

}
