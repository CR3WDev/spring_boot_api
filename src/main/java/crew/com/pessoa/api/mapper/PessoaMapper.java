package crew.com.pessoa.api.mapper;

import crew.com.pessoa.api.request.PessoaRequest;
import crew.com.pessoa.api.response.PessoaResponse;
import crew.com.pessoa.domain.entity.Pessoa;

public class PessoaMapper {

    public static Pessoa toPessoa(PessoaRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());
        pessoa.setData_de_nascimento(request.getData_de_nascimento());
        pessoa.setEndereco_principal_id(request.getEndereco_principal_id());
        return pessoa;
    }

    public static PessoaResponse toPessoaResponse(Pessoa pessoa) {
        PessoaResponse response = new PessoaResponse();
        response.setId(pessoa.getId());
        response.setNome(pessoa.getNome());
        response.setData_de_nascimento(pessoa.getData_de_nascimento());
        response.setEndereco_principal_id(pessoa.getEndereco_principal_id());
        return response;
    }
}
