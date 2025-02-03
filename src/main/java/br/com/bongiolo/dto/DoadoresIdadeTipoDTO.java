package br.com.bongiolo.dto;

import java.math.BigDecimal;

public class DoadoresIdadeTipoDTO {

    private String tipo;
    private BigDecimal mediaIdade;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMediaIdade() {
        return mediaIdade;
    }

    public void setMediaIdade(BigDecimal mediaIdade) {
        this.mediaIdade = mediaIdade;
    }
}
