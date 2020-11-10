package br.com.itau.catApi.controller;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.http.adapter.BreedRoutes;
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
          return ResponseEntity.ok(breedService.findByName(name));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breeds")
    public ResponseEntity<List> getBreeds() {
        try {
            List breedsAll = breedRepository.findAll();
            return ResponseEntity.ok(breedsAll);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/breeds/temperaments/{temperament}")
    public ResponseEntity findAllByTemperamentContains(@PathVariable String temperament) {
        try {
            List breedsTemperament = breedService.findAllByTemperamentContains(temperament);
            return ResponseEntity.ok(breedsTemperament);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breeds/origin/{origin}")
    public ResponseEntity getBreedByOrigin(@PathVariable String origin) {
        try {
            List breedsOrigin = breedService.findAllByOrigin(origin);
            return ResponseEntity.ok(breedsOrigin);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
