package com.amaan.retrieval_augmented_generation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HomeController {

    @GetMapping("")
    public ResponseEntity<String> loadingBackend() {
        return new ResponseEntity<>("backendLoaded", HttpStatus.OK);
    }

}
