package br.com.bongiolo.dto;

import java.math.BigDecimal;

public class ObesoDTO {
    private String generoMasculino;
    private String generoFeminino;
    private BigDecimal percentualObeso;

    public String getGeneroMasculino() {
        return generoMasculino;
    }

    public void setGeneroMasculino(String generoMasculino) {
        this.generoMasculino = generoMasculino;
    }

    public String getGeneroFeminino() {
        return generoFeminino;
    }

    public void setGeneroFeminino(String generoFeminino) {
        this.generoFeminino = generoFeminino;
    }

    public BigDecimal getPercentualObeso() {
        return percentualObeso;
    }

    public void setPercentualObeso(BigDecimal percentualObeso) {
        this.percentualObeso = percentualObeso;
    }
}
