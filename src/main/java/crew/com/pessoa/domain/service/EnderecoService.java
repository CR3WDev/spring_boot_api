package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Endereco;
import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Endereco save(Long pessoaId,Endereco endereco) {
        endereco.setPessoa_id(pessoaId);
        return enderecoRepository.save(endereco);
    }
    public List<Endereco> findAllByPessoaId(Long pessoaId) {
        return enderecoRepository.findAllByPessoaId(pessoaId);
    }
    public List<Endereco> findMainEndereco(Long pessoaId,Long mainEnderecoId) {
        return enderecoRepository.findMainEndereco(pessoaId,mainEnderecoId);

    }
}
