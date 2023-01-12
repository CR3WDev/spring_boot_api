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
    private final PessoaMapper mapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest request) {
        Pessoa pessoa = mapper.toPessoa(request);
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        PessoaResponse pessoaResponse = mapper.toPessoaResponse(pessoa);
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

    @PutMapping
    public ResponseEntity<PessoaResponse> update(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSaved = pessoaService.save(pessoa);
        PessoaResponse pessoaResponse = mapper.toPessoaResponse(pessoaSaved);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
