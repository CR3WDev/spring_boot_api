package crew.com.pessoa.api.controller;

import crew.com.pessoa.api.mapper.EnderecoMapper;
import crew.com.pessoa.api.mapper.PessoaMapper;
import crew.com.pessoa.api.request.PessoaRequest;
import crew.com.pessoa.api.response.EnderecoResponse;
import crew.com.pessoa.api.response.PessoaResponse;
import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.service.EnderecoService;
import crew.com.pessoa.domain.service.PessoaService;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.validation.Valid;
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
    private final PessoaMapper mapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@Valid @RequestBody PessoaRequest request) {
        Pessoa pessoa = mapper.toPessoa(request);
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        PessoaResponse pessoaResponse = mapper.toPessoaResponse(pessoaSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> findAll() {
        List<Pessoa> pessoas = pessoaService.finAll();
        List<PessoaResponse> pessoasResponses = mapper.toPessoaResponseList(pessoas);
        return ResponseEntity.status(HttpStatus.OK).body(pessoasResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if (optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pessoa pessoa = optPessoa.get();
        PessoaResponse pessoaResponse = mapper.toPessoaResponse(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> update(@PathVariable Long id,@RequestBody Pessoa pessoa) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if (optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pessoa pessoaSaved = pessoaService.update(id,pessoa);
        PessoaResponse pessoaResponse = mapper.toPessoaResponse(pessoaSaved);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if (optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
