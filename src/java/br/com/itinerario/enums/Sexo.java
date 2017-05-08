package br.com.itinerario.enums;

public enum Sexo {

    MASCULINO("MASCULINO", 0),
    FEMININO("FEMININO", 1);
    private String sexo;
    private Integer valor;

    private Sexo(String sexo, Integer valor) {
        this.sexo = sexo;
        this.valor = valor;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return sexo;
    }

}
