package com.coding.service;

import com.coding.domain.Conta;
import com.coding.domain.Endereco;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ContaServiceTest {

    @BeforeAll
    public static void setUp() {
        ContaService.contas = new ArrayList<>(List.of(new Conta(1L, "Renato", "Renato Lessa",
                "2023-10-09", 301286142, 29403840988L, "renato.lessa@gmail.com",

                 new ArrayList<>(List.of(new Endereco("Rua Gloria", 123, "90900-099", "São Paulo", "SP", "Brasil",
                         null))))));
    }

    @Test
    public void when_test_listAll() {
        ContaService mock =  new ContaService();
        List<Conta> contas = mock.listAll();

        assertNotNull(contas, "A lista de contas deve ser inicializada.");
        assertEquals(2, contas.size(), "A lista de contas de conter um elemento.");
        Conta conta = contas.get(0);

        assertEquals(1L, conta.getId(), "O ID da contas deve ser 1.");
        assertEquals("Renato", conta.getNome(), "O nome deve ser 'Renato'");
        assertEquals("Renato Lessa", conta.getNomeSocial(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("2023-10-09", conta.getDataNascimento(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals(301286142, conta.getRg(), "O RG deve ser 301286142.");
        assertEquals(29403840988L, conta.getCpf(), "O CPF deve ser '29403840988L'.");
        assertEquals("renato.lessa@gmail.com", conta.getEmail(), "O email ser  renato.lessa@gmail.com.");

        List<Endereco> enderecos = conta.getEnderecos();
        assertNotNull(enderecos, "A lista de endereços deve ser inicializada.");
        assertEquals(1, enderecos.size(), "A lista de endereços de conter um elemento.");

        Endereco endereco = enderecos.get(0);
        assertEquals("Rua Gloria", endereco.getNomeRua(), "O ID da contas deve ser 1.");
        assertEquals(123, endereco.getNumero(), "O nome deve ser 'Renato'");
        assertEquals("90900-099", endereco.getCep(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("São Paulo", endereco.getCidade(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals("SP", endereco.getEstado(), "O RG deve ser 301286142.");
        assertEquals("Brasil", endereco.getPais(), "O CPF deve ser '29403840988L'.");

    }

    @Test
    public void when_test_find_by_success() {

        ContaService mock =  new ContaService();
        Conta conta = mock.findById(1L);

        assertNotNull("A conta não deve ser nula");

        assertEquals(1L, conta.getId(), "O ID da contas deve ser 1.");
        assertEquals("Renato", conta.getNome(), "O nome deve ser 'Renato'");
        assertEquals("Renato Lessa", conta.getNomeSocial(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("2023-10-09", conta.getDataNascimento(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals(301286142, conta.getRg(), "O RG deve ser 301286142.");
        assertEquals(29403840988L, conta.getCpf(), "O CPF deve ser '29403840988L'.");
        assertEquals("renato.lessa@gmail.com", conta.getEmail(), "O email ser  renato.lessa@gmail.com.");

        List<Endereco> enderecos = conta.getEnderecos();
        assertNotNull(enderecos, "A lista de endereços deve ser inicializada.");
        assertEquals(1, enderecos.size(), "A lista de endereços de conter um elemento.");

        Endereco endereco = enderecos.get(0);
        assertEquals("Rua Gloria", endereco.getNomeRua(), "O ID da contas deve ser 1.");
        assertEquals(123, endereco.getNumero(), "O nome deve ser 'Renato'");
        assertEquals("90900-099", endereco.getCep(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("São Paulo", endereco.getCidade(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals("SP", endereco.getEstado(), "O RG deve ser 301286142.");
        assertEquals("Brasil", endereco.getPais(), "O CPF deve ser '29403840988L'.");


    }

    @Test
    public void when_test_find_by_not_found() {

        ContaService mock = new ContaService();

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            mock.findById(2L);
        });

        assertEquals("400 BAD_REQUEST \"Conta não encontrada\"", exception.getMessage());

    }

    @Test
    public void when_test_to_save() {
        ContaService mock = new ContaService();
        Conta novaConta = new Conta(1L, "Renato", "Renato Lessa",
                "2023-10-09", 301286142, 29403840988L, "renato.lessa@gmail.com",

                new ArrayList<>(List.of(new Endereco("Rua Gloria", 123, "90900-099", "São Paulo", "SP", "Brasil",
                        null))));



        Conta contaSalva = mock.save(novaConta);

        assertNotNull(contaSalva, "A conta salva não pode ser nula");
        assertNotNull(contaSalva.getId(), "A conta deve ter um ID");
        assertTrue(contaSalva.getId() >= 3 && contaSalva.getId() < 100000, "" +
                "O ID da conta deve estar no intervalo de 3, 100000");

        //assertEquals(1L, contaSalva.getId(), "O ID da contas deve ser 1.");
        assertEquals("Renato", contaSalva.getNome(), "O nome deve ser 'Renato'");
        assertEquals("Renato Lessa", contaSalva.getNomeSocial(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("2023-10-09", contaSalva.getDataNascimento(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals(301286142, contaSalva.getRg(), "O RG deve ser 301286142.");
        assertEquals(29403840988L, contaSalva.getCpf(), "O CPF deve ser '29403840988L'.");
        assertEquals("renato.lessa@gmail.com", contaSalva.getEmail(), "O email ser  renato.lessa@gmail.com.");

        List<Endereco> enderecos = contaSalva.getEnderecos();
        assertNotNull(enderecos, "A lista de endereços deve ser inicializada.");
        assertEquals(1, enderecos.size(), "A lista de endereços de conter um elemento.");

        Endereco endereco = enderecos.get(0);
        assertEquals("Rua Gloria", endereco.getNomeRua(), "O ID da contas deve ser 1.");
        assertEquals(123, endereco.getNumero(), "O nome deve ser 'Renato'");
        assertEquals("90900-099", endereco.getCep(), "O nome social deve ser 'Renato Lessa'");
        assertEquals("São Paulo", endereco.getCidade(), "A data de nascimento deve ser '2023-10-09'");
        assertEquals("SP", endereco.getEstado(), "O RG deve ser 301286142.");
        assertEquals("Brasil", endereco.getPais(), "O CPF deve ser '29403840988L'.");

    }

    @Test
    public void when_test_to_Delete_conta_inexistente() {
        // Deletar uma conta que não existe
        ContaService mock = new ContaService();

        assertThrows(RuntimeException.class, () -> mock.delete(999L));
    }

    @Test
    public void testReplaceContaExistente() {
        ContaService mock = new ContaService();
        // Criar uma conta para substituir
        Conta contaNova = new Conta(1L, "Renato", "Renato Lessa",
                "2023-10-09", 301286142, 29403840988L, "renato.lessa@gmail.com",
                List.of(new Endereco("Rua Gloria", 123, "90900-099", "São Paulo", "SP", "Brasil",
                        null)));

        // Adicionar a conta inicial ao banco
        mock.save(new Conta(1L, "Renato", "Renato Lessa",
                "2023-10-09", 301286142, 29403840988L, "renato.lessa@gmail.com",
                List.of(new Endereco("Rua Gloria", 123, "90900-099", "São Paulo", "SP", "Brasil",
                        null))));

        // Substituir a conta existente
        mock.replace(contaNova);

        // Verificar se a conta foi substituída corretamente
        Conta contaSubstituida = mock.findById(1L);
        assertNotNull(contaSubstituida);
        assertEquals("Renato", contaSubstituida.getNome());
        assertEquals("Renato Lessa", contaSubstituida.getNomeSocial());
    }
}
