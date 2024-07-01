package com.coding.controller;

import com.coding.domain.Conta;
import com.coding.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coding-java")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @GetMapping("listar-todas-contas")
    public ResponseEntity<List<Conta>> list() {
        return new ResponseEntity<>(contaService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> findById(@PathVariable long id) {
        return ResponseEntity.ok(contaService.findById(id));
    }
    @PostMapping("inserindo-conta")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        return new ResponseEntity<>(contaService.save(conta), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conta> replace(@RequestBody Conta conta) {
        contaService.replace(conta);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable long id) {
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
