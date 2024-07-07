package one.digitalinnovation.padroes.projeto.exceptions;

import java.math.BigInteger;

public class InsufficientQuantityStockException extends RuntimeException{
    public InsufficientQuantityStockException(BigInteger requested, BigInteger stock){
        super(String.format("A quantidade de produtos solicitada %s ultrapassa o estoque %s", requested, stock));
    }
}
