package br.com.itau.www.catApi.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Breeds {

    private String origin;
    private String temperament;
    private String name;

}
