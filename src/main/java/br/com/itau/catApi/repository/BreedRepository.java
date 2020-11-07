package br.com.itau.catApi.repository;

import br.com.itau.catApi.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends CrudRepository<BreedEntity,Long> {
    //BreedEntity save(BreedEntity breedEntity );
}
