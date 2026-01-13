package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		Scanner entradaDados = new Scanner(System.in);

		List<JogadorFutsal> jogadoresFutsal = new ArrayList<JogadorFutsal>();
		List<JogadorBasquete> jogadoresBasquete = new ArrayList<JogadorBasquete>();
		String cadastrarNovamente;

		JOptionPane.showMessageDialog(null, "Sistema de cadastro de Atleta");

		do {
			String opcaoCadastro = JOptionPane
					.showInputDialog("Digite [F] para Jogador de Futsal ou [B] para Jogador de Basquete");
			if (opcaoCadastro.equalsIgnoreCase("F")) {
				JogadorFutsal jogadorFutsal = new JogadorFutsal();

				jogadorFutsal.setNomeAtleta(JOptionPane.showInputDialog("Qual o nome do Jogador de Futsal"));

				int idadeTemporaria;
				do {
					idadeTemporaria = validaInteiro(JOptionPane.showInputDialog("Qual a idade do Jogador de Futsal"));
					if (idadeTemporaria != 0) {
						jogadorFutsal.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				jogadorFutsal.setPernaMaisForte(JOptionPane.showInputDialog("Qual é a perna mais forte?"));

				double valorPorGolTempDouble;
				do {
					valorPorGolTempDouble = validaDouble(
							JOptionPane.showInputDialog("Qual é o valor por Gol marcado?"));
					if (valorPorGolTempDouble != 0.0) {
						jogadorFutsal.setValorPorGols(valorPorGolTempDouble);
					}
				} while (valorPorGolTempDouble == 0.0);

				int qntGolTemp;
				do {
					qntGolTemp = validaInteiro(JOptionPane.showInputDialog("Qual a quantidade de Gol(s) marcado(s)?"));
					if (qntGolTemp != 0) {
						jogadorFutsal.setQtdGols(qntGolTemp);
					}
				} while (qntGolTemp == 0);

				jogadorFutsal.setSalario(jogadorFutsal.calculcarPagamento());
				jogadorFutsal.setPatrocinio(jogadorFutsal.valorPatronicio());

				jogadoresFutsal.add(jogadorFutsal);

			}

			if (opcaoCadastro.equalsIgnoreCase("B")) {
				JogadorBasquete jogadorBasquete = new JogadorBasquete();

				jogadorBasquete.setNomeAtleta(JOptionPane.showInputDialog("Qual o nome do Jogador de Basquete"));

				int idadeTemporaria;
				do {
					idadeTemporaria = validaInteiro(JOptionPane.showInputDialog("Qual a idade do Jogador de Basquete"));
					if (idadeTemporaria != 0) {
						jogadorBasquete.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);
			

				jogadorBasquete.setBracoMaisForte(
						JOptionPane.showInputDialog("Digite o Braco mais forte do Jogador De Basquete: "));
				
				double valorPorGolTempDouble;
				do {
					valorPorGolTempDouble = validaDouble(
							JOptionPane.showInputDialog("Digite o valor por ponto do Jogador De Basquete: ?"));
					if (valorPorGolTempDouble != 0.0) {
						jogadorBasquete.setValorPorPontos(valorPorGolTempDouble);
					}
				} while (valorPorGolTempDouble == 0.0);


				int qntPontosTempBasquete;
				do {
					qntPontosTempBasquete = validaInteiro(JOptionPane.showInputDialog("Qual a quantidade de Ponto(s) marcado(s)?"));
					if (qntPontosTempBasquete != 0) {
						jogadorBasquete.setQtdPontos(qntPontosTempBasquete);
					}
				} while (qntPontosTempBasquete == 0);

				
			

				jogadorBasquete.setSalario(jogadorBasquete.calculcarPagamento());
				jogadorBasquete.setPatrocinio(jogadorBasquete.valorPatronicio());

				jogadoresBasquete.add(jogadorBasquete);
			}
			cadastrarNovamente = JOptionPane.showInputDialog("Deseja cadastrar mais um Atleta? Digite [S]/[N]");

		} while (cadastrarNovamente.equalsIgnoreCase("S"));

		for (JogadorFutsal jogadorFutsalLista : jogadoresFutsal) {
			System.out.println("################Lista de Jogadores de futebol Cadastrados################");
			System.out.println("O nome do jogador de Basquete: " + jogadorFutsalLista.getNomeAtleta());
			System.out.println("Idade Cadastrada: " + jogadorFutsalLista.getIdade());
			System.out.println("Qual é a perna mais forte?: " + jogadorFutsalLista.getPernaoMaisForte());
			System.out.println("Qual é o valor por Gol marcado? " + jogadorFutsalLista.getValorPorGols());
			System.out.println("Valor Salario: " + jogadorFutsalLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorFutsalLista.getPatrocinio());
			System.out.println("----------------------------------------------------------------");
		}

		for (JogadorBasquete jogadorBasqueteLista : jogadoresBasquete) {
			System.out.println("############Lista de Jogadores de Volei Cadastrados##############");
			System.out.println("Nome do Jogador de Volei: " + jogadorBasqueteLista.getNomeAtleta());
			System.out.println("Idade do Jogador de Volei: " + jogadorBasqueteLista.getIdade());
			System.out.println("Braço Mais forte do Jogador de Volei: " + jogadorBasqueteLista.getBracoMaisForte());
			System.out.println("Valor recebido por pontos: " + jogadorBasqueteLista.getValorPorPontos());
			System.out.println("Quantidade de pontos: " + jogadorBasqueteLista.getQtdPontos());
			System.out.println("Valor Salario: " + jogadorBasqueteLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorBasqueteLista.getPatrocinio());

			System.out.println("----------------------------------------------------------------");

		}
		System.out.println("### FIM ###");
	}

	public static int validaInteiro(String numeroString) {
		int numeroInteiro = 0;
		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showConfirmDialog(null, "***Valor Inválido!!!!***");
		} else {
			try {

				numeroInteiro = Integer.parseInt(numeroString);
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "***Digite apenas Numeros!!!!***");
				System.out.println("LOG: " + e.getMessage() + "Não pode ser convertdo");
			}
		}
		return numeroInteiro;
	}

	public static Double validaDouble(String numeroString) {
		Double numeroDecimalDouble = 0.0;
		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showConfirmDialog(null, "***Valor Inválido!!!!***");
		} else {
			try {

				numeroDecimalDouble = Double.parseDouble(numeroString);
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "***Digite apenas Numeros!!!!***");
				System.out.println("LOG: " + e.getMessage() + " Não pode ser convertdo");
			}
		}

		return numeroDecimalDouble;
	}
}
