package com.example.Proyecto.modelos;

public enum Categoria {
    HOGAR(1),  
    ASEO(2),  
    ROPA(3),  
    COMESTIBLES(4);  

    private final int valor;  

    Categoria(int valor) {  
        this.valor = valor;  
    }  

    public int getValor() {  
        return valor;  
    }  

    // Opcional: Método para obtener Categoria desde un int
    public static Categoria fromInt(int valor) {
        for (Categoria cat : values()) {
            if (cat.getValor() == valor) {
                return cat;
            }
        }
        return null;
    }
}
