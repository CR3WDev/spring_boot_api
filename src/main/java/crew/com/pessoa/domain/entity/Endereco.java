package crew.com.pessoa.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "endereco")
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "logradouro")
    private String logradouro;
    @Column (name = "cep")
    private String cep;
    @Column (name = "numero")
    private String numero;
    @Column (name = "cidade")
    private String cidade;
    @ManyToOne
    private Pessoa pessoa;
}
