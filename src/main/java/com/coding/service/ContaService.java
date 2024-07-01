package com.coding.service;

import com.coding.domain.Conta;
import com.coding.domain.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaService {

    static List<Conta> contas;

    private static List<Endereco> enderecos;

    static {
        contas = new ArrayList<>(List.of(new Conta(1L, "Renato", "Renato Lessa",
                "2023-10-09", 301286142, 29403840988L, "renato.lessa@gmail.com",

                enderecos = new ArrayList<>(List.of(new Endereco())))));
    }

    public List<Conta> listAll() {
        return contas;
    }

    public Conta findById(long id) {
        return contas.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não encontrada"));
    }

    public Conta save(Conta conta) {
        conta.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        contas.add(conta);
        return conta;
    }

    public void delete(long id) {
        contas.remove(findById(id));
    }

    public void replace(Conta conta) {
        delete(conta.getId());
        contas.add(conta);
    }
}
