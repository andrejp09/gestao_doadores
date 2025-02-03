package br.com.bongiolo.dto;

import java.math.BigDecimal;

public class DoadoresFaixaEtariaIMCMedioDTO {

    private String faixaEtaria;
    private BigDecimal imcMedio;

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public BigDecimal getImcMedio() {
        return imcMedio;
    }

    public void setImcMedio(BigDecimal imcMedio) {
        this.imcMedio = imcMedio;
    }
}
