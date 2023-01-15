package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.entity.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnderecoServiceTest {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    EnderecoService enderecoService;
    @Test
    @DisplayName("Deve salvar um endereço em pessoa")
    void save() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Marcelo Victor(cr3w) Távora neves");
        pessoa.setData_de_nascimento(LocalDateTime.now());

        Pessoa pessoaSaved = pessoaService.save(pessoa);
        assertEquals(pessoaSaved,pessoa);

        Endereco endereco = new Endereco();
        endereco.setPessoa_id(pessoaSaved.getId());
        endereco.setLogradouro("Rua cicero alves de souza");
        endereco.setCep("60822810");
        endereco.setCidade("Fortaleza");
        endereco.setNumero("48");
        Endereco enderecoSaved = enderecoService.save(pessoaSaved.getId(), endereco);
        assertEquals(enderecoSaved,endereco);
    }
}