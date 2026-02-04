package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import model.enums.CargoTerceirizado;

public class FuncionarioTerceirizado extends Pessoa {

	private CargoTerceirizado funcao;
	private String empresa;
	private int horasTrabalhadas;

	public FuncionarioTerceirizado() {
	}

	public FuncionarioTerceirizado(String cpf, String nome, LocalDate dataNascimento, CargoTerceirizado funcao,
			String empresa, int horasTrabalhadas) {
		super();
		this.funcao = funcao;
		this.empresa = empresa;
		this.horasTrabalhadas = horasTrabalhadas;
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

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public BigDecimal getCustoTotal() {
		if (funcao == null || horasTrabalhadas <= 0) {
			return BigDecimal.ZERO;
		}

		BigDecimal custoBase = funcao.getValorHora().multiply(BigDecimal.valueOf(horasTrabalhadas));

		return custoBase.multiply(new BigDecimal("1.30")).setScale(2, RoundingMode.HALF_UP);
	}

}
