package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.exception.NotFoundException;
import br.com.itau.catApi.repository.BreedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BreedServiceImpl implements BreedService {

    //Injeção de dependencia
    @Autowired
    BreedRepository breedRepository;


    @Override
    public void save(BreedEntity breedEntity) {

        breedRepository.save(breedEntity);
    }


    @Override
    public Optional<BreedEntity> findByName(String name) {
        Optional<BreedEntity> allByName = null;
        try {
            allByName = breedRepository.findByName(name);
            log.info("Consulta realizada com sucesso", allByName);
        } catch (Exception e) {
            log.error("Erro ao acessar banco de dados", e);
        }
        if (allByName == null) {
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByName;

    }


    @Override
    public Optional<List> findAllByTemperamentContains(String temperament) {
        Optional<List> allByTemperamentContains = null;
        try {
            allByTemperamentContains = breedRepository.findAllByTemperamentContains(temperament);
            log.info("Consulta realizada com sucesso", allByTemperamentContains);
        } catch (Exception e) {
            log.error("Erro ao acessar banco de dados", e);
        }
        if (allByTemperamentContains.isEmpty()) {
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByTemperamentContains;
    }


    @Override
    public Optional<List> findAllByOrigin(String origin) {
        Optional<List> allByOrigin = null;
        try {
            allByOrigin = breedRepository.findAllByOrigin(origin);
            log.info("Consulta realizada com sucesso", allByOrigin);
        } catch (Exception e) {
            log.error("Erro ao acessar banco de dados", e);
        }

        if (allByOrigin.isEmpty()) {
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return allByOrigin;
    }

    @Override
    public Optional<List> findAll() {
        Optional<List> findAll = null;
        try {
            findAll = Optional.ofNullable(breedRepository.findAll());
            log.info("Consulta realizada com sucesso", findAll);
        } catch (Exception e) {
            log.error("Erro ao acessar banco de dados", e);
        }

        if (findAll.isEmpty()) {
            throw new NotFoundException("Pesquisa não encontrada");
        }
        return findAll;
    }


}
