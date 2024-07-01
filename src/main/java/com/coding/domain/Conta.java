package com.coding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Conta {

    private Long id;
    private String nome;
    private String nomeSocial;
    private String dataNascimento;
    private long rg;
    private long cpf;
    private String email;

    private List<Endereco> enderecos = new ArrayList<>();

}

// Aqui esta o Json usado em aula, caso queira testar...

//    {
//            "id": 1,
//            "nome": "Renato",
//            "nomeSocial": "Renato Lessa",
//            "dataNascimento": "2023-10-09",
//            "rg": 301286142,
//            "cpf": 29403840988,
//            "email": "renato.lessa@gmail.com",
//            "enderecos": [
//            {
//            "nomeRua": "Rua Carlos",
//            "numero": 212,
//            "cep": "90909990",
//            "cidade": "São Paulo",
//            "estado": "São Paulo",
//            "pais": "Brasil"
//            }
//            ]
//            }