package br.com.itau.catApi.entity;

import lombok.AllArgsConstructor;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Builder
@Data //lombok ( get and set automatico )
@Table(name = "breedsimage")
@AllArgsConstructor // Construtor com parametros
@NoArgsConstructor //  Construtor vazio
public class BreedImageInfoEntity {

    @Id
    @Column
    private String id;

    @Column
    private String url;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @ManyToOne
    @JoinColumn(name = "breeds_name")
    private BreedEntity breedEntity;

}