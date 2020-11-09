package br.com.itau.catApi.http.adapter;

import br.com.itau.catApi.entity.BreedImageInfoEntity;
import br.com.itau.catApi.http.model.Breeds;
import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BreedRoutes {
    @Autowired
    private BreedService breedService;
    private static final String PATH = "https://api.thecatapi.com/v1/breeds"; // url da requisição
    private String PATH_IMAGEINFO = "https://api.thecatapi.com/v1/images/search?breed_id=";

    public void getBreeds() {
        RestTemplate restTemplate = new RestTemplate(); // Modelo de requisição rest
        Breeds[] data = restTemplate.getForObject(PATH, Breeds[].class);
        assert data != null;
        for (Breeds breeds : data) {

            BreedEntity entity = BreedEntity.builder().id(breeds.getId()).name(breeds.getName()).origin(breeds.getOrigin()).temperament(breeds.getTemperament()).build();
            breedService.save(entity);
            
            PATH_IMAGEINFO = PATH_IMAGEINFO + breeds.getId();
            BreedImageInfoEntity[] imageInfo = restTemplate.getForObject(PATH_IMAGEINFO, BreedImageInfoEntity[].class);
            PATH_IMAGEINFO = "https://api.thecatapi.com/v1/images/search?breed_id=";
        }
    }

}
