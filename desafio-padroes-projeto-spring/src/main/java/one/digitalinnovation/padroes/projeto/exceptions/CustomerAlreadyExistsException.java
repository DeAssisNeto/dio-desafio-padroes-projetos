package one.digitalinnovation.padroes.projeto.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException(String cpf){
        super(String.format("Já existe um usuário cadastrado com o CPF - %s", cpf));
    }
}
