package codigoFonte;

public class JogadorFutsal extends Atleta {

	String pernaMaisForte;
	Double valorPorGols;
	
	public String getPernaoMaisForte() {
		return pernaMaisForte;
	}
	
	public void setPernaMaisForte(String pernaMaisForteChegando) {
		this.pernaMaisForte = pernaMaisForteChegando;
				
		
	}
	public Double getValorPorGols() {
			return valorPorGols;
	}
	
	public void setValorPorGols(Double valorPorGolsChegando) {
		Utilitario util = new Utilitario();
		util.verificarValorNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;
		
		
	}
}
