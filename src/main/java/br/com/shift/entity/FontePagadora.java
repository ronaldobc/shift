package br.com.shift.entity;

public class FontePagadora {

    public enum eTipo {
        Convenio,
        Particular,
        Outros
    }

    public int id;
    public String nome;
    public eTipo tipo;

}
