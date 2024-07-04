package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.AddressModel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetExchange("/{cep}/json/")
    AddressModel getAddressByCep(@PathVariable("cep") String cep);
}
