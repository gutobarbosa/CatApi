package br.com.itau.catApi.controller;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.exception.NotFoundException;
import br.com.itau.catApi.http.component.BreedRoutes;
import br.com.itau.catApi.repository.BreedRepository;
import br.com.itau.catApi.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*") // Pesquisar recurso
public class BreedController {

    @Autowired
    BreedRoutes breedRoutes;

    @Autowired
    BreedService breedService;

    @Autowired
    BreedRepository breedRepository;

    @PostMapping("/breeds/save")
    public ResponseEntity<BreedEntity> createBreedsExternalApi() {
        try {
            breedRoutes.getBreeds();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/breeds/{name}")
    public ResponseEntity getBreedByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(breedService.findByName(name).orElseThrow(() -> new NotFoundException("Pesquisa não encontrada")));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breeds")
    public ResponseEntity<List> getBreeds() {
        try {
            return ResponseEntity.ok(breedService.findAll().orElseThrow(() -> new NotFoundException("Pesquisa não encontrada")));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/breeds/temperaments/{temperament}")
    public ResponseEntity findAllByTemperamentContains(@PathVariable String temperament) {
        try {
            return ResponseEntity.ok(breedService.findAllByTemperamentContains(temperament).orElseThrow(() -> new NotFoundException("Pesquisa não encontrada")));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breeds/origin/{origin}")
    public ResponseEntity getBreedByOrigin(@PathVariable String origin) {
        try {
            return ResponseEntity.ok(breedService.findAllByOrigin(origin).orElseThrow(() -> new NotFoundException("Pesquisa não encontrada")));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
