package crew.com.pessoa.api.controller;

import crew.com.pessoa.api.mapper.EnderecoMapper;
import crew.com.pessoa.api.request.EnderecoRequest;
import crew.com.pessoa.api.response.EnderecoResponse;
import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.service.EnderecoService;
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
    private final EnderecoMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> findAll() {
        List<Endereco> enderecos = enderecoService.findAll();
        List<EnderecoResponse> enderecosResponse = mapper.toEnderecoResponseList(enderecos);
        return ResponseEntity.status(HttpStatus.OK).body(enderecosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> findById(@PathVariable Long id) {
        Optional<Endereco> optEndereco = enderecoService.findById(id);
        if (optEndereco.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        EnderecoResponse enderecoResponse = mapper.toEnderecoResponse(optEndereco.get());
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponse);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> save(@Valid @RequestBody EnderecoRequest request) {
        Endereco endereco = mapper.toEndereco(request);
        Endereco enderecoSaved = enderecoService.save(endereco);
        EnderecoResponse enderecoResponse = mapper.toEnderecoResponse(enderecoSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponse);
    }
}
