package br.com.shift.entity;

public class Procedimento extends Item {

    public enum eTipoProcedimento {
        CustoMaterial,
        CustoMedicamento,
        Taxa,
        Anestesia
    }

    public eTipoProcedimento tipo;

}
