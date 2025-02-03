package br.com.bongiolo.dto;

public class DoadoresReceptoresDTO {
    private String tipoReceptor;
    private Integer quantidadeDoadores;

    public String getTipoReceptor() {
        return tipoReceptor;
    }

    public void setTipoReceptor(String tipoReceptor) {
        this.tipoReceptor = tipoReceptor;
    }

    public Integer getQuantidadeDoadores() {
        return quantidadeDoadores;
    }

    public void setQuantidadeDoadores(Integer quantidadeDoadores) {
        this.quantidadeDoadores = quantidadeDoadores;
    }
}
