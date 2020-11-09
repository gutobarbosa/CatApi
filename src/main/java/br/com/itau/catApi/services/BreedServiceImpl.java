package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    //Injeção de dependencia
    @Autowired
    BreedRepository breedRepository;

    @Override
    public void save(BreedEntity breedEntity) {

        breedRepository.save(breedEntity);
    }

    public BreedEntity findByName(String name) {
        return breedRepository.findByName(name);
    }

    @Query("select temperament from breeds where temperament")
    public List findAllByTemperamentContains(String temperament) {

        return breedRepository.findAllByTemperamentContains(temperament);
    }


    public List findAllByOrigin(String origin) {
        return breedRepository.findAllByOrigin(origin);
    }


}
