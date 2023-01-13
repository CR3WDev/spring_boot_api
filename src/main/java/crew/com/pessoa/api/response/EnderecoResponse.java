package crew.com.pessoa.api.response;


import crew.com.pessoa.domain.entity.Pessoa;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    private PessoaResponse pessoa;
}
