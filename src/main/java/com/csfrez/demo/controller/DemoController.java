package com.csfrez.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/list")
    public List<Integer> list() {
        return Arrays.asList(1, 2, 3);
    }

    @GetMapping("/monotest")
    public Mono<String> monotest() {
        return Mono.just("monotest");
    }

    @GetMapping("/fluxlist")
    public Flux<Integer> fluxlist() {
        return Flux.just(1, 2, 3);
    }

}