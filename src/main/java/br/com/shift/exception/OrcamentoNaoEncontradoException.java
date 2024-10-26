package br.com.shift.exception;

public class OrcamentoNaoEncontradoException extends RuntimeException  {

    public OrcamentoNaoEncontradoException() {
        super("Orçamento não Encontrado");
    }

}
