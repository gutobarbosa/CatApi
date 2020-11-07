package br.com.itau.catApi.http.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Breeds {

    private String origin;
    private String temperament;
    private String name;

}
