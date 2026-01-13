package codigoFonte;

public class JogadorBasquete extends Atleta {

	private String bracoMaisForte;
	private Double valorPorPontos;
	private int qtdPontos;
	
	public int getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(int qtdPontos) {
		verificarValorNegativo((double)qtdPontos);
		this.qtdPontos = qtdPontos;
	}

	public String getBracoMaisForte() {
		return bracoMaisForte;
	}
	
	public void setBracoMaisForte(String bracoMaisForteChegando) {
		this.bracoMaisForte = bracoMaisForteChegando;
				
		
	}
	public Double getValorPorPontos() {
		return valorPorPontos;
	}
	
	public void setValorPorPontos(Double valorPorPontosChegando) {
		verificarValorNegativo(valorPorPontosChegando);
		this.valorPorPontos = valorPorPontosChegando;
		
		
	}

	@Override
	protected Double calculcarPagamento() {
		
		return  ((double)qtdPontos) * 30;
	}

	@Override
	protected Double valorPatronicio() {
		Double valorPorcentSalario = (getSalario()* 0.2);
		Double valorPorcentPorPontos = ((valorPorPontos * 0.2) * 3);
		return valorPorcentSalario + valorPorcentPorPontos ;
	}
}
