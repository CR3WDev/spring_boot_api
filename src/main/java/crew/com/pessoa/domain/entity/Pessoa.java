package crew.com.pessoa.domain.entity;

import crew.com.pessoa.api.response.EnderecoResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime data_de_nascimento;
    private Long main_endereco_id;

    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER,mappedBy="pessoa_id", orphanRemoval=true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<Endereco> enderecos;
}
