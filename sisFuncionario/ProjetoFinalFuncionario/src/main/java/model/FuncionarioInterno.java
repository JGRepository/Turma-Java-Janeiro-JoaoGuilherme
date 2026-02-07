package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.enums.CargoInterno;

public class FuncionarioInterno extends Pessoa {

	private String matricula;
	private CargoInterno cargo;
	private BigDecimal salario;
	private BigDecimal plr;

	public void setPlr(BigDecimal plr) {
		this.plr = plr;
	}

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
		return plr;
	}

}
