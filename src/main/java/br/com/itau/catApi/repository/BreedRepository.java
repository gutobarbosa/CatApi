package br.com.itau.catApi.repository;

import br.com.itau.catApi.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreedRepository extends JpaRepository<BreedEntity,Long> {

    Optional<BreedEntity> findByName(String name);
    List findAllByTemperamentContains(String temperament);
    List findAllByOrigin(String origin);
}
