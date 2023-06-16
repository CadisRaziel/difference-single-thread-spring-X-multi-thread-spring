package com.vitu.reactiveapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactiveApiApplicationTests {

    @Autowired
    private WebTestClient webTestClient; // WebTestClient -> multithread (ele nao retorna a resposta)

    @Test
    void test() {
        User user = new User(null, "user", "123456", "vitorbrussolo@gmial.com");

        //criar um objeto(user)
        webTestClient.post()
                .uri("/users") // -> Url que criamos no controller
                .bodyValue(user) // -> Corpo da requisição
                .exchange() // -> Executa a requisição
                .expectStatus().is2xxSuccessful() //-> status esperado (aqui vamo espera um 2xx sucess
                .expectBody(User.class) // -> Espera que o corpo da resposta seja um User.class
                .value(postResponse -> { // -> avalia o que foi retornado
                    //verificar se foi gerado um id no usuario retornado
                    assertNotNull(postResponse.id());

                    //comparando os atributos
                    assertEquals(user.username(), postResponse.username());
                    //assertEquals(user.password(), postResponse.password());
                    assertEquals(user.email(), postResponse.email());
                });


        //get all
        webTestClient.get()
                .uri("/users")
                .exchange()
                .expectStatus().is2xxSuccessful() //-> status esperado (aqui vamo espera um 2xx sucess
                .expectBodyList(User.class) // -> Espera que o corpo da resposta seja uma lista de User.class
                .value(getResponses -> {
                    User getResponse = getResponses.get(0);
                    assertNotNull(getResponse.id());
                    assertEquals(user.username(), getResponse.username());
                    //assertEquals(user.password(), getResponse.password());
                    assertEquals(user.email(), getResponse.email());
                });

    }

}
