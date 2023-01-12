package crew.com.pessoa.api.controller;

import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        System.out.println("Oi");
        System.out.println(pessoa);
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSaved);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

}
