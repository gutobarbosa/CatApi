package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;
import org.springframework.stereotype.Service;


public interface BreedService {

    BreedEntity save(BreedEntity breedEntity );

}
