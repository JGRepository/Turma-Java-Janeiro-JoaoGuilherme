package codigoFonte;

public abstract class Atleta {

	private String nomeAtleta;
	private int idade;

	
	protected abstract Double calculcarPagamento();
	protected abstract Double valorPatronicio();

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtletaChegando) {
		this.nomeAtleta = nomeAtletaChegando;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idadeChegando) {

		verificarIdade(idadeChegando);
		this.idade = idadeChegando;
	}

	public void verificarIdade(int idade) {
		if (idade < 0) {
			throw new IllegalArgumentException("Idade não pode ser negativa");
		}
		if (idade < 15) {
			throw new IllegalArgumentException("Precisa ser maior que 15 anos");
		}
	}

	public void verificarValorNegativo(Double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor não pode ser negativo");
		}
	}
}
