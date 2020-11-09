package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;

import java.util.List;

public interface BreedService {

   void save(BreedEntity breedEntity);
   BreedEntity findByName(String name);
   List findAllByTemperamentContains(String temperament);
   List findAllByOrigin(String origin);

}
