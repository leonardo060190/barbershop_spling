package com.barbershop.barbershop.enuns;

import lombok.Getter;


@Getter
public enum Status {
    ABERTO(0, "Aberto"),
    CONCLUIDO(0, "Concluído"),
    CANCELADO(0, "Cancelado");

    private Integer codigo;

    private  String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }



    public static Status toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (Status status: Status.values()) {
            if (cod.equals(status.getCodigo())){
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
