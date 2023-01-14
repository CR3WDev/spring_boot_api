package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private final PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa) {
       return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> finAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa update(Long id, Pessoa pessoa) {
        Optional<Pessoa> optPessoa = findById(id);
        if(optPessoa.isEmpty()) {
            throw new RuntimeException("TEste");
        }
        if(pessoa.getNome() != null) {
            optPessoa.get().setNome(pessoa.getNome());
        }
        if(pessoa.getData_de_nascimento() != null) {
            optPessoa.get().setData_de_nascimento(pessoa.getData_de_nascimento());
        }
        if(pessoa.getEndereco_principal_id() != null) {
            optPessoa.get().setEndereco_principal_id(pessoa.getEndereco_principal_id());
        }
        return save(optPessoa.get());
    }


}
