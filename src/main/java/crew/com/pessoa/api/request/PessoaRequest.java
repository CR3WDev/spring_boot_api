package crew.com.pessoa.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {
    @NotBlank(message = "Nome da pessoa é obrigatório")
    private String nome;
    private LocalDateTime data_de_nascimento;
    private Long endereco_principal_id;
}

