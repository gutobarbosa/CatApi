package br.com.itau.catApi;

import br.com.itau.catApi.http.adapter.BreedRoutes;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApiApplication.class, args);

	}

//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

}
