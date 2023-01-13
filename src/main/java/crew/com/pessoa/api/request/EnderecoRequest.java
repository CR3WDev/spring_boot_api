package crew.com.pessoa.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    @NotBlank
    private String logradouro;
    private String cep;
    private String numero;
    @NotBlank
    private String cidade;

    @NotNull
    private Long pessoaId;
}
