package br.com.itau.catApi.entity;

import lombok.AllArgsConstructor;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@javax.persistence.Entity
@Builder
@Data //lombok ( get and set automatico )
@Table
@AllArgsConstructor // Construtor com parametros
@NoArgsConstructor //  Construtor vazio
public class BreedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String origin;

    @Column
    private String temperament;

    @Column
    private String name;
}
