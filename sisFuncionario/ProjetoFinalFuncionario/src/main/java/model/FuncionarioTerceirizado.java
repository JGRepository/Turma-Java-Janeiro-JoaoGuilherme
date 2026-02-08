package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.enums.CargoTerceirizado;

public class FuncionarioTerceirizado extends Pessoa {

	private CargoTerceirizado funcao;
	private String empresa;
	private int horasTrabalhadas;
	private BigDecimal lucro;
	private BigDecimal custo;

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public CargoTerceirizado getFuncao() {
		return funcao;
	}

	public void setFuncao(CargoTerceirizado funcao) {
		this.funcao = funcao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int setHorasTrabalhadas) {
		this.horasTrabalhadas = setHorasTrabalhadas;
	}

	public BigDecimal getCustoTotal() {
		if (funcao == null || horasTrabalhadas <= 0) {
			return BigDecimal.ZERO;
		}

		BigDecimal custoBase = funcao.getValorHora().multiply(BigDecimal.valueOf(horasTrabalhadas));

		return custoBase.multiply(new BigDecimal("1.30")).setScale(2, RoundingMode.HALF_UP);
	}

}
