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
@RequestMapping("/endereco/pessoa")
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

    @GetMapping("/{id}")
    public ResponseEntity<List<EnderecoResponse>> findById(@PathVariable Long id) {
        Optional<Pessoa> optPessoa = pessoaService.findById(id);
        if (optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Endereco> enderecos = enderecoService.findAllByPessoaId(id);
        List<EnderecoResponse> enderecosResponse = mapper.toEnderecoResponseList(enderecos);
        return ResponseEntity.status(HttpStatus.OK).body(enderecosResponse);
    }

    @PostMapping("/{pessoa_id}")
    public ResponseEntity<EnderecoResponse> save(@PathVariable Long pessoa_id,@Valid @RequestBody EnderecoRequest request) {
        Optional<Pessoa> optPessoa = pessoaService.findById(pessoa_id);
        if(optPessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Endereco endereco = mapper.toEndereco(request);
        Endereco enderecoSaved = enderecoService.save(pessoa_id,endereco);
        EnderecoResponse enderecoResponse = mapper.toEnderecoResponse(enderecoSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponse);
    }
}
