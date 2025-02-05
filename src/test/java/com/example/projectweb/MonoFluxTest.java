package com.example.projectweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;


@SpringBootTest
public class MonoFluxTest {


    @Test
    public void testMono(){
        Mono<Object> mono = Mono.just("haibeo")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        mono.subscribe(System.out::println);
    }
}
