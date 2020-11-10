package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;

import java.util.List;
import java.util.Optional;

public interface BreedService {

   void save(BreedEntity breedEntity);
   Optional<BreedEntity> findByName(String name);
   List findAllByTemperamentContains(String temperament);
   List findAllByOrigin(String origin);

}
