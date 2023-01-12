package crew.com.pessoa.domain.repository;

import crew.com.pessoa.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Long, Pessoa> { }
