package model.enums;

import java.math.BigDecimal;

public enum CargoTerceirizado {
	AUX_SERVICOS_GERAIS,
    ENCARREGADO,
    AJUDANTE;

    private BigDecimal valorHora = null;





	void FuncaoTerceirizado(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }
}
