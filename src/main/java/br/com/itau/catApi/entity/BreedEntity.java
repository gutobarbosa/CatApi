package br.com.itau.catApi.entity;

import lombok.AllArgsConstructor;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Builder
@Data //lombok ( get and set automatico )
@Table(name = "breeds")
@AllArgsConstructor // Construtor com parametros
@NoArgsConstructor //  Construtor vazio
public class BreedEntity {
    @Id
    private String id;

    @Column
    private String origin;

    @Column
    private String temperament;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "breedEntity")
    private List<BreedImageInfoEntity> breedImageInfoEntity;


}
