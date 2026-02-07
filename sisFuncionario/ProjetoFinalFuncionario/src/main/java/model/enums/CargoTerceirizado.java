package model.enums;

import java.math.BigDecimal;

public enum CargoTerceirizado {

	AUX_SERVICOS_GERAIS(new BigDecimal("50")), ENCARREGADO(new BigDecimal("40")), AJUDANTE(new BigDecimal("30"));

	private final BigDecimal valorHora;

	CargoTerceirizado(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}
}
