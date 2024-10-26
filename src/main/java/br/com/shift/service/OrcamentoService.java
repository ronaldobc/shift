package br.com.shift.service;

import br.com.shift.data.Dados;
import br.com.shift.entity.Orcamento;
import br.com.shift.exception.AtualizarOrcamentoException;
import br.com.shift.exception.NovoOrcamentoException;
import br.com.shift.exception.OrcamentoNaoEncontradoException;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrcamentoService implements IOrcamentoService {

    private final Dados dados;

    public OrcamentoService(Dados dados) {
        this.dados = dados;
    }

    @Override
    public List<Orcamento> retornarPorFonteOuPessoa(int idFonte, int idPessoa) {
        if (idFonte != 0 && idPessoa != 0) {
            return dados.orcamentos.stream()
                             .filter(o -> o.idFontePagadora == idFonte && o.idPessoaFisica == idPessoa)
                             .toList();
        }
        if (idFonte != 0) {
            return dados.orcamentos.stream()
                    .filter(o -> o.idFontePagadora == idFonte )
                    .toList();
        }
        if (idPessoa != 0) {
            return dados.orcamentos.stream()
                    .filter(o -> o.idPessoaFisica == idPessoa )
                    .toList();
        }
        return new ArrayList<>();
    }

    @Override
    public Orcamento retornarPorId(int id) throws RuntimeException {
        var orcamento = dados.orcamentos.stream().filter(o->o.id == id).findFirst().orElse(null);
        if (orcamento == null) {
            throw new OrcamentoNaoEncontradoException();
        }
        return orcamento;
    }

    @Override
    public void deletar(int id) throws RuntimeException {
        var orcamento = retornarPorId(id);
        if (orcamento == null) {
            throw new OrcamentoNaoEncontradoException();
        }else {
            dados.orcamentos.remove(orcamento);
        }
    }

    @Override
    public Orcamento criar(Orcamento orcamento) throws RuntimeException {

        if (orcamento == null) {
            throw new NovoOrcamentoException("Estrutura do orçamento inválida");
        }

        // validar regras de negócio de criação
        // ou chamar camada de negócio para validação
        // exemplos aqui no service (não é o ideal)
        try {
            orcamento.validar();
        } catch (RuntimeException e) {
            throw new NovoOrcamentoException(e.getMessage());
        }

        orcamento.id = dados.gerarCodigoOrcamento();
        orcamento.dataCadastro = LocalDateTime.now();

        dados.orcamentos.add(orcamento);

        return orcamento;
    }

    @Override
    public Orcamento atualizar(Orcamento orcamento) throws RuntimeException {


        if (orcamento == null) {
            throw new AtualizarOrcamentoException("Estrutura do orçamento inválida");
        }
        if (orcamento.id <= 0) {
            throw new OrcamentoNaoEncontradoException();
        }

        var tmp = retornarPorId(orcamento.id);

        // validar regras de negócio de atualização
        // ou chamar camada de negócio para validação
        // exemplos aqui no service (não é o ideal)
        try {
            orcamento.validar();
        } catch (RuntimeException e) {
            throw new NovoOrcamentoException(e.getMessage());
        }

        var pos = dados.orcamentos.indexOf(tmp);
        dados.orcamentos.set(pos, orcamento);

        return orcamento;

    }
}
