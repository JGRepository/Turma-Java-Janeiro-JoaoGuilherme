package codigoFonte;

public abstract class Atleta {

	private String nomeAtleta;
	private int idade;
	
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	
	public void setNomeAtleta(String nomeAtletaChegando) {
		this.nomeAtleta = nomeAtletaChegando; 
	}
	
	public void setIdade(int idadeChegando) {
		
	Utilitario util = new Utilitario();
	util.verificarIdade(idadeChegando);
		this.idade = idadeChegando; 
	}
	
	
}
