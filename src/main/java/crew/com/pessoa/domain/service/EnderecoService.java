package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        Optional<Pessoa> optPessoa = pessoaService.findById(endereco.getPessoa().getId());
        if(optPessoa.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        return enderecoRepository.save(endereco);
    }
}
