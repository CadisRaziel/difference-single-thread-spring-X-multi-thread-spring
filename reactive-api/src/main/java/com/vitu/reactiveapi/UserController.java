package com.vitu.reactiveapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    //MONO -> Não sabemos em qual momento o objeto vai retornar do banco, ele é assincrono, por isso é necessario retornar um Mono<Object> (OBJETO SOZINHO)
    //Flux -> Para quando é uma LISTA de objetos, também é assincrono, por isso é necessario retornar um Flux<Object> (LISTA DE OBJETO)

    @PostMapping
    Mono<User> create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    Flux<User> list() {
        //chamando um serviço externo (vai imprimir no console os itens dessa api)
        WebClient.create() //-> cria o webCliente
                .get() // -> realizaa consulta
                .uri("https://jsonplaceholder.typicode.com/todos") // -> url da consulta
                .retrieve() // -> recupera a resposta
                .bodyToFlux(String.class) // -> converte a resposta para um fluxo de User.class
                .subscribe(System.out::println); // -> executa a requisição
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable Long id) {
        return userRepository.deleteById(id);
    }

}