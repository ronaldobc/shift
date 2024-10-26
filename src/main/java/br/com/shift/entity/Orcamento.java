package br.com.shift.entity;

import br.com.shift.exception.AtualizarOrcamentoException;
import br.com.shift.exception.NovoOrcamentoException;

import java.time.LocalDateTime;
import java.util.List;

public class Orcamento {

    public enum eTipoStatus {
        EmAnalise,
        Aprovado,
        NaoAprovado
    }

    public int id;
    public LocalDateTime dataValidade;
    public LocalDateTime dataCadastro;
    public double valorTotal;
    public double valorDesconto;
    public String descricao;
    public eTipoStatus status;
    public boolean finalizado;
    public int idPessoaFisica;
    public int idFontePagadora;
    public List<ItemOrcamento> itens;

    public void validar() throws RuntimeException {
        if (this.dataValidade == null) {
            throw new RuntimeException("Data de validade obrigatória");
        }
        if (this.dataValidade.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Data de validade não pode ser anterior a data atual");
        }
        if (this.idPessoaFisica <= 0) {
            throw new RuntimeException("id da pessoa física obrigatória");
        }
        if (this.idFontePagadora <= 0) {
            throw new RuntimeException("id da fonte pagadora obrigatória");
        }
    }

}


