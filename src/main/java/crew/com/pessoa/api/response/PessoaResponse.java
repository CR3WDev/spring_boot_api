package crew.com.pessoa.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {
    private Long id;
    private String nome;
    private LocalDateTime data_de_nascimento;
}
