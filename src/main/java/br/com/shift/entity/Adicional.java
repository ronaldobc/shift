package br.com.shift.entity;

public class Adicional extends Item {

    public enum eTipoAdicional {
        CustoMaterial,
        CustoMedicamento,
        Taxa,
        Anestesia
    }

    public eTipoAdicional tipo;
}
