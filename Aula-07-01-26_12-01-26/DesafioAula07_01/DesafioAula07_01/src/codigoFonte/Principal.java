package codigoFonte;

import java.util.ArrayList;
import java.util.List;

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
						&& !somenteLetras(opcaoCadastro)) {
					JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas 'F' ou 'B'.");
				}

			} while (!opcaoCadastro.equalsIgnoreCase("F") && !opcaoCadastro.equalsIgnoreCase("B"));
			
			//JOGADOR FUTSAL
			//JOGADOR FUTSAL
			//JOGADOR FUTSAL
			if (opcaoCadastro.equalsIgnoreCase("F")) {

				JogadorFutsal jogadorFutsal = new JogadorFutsal();

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
			//JOGADOR BASQUETE
			//JOGADOR BASQUETE
			//JOGADOR BASQUETE
			if (opcaoCadastro.equalsIgnoreCase("B")) {

				JogadorBasquete jogadorBasquete = new JogadorBasquete();
				
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
				do{
					
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
				if (!cadastrarNovamente.equalsIgnoreCase("S") && !cadastrarNovamente.equalsIgnoreCase("N")) {
					JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas 'S' ou 'N'.");
				}
			} while (!cadastrarNovamente.equalsIgnoreCase("S") && !cadastrarNovamente.equalsIgnoreCase("N") && !somenteLetras(cadastrarNovamente));

		} while (cadastrarNovamente.equalsIgnoreCase("S"));

		if (!jogadoresFutsal.isEmpty()) {
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
		}

		if (!jogadoresBasquete.isEmpty()) {
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
		}

		System.out.println("### FIM ###");
	}

	public static int validaInteiro(String numeroString) {
		if (numeroString == null || numeroString.isBlank() || (Integer.parseInt(numeroString) == 0)) {
			JOptionPane.showMessageDialog(null, "***Valor inválido!***");
			return 0;
		}

		try {
			return Integer.parseInt(numeroString.trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "***Digite apenas números inteiros!***");
			System.out.println("LOG: " + e.getMessage() + " (não pode ser convertido)");
			return 0;
		}
	}

	public static double validaDouble(String numeroString) {
		if (numeroString == null || numeroString.isBlank() || (Integer.parseInt(numeroString) == 0)) {
			JOptionPane.showMessageDialog(null, "***Valor inválido!***");
			return 0.0;
		}

		try {
			String normalizado = numeroString.trim().replace(",", ".");
			return Double.parseDouble(normalizado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "***Digite apenas números (ex: 10.5)!***");
			System.out.println("LOG: " + e.getMessage() + " (não pode ser convertido)");
			return 0.0;
		}
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
