package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import model.enums.CargoInterno;

public class FuncionarioInterno extends Pessoa {

	private String matricula;
	private CargoInterno cargo;
	private BigDecimal salario;

	public FuncionarioInterno() {
		// default constructor
	}

	public FuncionarioInterno(String cpf, String nome, LocalDate dataNascimento, String matricula, CargoInterno cargo,
			BigDecimal salario) {
		super();
		this.matricula = matricula;
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public CargoInterno getCargo() {
		return cargo;
	}

	public void setCargo(CargoInterno cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getPlr() {
		if (salario == null) {
			return BigDecimal.ZERO;
		}
		return salario.multiply(new BigDecimal("0.80")).setScale(2, RoundingMode.HALF_UP);
	}

}
