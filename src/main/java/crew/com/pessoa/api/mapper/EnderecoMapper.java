package crew.com.pessoa.api.mapper;

import crew.com.pessoa.api.request.EnderecoRequest;
import crew.com.pessoa.api.response.EnderecoResponse;
import crew.com.pessoa.domain.entity.Endereco;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EnderecoMapper {

    private final ModelMapper mapper;

    public Endereco toEndereco(EnderecoRequest request) {
        return mapper.map(request, Endereco.class);
    }

    public EnderecoResponse toEnderecoResponse(Endereco endereco) {
        return mapper.map(endereco, EnderecoResponse.class);
    }

    public List<EnderecoResponse> toEnderecoResponseList(List<Endereco> endereco) {
        return endereco.stream()
                .map(this::toEnderecoResponse)
                .collect(Collectors.toList());
    }
}
