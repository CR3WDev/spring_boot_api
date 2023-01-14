package crew.com.pessoa.api.controller;

import crew.com.pessoa.api.mapper.EnderecoMapper;
import crew.com.pessoa.api.request.EnderecoRequest;
import crew.com.pessoa.api.response.EnderecoResponse;
import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.service.EnderecoService;
import crew.com.pessoa.domain.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    private final EnderecoService enderecoService;
    private final PessoaService pessoaService;
    private final EnderecoMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> findAll() {
        List<Endereco> enderecos = enderecoService.findAll();
        List<EnderecoResponse> enderecosResponse = mapper.toEnderecoResponseList(enderecos);
        return ResponseEntity.status(HttpStatus.OK).body(enderecosResponse);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<EnderecoResponse>> findById(@PathVariable Long pessoaId) {
        Optional<Pessoa> optPessoa = pessoaService.findById(pessoaId);
        if (optPessoa.isEmpty()) return ResponseEntity.notFound().build();
        List<Endereco> enderecos = enderecoService.findAllByPessoaId(pessoaId);
        List<EnderecoResponse> enderecosResponse = mapper.toEnderecoResponseList(enderecos);
        return ResponseEntity.status(HttpStatus.OK).body(enderecosResponse);
    }

    @GetMapping("/main/pessoa/{pessoaId}")
    public ResponseEntity<List<EnderecoResponse>> findMainEndereco(@PathVariable Long pessoaId) {
        Optional<Pessoa> optPessoa = pessoaService.findById(pessoaId);
        if (optPessoa.isEmpty()) return ResponseEntity.notFound().build();
        Long mainEnderecoId = optPessoa.get().getMain_endereco_id();
        List<Endereco> endereco = enderecoService.findMainEndereco(pessoaId, mainEnderecoId);
        if (endereco.size() == 0) return ResponseEntity.notFound().build();
        List<EnderecoResponse> enderecoResponse = mapper.toEnderecoResponseList(endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponse);
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<EnderecoResponse> save(@PathVariable Long pessoaId, @Valid @RequestBody EnderecoRequest request) {
        Optional<Pessoa> optPessoa = pessoaService.findById(pessoaId);
        if (optPessoa.isEmpty()) return ResponseEntity.notFound().build();
        Endereco endereco = mapper.toEndereco(request);
        Endereco enderecoSaved = enderecoService.save(pessoaId, endereco);
        EnderecoResponse enderecoResponse = mapper.toEnderecoResponse(enderecoSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponse);
    }
}
