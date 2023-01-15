package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PessoaServiceTest {
    @Autowired
    PessoaService pessoaService;

    @Test
    @DisplayName("Deve Salvar uma pessoa")
    void save() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Marcelo Victor(cr3w) Távora neves");
        pessoa.setData_de_nascimento(LocalDateTime.now());

        Pessoa pessoaSaved = pessoaService.save(pessoa);
        assertEquals(pessoaSaved, pessoa);
        pessoaService.deleteById(pessoaSaved.getId());
    }
}