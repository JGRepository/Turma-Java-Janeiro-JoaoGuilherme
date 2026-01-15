package codigoFonte;

public class JogadorFutsal extends Atleta {
	
	private String pernaMaisForte;
	private Double valorPorGols;
	private int qtdGols;

//	public JogadorFutsal(String nomeAtletaConstrutor, int idadeAtletaConstrutor, String pernaMaisForteConstrutor,
//			Double valorPorGolsConstrutor, int qtdGolsConstrutor) {
//		super(nomeAtletaConstrutor, idadeAtletaConstrutor);
//		this.pernaMaisForte = pernaMaisForteConstrutor;
//		this.valorPorGols = valorPorGolsConstrutor;
//		this.qtdGols = qtdGolsConstrutor;
//	}
//	
//	public JogadorFutsal() {
//		super();
//	}
//	
	public JogadorFutsal(long identificadorContrsutor) {
		super(identificadorContrsutor);
	}

	public int getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(int qtdGols) {
		verificarValorNegativo((double) qtdGols);
		this.qtdGols = qtdGols;
	}

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
		verificarValorNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;

	}

	@Override
	protected Double calculcarPagamento() {
		// TODO Auto-generated method stub
		return ((double) qtdGols) * 50;
	}

	@Override
	protected Double valorPatronicio() {
		Double valorPorcentSalario = (getSalario() * 0.3);
		Double valorPorcentPorPontos = ((valorPorGols * 0.3) * 4);
		return valorPorcentSalario + valorPorcentPorPontos;
	}
}
