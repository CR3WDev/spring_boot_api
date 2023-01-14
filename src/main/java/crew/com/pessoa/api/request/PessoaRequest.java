package crew.com.pessoa.api.request;

import crew.com.pessoa.api.response.EnderecoResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {
    @NotBlank(message = "Nome da pessoa é obrigatório")
    private String nome;
    private LocalDateTime data_de_nascimento;
    private Long main_endereco_id;
}

