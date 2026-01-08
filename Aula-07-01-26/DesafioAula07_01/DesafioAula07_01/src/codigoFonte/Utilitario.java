package codigoFonte;

public class Utilitario {

	public void verificarValorNegativo(Double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Valor não pode ser negativo");
		}
	}
	
	public void verificarIdade(int idade) {
		if(idade < 0) {
			throw new IllegalArgumentException("Idade não pode ser negativa");
		}
		if(idade < 15) {
			throw new IllegalArgumentException("Precisa ser maior que 15 anos");
		}
	}
}
