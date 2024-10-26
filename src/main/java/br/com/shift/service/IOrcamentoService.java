package br.com.shift.service;

import br.com.shift.entity.Orcamento;

import java.util.List;

public interface IOrcamentoService {

    List<Orcamento> retornarPorFonteOuPessoa(int idFonte, int idPessoa);
    Orcamento retornarPorId(int id) throws RuntimeException;
    void deletar(int id) throws RuntimeException;
    Orcamento criar(Orcamento orcamento) throws RuntimeException;
    Orcamento atualizar(Orcamento orcamento) throws RuntimeException;

}
