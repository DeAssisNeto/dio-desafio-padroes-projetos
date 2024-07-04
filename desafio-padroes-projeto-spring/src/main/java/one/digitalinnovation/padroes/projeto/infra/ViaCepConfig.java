package one.digitalinnovation.padroes.projeto.infra;

import one.digitalinnovation.padroes.projeto.services.ViaCepService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ViaCepConfig {

    @Bean
    public ViaCepService viaCepService(WebClient webClient) {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
        return factory.createClient(ViaCepService.class);
    }
}
