package crew.com.pessoa.domain.service;

import crew.com.pessoa.domain.entity.Pessoa;
import crew.com.pessoa.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }


}
