package br.com.itau.catApi.repository;


import br.com.itau.catApi.entity.BreedImageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageInfoRepository extends JpaRepository<BreedImageInfoEntity,String> {
}
