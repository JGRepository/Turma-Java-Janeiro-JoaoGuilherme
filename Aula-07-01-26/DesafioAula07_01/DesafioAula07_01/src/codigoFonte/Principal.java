package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner entradaDados = new Scanner(System.in);

		List<JogadorFutsal> jogadoresFutsal = new ArrayList<JogadorFutsal>();
		List<JogadorBasquete> jogadoresBasquete = new ArrayList<JogadorBasquete>();
		String novoCadastroString;

		System.out.println("Sistema de cadastro de Atleta");
		do {
		

			System.out.println("Digite [F] para Jogador de Futsal ou [B] para Jogador de Basquete");
			String opcao = entradaDados.next();

			if (opcao.equalsIgnoreCase("F")) {
				JogadorFutsal jogadorFutsal = new JogadorFutsal();
				
				System.out.println("Qual o nome do Jogador de Futsal");
				jogadorFutsal.setNomeAtleta(entradaDados.next());

				System.out.println("Qual a idade do Jogador de Futsal");
				jogadorFutsal.setIdade(entradaDados.nextInt());

				System.out.println("Qual é a perna mais forte?");
				jogadorFutsal.setPernaMaisForte(entradaDados.next());

				System.out.println("Qual é o valor por Gol marcado?");
				jogadorFutsal.setValorPorGols(entradaDados.nextDouble());

				System.out.println("Qual a quantidade de Gol(s) marcado(s)?");
				jogadorFutsal.setQtdGols(entradaDados.nextInt());
				
				jogadorFutsal.setPatrocinio(jogadorFutsal.calculcarPagamento());
				
				jogadoresFutsal.add(jogadorFutsal);

//				System.out.println("Nome Cadastrado: " + jogadorFutsal.getNomeAtleta());
//				System.out.println("Idade Cadastrada: " + jogadorFutsal.getIdade());
//				System.out.println("Qual é a perna mais forte?: " + jogadorFutsal.getPernaoMaisForte());
//				System.out.println("Qual é o valor por Gol marcado? " + jogadorFutsal.getValorPorGols());
//				System.out.println("Pagamento será: " + jogadorFutsal.calculcarPagamento());
				System.out.println("Valor do Patrocínio será: " + jogadorFutsal.valorPatronicio());
			}

			if (opcao.equalsIgnoreCase("B")) {
				JogadorBasquete jogadorBasquete = new JogadorBasquete();

				System.out.println("Digite o Nome do Jogador De Basquete: ");
				jogadorBasquete.setNomeAtleta(entradaDados.next());

				System.out.println("Digite a Idade do Jogador De Basquete: ");
				jogadorBasquete.setIdade(entradaDados.nextInt());
				System.out.println("Digite o Braco mais forte do Jogador De Basquete: ");
				jogadorBasquete.setBracoMaisForte(entradaDados.next());

				System.out.println("Digite o valor por ponto do Jogador De Basquete: ");
				jogadorBasquete.setValorPorPontos(entradaDados.nextDouble());

				System.out.println("Qual a quantidade de Ponto(s) marcado(s)?");
				jogadorBasquete.setQtdPontos(entradaDados.nextInt());
				
				jogadorBasquete.setPatrocinio(jogadorBasquete.calculcarPagamento());

//				System.out.println("O nome do jogador de Basquete: " + jogadorBasquete.getNomeAtleta());
//				System.out.println("A idade do jogador de Basquete: " + jogadorBasquete.getIdade());
//				System.out.println("O braco mais forte: " + jogadorBasquete.getBracoMaisForte());
//				System.out.println("O valor por pontos: " + jogadorBasquete.getValorPorPontos());
//				System.out.println("Pagamento será: " + jogadorBasquete.calculcarPagamento());
				System.out.println("Valor do Patrocínio será: " + jogadorBasquete.valorPatronicio());
				System.out.println("###  ###");

				jogadoresBasquete.add(jogadorBasquete);
			}
			System.out.println("Deseja cadastrar mais um Atleta? Digite [S]/[N]");
			novoCadastroString = entradaDados.next();

		} while (novoCadastroString.equalsIgnoreCase("S"));

	
		System.out.println("### FIM ###");
	}
}
