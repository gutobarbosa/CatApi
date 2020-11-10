package br.com.itau.catApi.controller;

import br.com.itau.catApi.entity.BreedEntity;
import br.com.itau.catApi.http.component.BreedRoutes;
import br.com.itau.catApi.repository.BreedRepository;
import br.com.itau.catApi.services.BreedService;
import br.com.itau.catApi.services.ImageInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import static org.hamcrest.Matchers.is;
import org.mockito.Mockito;
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

import java.util.Collections;
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

    @MockBean
    BreedRepository breedRepository;

    @Test
    public void getBreedByNameTest() throws Exception {

        String name = "Abyssinian";

        BreedEntity breedEntity = BreedEntity.builder().id("abys").name("Abyssinian").origin("Egypt").temperament("Independent").build();

        BDDMockito.given(breedService.findByName(name)).willReturn(Optional.of(breedEntity));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/" + name));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(breedEntity.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("origin").value(breedEntity.getOrigin()))
                .andExpect(MockMvcResultMatchers.jsonPath("temperament").value(breedEntity.getTemperament()))
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(breedEntity.getId()));

    }

    @Test
    public void getBreedByNameNotFoundTest() throws Exception {

        BDDMockito.given(breedService.findByName(Mockito.anyString())).willReturn(Optional.empty());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/"+ "anything"));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isNotFound());


    }

    @Test
    public void getBreedByOriginTest() throws Exception {

        String origin = "Japan";

        BreedEntity breedEntity = BreedEntity.builder().id("abys").name("Abyssinian").origin("Japan").temperament("Independent").build();

        BDDMockito.given(breedService.findAllByOrigin(origin)).willReturn(Optional.of(Collections.singletonList(breedEntity)));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/origin/" + origin));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("abys")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Abyssinian")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin", is("Japan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].temperament", is("Independent")));

    }

    @Test
    public void getBreedByOriginNotFoundTest() throws Exception {

        BDDMockito.given(breedService.findAllByOrigin(Mockito.anyString())).willReturn(Optional.empty());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/origin/anything"));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isNotFound());


    }

    @Test
    public void getBreedByTemperamentTest() throws Exception {

        String temperament = "Patient";

        BreedEntity breedEntity = BreedEntity.builder().id("abys").name("Abyssinian").origin("Japan").temperament("Patient").build();

        BDDMockito.given(breedService.findAllByTemperamentContains(temperament)).willReturn(Optional.of(Collections.singletonList(breedEntity)));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/temperaments/" + temperament));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("abys")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Abyssinian")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin", is("Japan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].temperament", is("Patient")));


    }

    @Test
    public void getBreedByTemperamentNotFoundTest() throws Exception {

        BDDMockito.given(breedService.findAllByTemperamentContains(Mockito.anyString())).willReturn(Optional.empty());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL.concat("/temperaments/anything"));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isNotFound());


    }

    @Test
    public void getBreedsTest() throws Exception {

        BreedEntity breedEntity = BreedEntity.builder().id("abys").name("Abyssinian").origin("Japan").temperament("Independent").build();

        BDDMockito.given(breedService.findAll()).willReturn(Optional.of(Collections.singletonList(breedEntity)));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL);

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("abys")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Abyssinian")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].origin", is("Japan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].temperament", is("Independent")));


    }

    @Test
    public void getBreedsNotFoundTest() throws Exception {

        BDDMockito.given(breedRepository.findAllByOrigin(Mockito.anyString())).willReturn(Optional.empty());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BREED_URL);

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isNotFound());


    }

}
