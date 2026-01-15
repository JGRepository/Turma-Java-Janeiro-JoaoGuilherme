package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		List<JogadorFutsal> jogadoresFutsal = new ArrayList<>();
		List<JogadorBasquete> jogadoresBasquete = new ArrayList<>();

		JOptionPane.showMessageDialog(null, "Sistema de cadastro de Atleta");

		String cadastrarNovamente;

		do {
//Inicio Cadastro
			String opcaoCadastro;
			do {
				opcaoCadastro = JOptionPane
						.showInputDialog("Digite [F] para Jogador de Futsal ou [B] para Jogador de Basquete");

				if (opcaoCadastro == null) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione alguma opção.");
					return;
				}

				opcaoCadastro = opcaoCadastro.trim();

				if (!opcaoCadastro.equalsIgnoreCase("F") && !opcaoCadastro.equalsIgnoreCase("B")
						|| !somenteLetras(opcaoCadastro)) {
					JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas 'F' ou 'B'.");
				}

			} while (!opcaoCadastro.equalsIgnoreCase("F") && !opcaoCadastro.equalsIgnoreCase("B"));

			// JOGADOR FUTSAL
			// JOGADOR FUTSAL
			// JOGADOR FUTSAL
			if (opcaoCadastro.equalsIgnoreCase("F")) {

				Long identificadorLong = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
				JogadorFutsal jogadorFutsal = new JogadorFutsal(identificadorLong);

				String nome;
				do {
					nome = JOptionPane.showInputDialog("Qual o nome do Jogador de Futsal");

				} while (!somenteLetras(nome));

				jogadorFutsal.setNomeAtleta(nome);

				int idade;
				do {
					idade = validaInteiro(JOptionPane.showInputDialog("Qual a idade do Jogador de Futsal"));
				} while (idade == 0);
				jogadorFutsal.setIdade(idade);

				String perna;
				do {
					perna = JOptionPane.showInputDialog("Qual é a perna mais forte?");

				} while (!somenteLetras(perna));

				jogadorFutsal.setPernaMaisForte(perna);

				double valorPorGol;
				do {
					valorPorGol = validaDouble(JOptionPane.showInputDialog("Qual é o valor por Gol marcado?"));
				} while (valorPorGol == 0.0);
				jogadorFutsal.setValorPorGols(valorPorGol);

				int qtdGols;
				do {
					qtdGols = validaInteiro(JOptionPane.showInputDialog("Qual a quantidade de Gol(s) marcado(s)?"));
				} while (qtdGols == 0);
				jogadorFutsal.setQtdGols(qtdGols);

				jogadorFutsal.setSalario(jogadorFutsal.calculcarPagamento());
				jogadorFutsal.setPatrocinio(jogadorFutsal.valorPatronicio());

				jogadoresFutsal.add(jogadorFutsal);
			}
			// JOGADOR BASQUETE
			// JOGADOR BASQUETE
			// JOGADOR BASQUETE
			if (opcaoCadastro.equalsIgnoreCase("B")) {
				Long identificadorLong = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);

				JogadorBasquete jogadorBasquete = new JogadorBasquete(identificadorLong);

				String nome;
				do {
					nome = JOptionPane.showInputDialog("Qual o nome do Jogador de Basquete");

				} while (!somenteLetras(nome));

				jogadorBasquete.setNomeAtleta(nome);

				int idade;
				do {
					idade = validaInteiro(JOptionPane.showInputDialog("Qual a idade do Jogador de Basquete"));
				} while (idade == 0);
				jogadorBasquete.setIdade(idade);

				String braco;
				do {

					braco = JOptionPane.showInputDialog("Digite o Braço mais forte do Jogador de Basquete:");

				} while (!somenteLetras(braco));

				jogadorBasquete.setBracoMaisForte(braco);

				double valorPorPonto;
				do {
					valorPorPonto = validaDouble(
							JOptionPane.showInputDialog("Digite o valor por ponto do Jogador de Basquete:"));
				} while (valorPorPonto == 0.0);
				jogadorBasquete.setValorPorPontos(valorPorPonto);

				int qtdPontos;
				do {
					qtdPontos = validaInteiro(JOptionPane.showInputDialog("Qual a quantidade de Ponto(s) marcado(s)?"));
				} while (qtdPontos == 0);
				jogadorBasquete.setQtdPontos(qtdPontos);

				jogadorBasquete.setSalario(jogadorBasquete.calculcarPagamento());
				jogadorBasquete.setPatrocinio(jogadorBasquete.valorPatronicio());

				jogadoresBasquete.add(jogadorBasquete);
			}
			do {
				cadastrarNovamente = JOptionPane.showInputDialog("Deseja cadastrar mais um Atleta? Digite [S]/[N]");
				if (cadastrarNovamente == null) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione alguma opção.");
					return;
				}

				cadastrarNovamente = cadastrarNovamente.trim();
				if (!cadastrarNovamente.equalsIgnoreCase("S") && !cadastrarNovamente.equalsIgnoreCase("N")
						&& !somenteLetras(cadastrarNovamente)) {
					JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas 'S' ou 'N'.");
				}
			} while (!cadastrarNovamente.equalsIgnoreCase("S") && !cadastrarNovamente.equalsIgnoreCase("N")
					&& !somenteLetras(cadastrarNovamente));

		} while (cadastrarNovamente.equalsIgnoreCase("S"));
		StringBuilder mensagem = new StringBuilder();

		mensagem.append("### LISTA JOGADORES DE FUTSAL CADASTRADOS ###").append("\n");

		for (JogadorFutsal jogadoresFutsalLista : jogadoresFutsal) {
			
			mensagem.append("Identificador: ").append(jogadoresFutsalLista.getIdentificador()).append("\n");

			mensagem.append("Nome do Jogador de Futebol: ").append(jogadoresFutsalLista.getNomeAtleta()).append("\n");

			mensagem.append("Idade: ").append(jogadoresFutsalLista.getIdade()).append("\n");

			mensagem.append("Perna mais forte: ").append(jogadoresFutsalLista.getPernaoMaisForte()).append("\n");

			mensagem.append("Valor por gol: ").append(jogadoresFutsalLista.getValorPorGols()).append("\n");

			mensagem.append("Salário: ").append(jogadoresFutsalLista.getSalario()).append("\n");

			mensagem.append("Patrocínio: ").append(jogadoresFutsalLista.getPatrocinio()).append("\n");

			mensagem.append("---------------------------------").append("\n");
		}

		System.out.println("################ Lista de Jogadores de FUTSAL Cadastrados ################");
		for (JogadorFutsal jogador : jogadoresFutsal) {
			System.out.println("Nome: " + jogador.getNomeAtleta());
			System.out.println("Idade: " + jogador.getIdade());
			System.out.println("Perna mais forte: " + jogador.getPernaoMaisForte());
			System.out.println("Valor por gol: " + jogador.getValorPorGols());
			System.out.println("Salário: " + jogador.getSalario());
			System.out.println("Patrocínio: " + jogador.getPatrocinio());
			System.out.println("----------------------------------------------------------------");
		}

		mensagem.append("### LISTA JOGADORES DE FUTSAL CADASTRADOS ###").append("\n");

		for (JogadorBasquete jogadoresBasqueteLista : jogadoresBasquete) {

			mensagem.append("Identificador: ").append(jogadoresBasqueteLista.getIdentificador()).append("\n");
			
			mensagem.append("Nome do Jogador de Futebol: ").append(jogadoresBasqueteLista.getNomeAtleta()).append("\n");

			mensagem.append("Idade: ").append(jogadoresBasqueteLista.getIdade()).append("\n");

			mensagem.append("Braço mais forte: ").append(jogadoresBasqueteLista.getBracoMaisForte()).append("\n");

			mensagem.append("Valor por pontos: ").append(jogadoresBasqueteLista.getValorPorPontos()).append("\n");

			mensagem.append("Salário: ").append(jogadoresBasqueteLista.getSalario()).append("\n");

			mensagem.append("Patrocínio: ").append(jogadoresBasqueteLista.getPatrocinio()).append("\n");

			mensagem.append("---------------------------------").append("\n");
		}
		JOptionPane.showMessageDialog(null, mensagem.toString());

		System.out.println("################ Lista de Jogadores de BASQUETE Cadastrados ################");
		for (JogadorBasquete jogador : jogadoresBasquete) {
			System.out.println("Nome: " + jogador.getNomeAtleta());
			System.out.println("Idade: " + jogador.getIdade());
			System.out.println("Braço mais forte: " + jogador.getBracoMaisForte());
			System.out.println("Valor por ponto: " + jogador.getValorPorPontos());
			System.out.println("Quantidade de pontos: " + jogador.getQtdPontos());
			System.out.println("Salário: " + jogador.getSalario());
			System.out.println("Patrocínio: " + jogador.getPatrocinio());
			System.out.println("----------------------------------------------------------------");
		}

		System.out.println("### FIM ###");
	}

	public static int validaInteiro(String numeroString) {
		int numeroInteiro = 0;

		if (numeroString == null || numeroString.isBlank() || (Integer.parseInt(numeroString) == 0)) {
			JOptionPane.showMessageDialog(null, "***Valor inválido!***");

		} else {

			try {
				numeroInteiro = Integer.parseInt(numeroString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "***Digite apenas números inteiros!***");
				System.out.println("LOG: " + e.getMessage() + " (não pode ser convertido)");
			}
		}
		return numeroInteiro;
	}

	public static Double validaDouble(String numeroString) {
		Double numeroDecimalDouble = 0.0;
		if (numeroString == null || numeroString.isBlank() || (Integer.parseInt(numeroString) == 0)) {
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

	public static boolean somenteLetras(String texto) {
		if (texto == null || texto.isBlank()) {
			JOptionPane.showMessageDialog(null, "***Digite algum texto!***");
			return false;
		}
		for (int i = 0; i < texto.length(); i++) {
			if (!Character.isLetter(texto.charAt(i))) {
				JOptionPane.showMessageDialog(null, "***Caractere inválido no texto digitado!***");
				return false;
			}
		}
		return true;
	}

}
