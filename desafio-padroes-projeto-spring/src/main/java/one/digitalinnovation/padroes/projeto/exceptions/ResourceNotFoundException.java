package one.digitalinnovation.padroes.projeto.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String field, String fieldName, String value){
        super(String.format("Recurso %s não encontrado com %s = %s", field, fieldName, value));
    }

}