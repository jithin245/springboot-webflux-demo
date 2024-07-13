package com.jithin.springboot_webflux_demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("javatechie")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println("Exception message: " + e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Spring", "Spring boot", "Hiberante", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println);
    }
}
