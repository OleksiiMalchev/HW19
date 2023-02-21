package com.malchev.hillel.homework19.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class Ping {

    @GetMapping("/ping")
    public String  getProducts() {
       return "OK";
    }
}
