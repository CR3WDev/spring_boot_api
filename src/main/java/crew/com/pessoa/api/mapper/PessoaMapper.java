package crew.com.pessoa.api.mapper;

import crew.com.pessoa.api.request.PessoaRequest;
import crew.com.pessoa.api.response.PessoaResponse;
import crew.com.pessoa.domain.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper mapper;

    public Pessoa toPessoa(PessoaRequest request) {
        return mapper.map(request, Pessoa.class);
    }
    public PessoaResponse toPessoaResponse(Pessoa pessoa) {
        return mapper.map(pessoa,PessoaResponse.class);
    }

    public List<PessoaResponse> toPessoaResponseList(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toPessoaResponse)
                .collect(Collectors.toList());
    }

}
