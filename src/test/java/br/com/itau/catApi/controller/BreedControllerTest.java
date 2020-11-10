package br.com.itau.catApi.controller;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.http.adapter.BreedRoutes;
import br.com.itau.catApi.repository.BreedRepository;
import br.com.itau.catApi.services.BreedService;
import br.com.itau.catApi.services.ImageInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@ExtendWith({SpringExtension.class})
@WebMvcTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BreedControllerTest {

    static String BREED_URL = "/breeds";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BreedService breedService;

    @MockBean
    ImageInfoService imageInfoService;

    @MockBean
    BreedRoutes breedRoutes;

    @Autowired
    BreedRepository breedRepository;

    @Test
    public void getBreedByNameTest() throws Exception {

        String name = "Abyssinian";

        BreedEntity breedEntity = BreedEntity.builder().id("abys").name("Abyssinian").origin("Egypt").temperament("Independent").build();

        BDDMockito.given(breedService.findByName(name)).willReturn(breedEntity);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/" + name));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(breedEntity.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("origin").value(breedEntity.getOrigin()))
                .andExpect(MockMvcResultMatchers.jsonPath("temperament").value(breedEntity.getTemperament()))
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(breedEntity.getId()));
    }
}
