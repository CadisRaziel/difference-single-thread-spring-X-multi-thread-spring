# Diferenças


Spring Web: é baseado no modelo de programação síncrona tradicional, onde cada solicitação de entrada é manipulada por uma única thread até que a resposta seja retornada. Ele usa o modelo de programação baseado em servlets e é adequado para aplicativos que não requerem alta escalabilidade ou que não precisam lidar com muitas solicitações concorrentes. O Spring Web é construído em cima do servidor de aplicativos Java Servlet, como o Tomcat ou o Jetty, e fornece anotações e recursos para facilitar o desenvolvimento de aplicativos da web.

Spring WebFlux: é uma abordagem reativa baseada em programação assíncrona e não bloqueante. Ele permite que um número limitado de threads gerencie um grande número de solicitações concorrentes usando a biblioteca Reactor, que é uma implementação do paradigma de programação reativa. O Spring WebFlux suporta os dois principais modelos de programação reativa: o modelo baseado em fluxo (Flux) e o modelo baseado em mono (Mono), permitindo que os desenvolvedores criem aplicativos altamente escaláveis e eficientes, capazes de lidar com um grande volume de tráfego. O Spring WebFlux é construído em cima do servidor de aplicativos Netty, que é um servidor assíncrono de E/S de rede.

Principal diferença: é a abordagem de programação utilizada e o modelo de execução. O Spring WebFlux é mais adequado para cenários em que a escalabilidade e a capacidade de lidar com muitas solicitações concorrentes são requisitos importantes, enquanto o Spring Web é uma opção mais tradicional e adequada para aplicativos que não precisam necessariamente de uma abordagem reativa ou que não precisam lidar com um alto volume de tráfego. A escolha entre os dois depende das necessidades e requisitos do seu projeto.



1. Modelo de programação:
    - Spring Web: Usa um modelo de programação síncrona e bloqueante.
    - Spring WebFlux: Usa um modelo de programação assíncrona e não bloqueante.
2. Paradigma de programação reativa:    
    - Spring Web: Não suporta programação reativa.
    - Spring WebFlux: Suporta programação reativa por meio dos modelos Flux e Mono.
3. Thread de execução:   
    - Spring Web: Usa uma thread por solicitação, bloqueando a thread até que a resposta seja retornada.
    - Spring WebFlux: Usa um número limitado de threads assíncronas para lidar com um grande número de solicitações.
4. Servidor de aplicativos:    
    - Spring Web: Pode ser executado em servidores de aplicativos baseados em servlets, como Tomcat ou Jetty.
    - Spring WebFlux: É construído em cima do servidor de aplicativos Netty, que é um servidor assíncrono de E/S de rede.
5. Escalabilidade:    
    - Spring Web: Não é tão adequado para cenários de alta escalabilidade com muitas solicitações concorrentes.
    - Spring WebFlux: É projetado para lidar com um grande número de solicitações concorrentes de forma eficiente, sendo mais adequado para cenários que exigem alta escalabilidade.
6. Biblioteca de programação reativa:    
    - Spring Web: Não usa bibliotecas específicas de programação reativa.
    - Spring WebFlux: Usa a biblioteca Reactor para suportar programação reativa.
7. Anotações:    
    - Spring Web: Usa anotações específicas do Spring MVC, como `@Controller` e `@RequestMapping`.
    - Spring WebFlux: Usa anotações específicas do Spring WebFlux, como `@RestController` e `@GetMapping`.
      
      


(spring webflux)
O spring webflux é uma estrutura da Web sem bloqueio criada desde o início para aproveitar os processadores de próxima geração com vários núcleos e lidar com um grande número de conexões simultâneas.

(spring web)
O Spring mvc foi desenvolvido com base na API servelet e usa uma arquitetura de E/S de bloqueio síncrono com um modelo de uma solicitação por thread



Spring data R2DBC SQL -> versão reactive para banco de dados relacional




Beneficios do WebFlux -> diminui o custo de infraestrutura pois nao vai precisar manter multiplas instancias em um numero grande de requisição
![image](https://github.com/CadisRaziel/difference-single-thread-spring-X-multi-thread-spring/assets/70340981/af7b7dd1-fe04-4bd4-a391-3f0b3a6d0276)
![image](https://github.com/CadisRaziel/difference-single-thread-spring-X-multi-thread-spring/assets/70340981/2c8b828c-fb8c-4cfb-9009-04327d4b076e)



