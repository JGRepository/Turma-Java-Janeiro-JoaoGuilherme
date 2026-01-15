package codigoFonte;

public abstract class Atleta {

	private String nomeAtleta;
	private int idade;
	private Double salario;
	private Double patrocinio;
	private long identificador;

	protected abstract Double calculcarPagamento();
	protected abstract Double valorPatronicio();
	
	
	public Atleta(long identificador) {
		this.identificador = identificador;
	}
	
	public long getIdentificador() {
		return identificador;
	}
	
//	public Atleta(String nomeAtletaConstrutor, int idadeAtletaConstrutor) {
//		this.nomeAtleta = nomeAtletaConstrutor;
//		this.idade = idadeAtletaConstrutor;
//	}
//	
//	public Atleta() {
//		
//	}

	public Double getPatrocinio() {
		return patrocinio;
	}

	public void setPatrocinio(Double patrocinio) {
		this.patrocinio = patrocinio;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

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
