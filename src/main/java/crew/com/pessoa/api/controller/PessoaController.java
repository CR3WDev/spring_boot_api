package crew.com.pessoa.api.controller;

import crew.com.pessoa.api.mapper.PessoaMapper;
import crew.com.pessoa.api.request.PessoaRequest;
import crew.com.pessoa.api.response.PessoaResponse;
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
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest request) {
        Pessoa pessoa = PessoaMapper.toPessoa(request);
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        PessoaResponse pessoaResponse = PessoaMapper.toPessoaResponse(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.finAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if (optPessoa.isEmpty()) {
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
