package com.example.gastos.domain.Enum;

public enum ETypeTitle {
    TORECIBE("A receber"),
    TOPAY("A pagar");

    private String valor;

    private ETypeTitle(String valor) {
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }
}
