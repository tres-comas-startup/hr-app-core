package com.trescomas.controllers;

import com.trescomas.services.administration.AdministrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "administration")
@AllArgsConstructor
public class AdministrationController {

    private final AdministrationService administrationService;

    @GetMapping("/testDB")
    public ResponseEntity testDB() {
        try {
            administrationService.testDB();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
