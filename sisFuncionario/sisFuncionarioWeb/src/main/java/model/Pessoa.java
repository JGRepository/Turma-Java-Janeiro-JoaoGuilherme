package model;

public class Pessoa {
	private String cpf;
	private String nome;
	private String email;
	private String usuario;
	private String senha;


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCpfValido() {

		if (cpf == null)
			return false;

		cpf = cpf.replaceAll("\\D", "");

		if (cpf.length() != 11)
			return false;

		if (cpf.matches("(\\d)\\1{10}"))
			return false;

		try {
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			}
			int primeiroDigito = 11 - (soma % 11);
			if (primeiroDigito >= 10)
				primeiroDigito = 0;

			if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
				return false;
			}

			soma = 0;
			for (int i = 0; i < 10; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			}
			int segundoDigito = 11 - (soma % 11);
			if (segundoDigito >= 10)
				segundoDigito = 0;

			return segundoDigito == Character.getNumericValue(cpf.charAt(10));

		} catch (Exception e) {
			return false;
		}
	}
}
