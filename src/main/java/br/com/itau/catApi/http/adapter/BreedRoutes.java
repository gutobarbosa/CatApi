package br.com.itau.catApi.http.adapter;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.http.model.Breeds;
import br.com.itau.catApi.http.model.BreedsList;
import br.com.itau.catApi.services.BreedService;
import br.com.itau.catApi.services.BreedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BreedRoutes {
  //  BreedServiceImpl breedServiceImpl = new BreedServiceImpl();
    public BreedRoutes(BreedService breedService) {
        this.breedService = breedService;
    }

    public BreedRoutes() {
    }

    private BreedService breedService;

    private static final String PATH = "https://api.thecatapi.com/v1/breeds"; // url da requisição

    public void getBreeds() {

        Breeds breeds = new Breeds(); // instanciando a classe criada no model

        RestTemplate restTemplate = new RestTemplate(); // Modelo de requisição rest

        Breeds[] data = restTemplate.getForObject(PATH, Breeds[].class);

        for(int i =0; i < data.length; i++){
            // chamar a classe que fara a inclusão no vetor
            // criar um pacote chamado entity e a classe BreedEntity e dentro dela criar ok
            // popular BreedEntity com a posição atual determinada no for (data[i])
            // Criar package e classe de repository pra salvar o BreedEntity ok
            BreedEntity entity = BreedEntity.builder().name(data[i].getName()).origin(data[i].getOrigin()).temperament(data[i].getTemperament()).build();
            breedService.save(entity);


        }


    }

}
