package crew.com.pessoa.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainEnderecoRequest {
    @NonNull
    private Long main_endereco_id;
}
