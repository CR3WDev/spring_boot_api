package crew.com.pessoa.domain.repository;

import crew.com.pessoa.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
