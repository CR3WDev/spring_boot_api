package crew.com.pessoa.domain.entity;

import crew.com.pessoa.api.response.EnderecoResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

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
    private Long endereco_principal_id;

    @OneToMany
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> enderecos;
}
