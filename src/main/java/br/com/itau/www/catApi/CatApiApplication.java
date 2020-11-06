package br.com.itau.www.catApi;

import br.com.itau.www.catApi.http.adapter.BreedRoutes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApiApplication.class, args);
		BreedRoutes breedRoutes = new BreedRoutes();
		breedRoutes.getBreeds();
	}

}
