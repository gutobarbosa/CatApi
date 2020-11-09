package br.com.itau.catApi.services;


import br.com.itau.catApi.entity.BreedImageInfoEntity;
import br.com.itau.catApi.repository.ImageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageInfoServiceImpl implements ImageInfoService {
    @Autowired
    ImageInfoRepository imageInfoRepository;

    @Override
    public void save(BreedImageInfoEntity breedImageInfoEntity) {

        imageInfoRepository.save(breedImageInfoEntity);
    }
}
