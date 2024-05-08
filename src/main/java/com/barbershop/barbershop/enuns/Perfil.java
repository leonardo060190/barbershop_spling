package com.barbershop.barbershop.enuns;


import lombok.Getter;
import lombok.Setter;

@Getter

public enum Perfil {
    ADMIN(0, "Administrador"),
    CLIENTE(0, "Cliente"),
    BARBEARIA(0, "Barbearia");
    private Integer codigo;
    private String decricao;

    Perfil(Integer codigo, String decricao) {
        this.codigo = codigo;
        this.decricao = decricao;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (Perfil perfil: Perfil.values()) {
            if (cod.equals(perfil.getCodigo())){
                return perfil;
            }
        } throw new IllegalArgumentException("Perfil inválido"); }


}

