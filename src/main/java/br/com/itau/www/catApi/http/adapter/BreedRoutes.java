package br.com.itau.www.catApi.http.adapter;

import br.com.itau.www.catApi.http.model.Breeds;
import br.com.itau.www.catApi.http.model.BreedsList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BreedRoutes {

    private static final String PATH = "https://api.thecatapi.com/v1/breeds"; // url da requisição

    public void getBreeds() {


        BreedsList breeds = new BreedsList(); // instanciando a classe criada no model

        RestTemplate restTemplate = new RestTemplate(); // Modelo de requisição rest

        ResponseEntity<String> response = restTemplate.getForEntity(PATH, String.class);

    }

}
