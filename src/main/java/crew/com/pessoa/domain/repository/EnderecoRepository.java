package crew.com.pessoa.domain.repository;

import crew.com.pessoa.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT E FROM Endereco E WHERE E.pessoa_id = ?1")
    List<Endereco> findAllByPessoaId(Long id);
}
