package com.daniel.pokeapi.controllers;

import com.daniel.pokeapi.models.Endpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {

    private static String template = "Hello %s your age is %d, welcome to Poke Api";

    @GetMapping("/welcome")
    public String welcome(
        @RequestParam String name,
        @RequestParam(required = false) Integer age
    ) {
        return String.format(template, name, age);
    }

    @GetMapping(value = "/doc")
    public List<Endpoint> doc() {
        return List.of(
            new Endpoint("Welcome to Poke Api", "/welcome?name=Example&age=18"),
            new Endpoint("Every type", "/types/"),
            new Endpoint("Get type by id", "/types/3"),
            new Endpoint("Create type", "/types/"),
            new Endpoint("Update type", "/types/"),
            new Endpoint("Delete", "/types/")
        );
    }
}
