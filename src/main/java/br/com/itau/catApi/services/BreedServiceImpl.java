package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BreedServiceImpl implements BreedService {


    public BreedServiceImpl(BreedRepository repository) {
        this.repository = repository;
    }

    public BreedServiceImpl() {
    }

    //Injeção de dependencia
    private BreedRepository repository;

    @Override
    public BreedEntity save(BreedEntity breedEntity) {

        return repository.save(breedEntity);
    }


}
