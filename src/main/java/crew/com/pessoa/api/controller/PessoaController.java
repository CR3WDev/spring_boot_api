package crew.com.pessoa.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if(optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pessoa pessoa = optPessoa.get();
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
