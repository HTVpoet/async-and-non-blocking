package com.example.projectweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ProjectwebApplicationTests {

    @Test
    public void testMono() {
        Mono<Object> mono = Mono.just("haibeo")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        mono.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in flux")))
                .concatWithValues("Cloud")
                .log();

        fluxString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
}
