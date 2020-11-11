package br.com.itau.catApi.services;

import br.com.itau.catApi.entity.BreedImageInfoEntity;
import br.com.itau.catApi.repository.ImageInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageInfoServiceImpl implements ImageInfoService {
    @Autowired
    ImageInfoRepository imageInfoRepository;

    @Override
    public void save(BreedImageInfoEntity breedImageInfoEntity) {
    try {
        imageInfoRepository.save(breedImageInfoEntity);
        log.info("Consulta realizada com sucesso");
    }catch (Exception e){
        log.error("Erro ao acessar banco de dados");
    }
    }
}
