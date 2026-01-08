package codigoFonte;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Sistema de cadastro de Atleta");
		System.out.println("Digite [F] para Jogador de Futsal ou [B] para Jogador de Basquete");

		Scanner entradaDados = new Scanner(System.in);
		JogadorBasquete jogadorBasquete = new JogadorBasquete();
		JogadorFutsal jogadorFutsal = new JogadorFutsal();

		String opcao = entradaDados.next();

		if (opcao.equalsIgnoreCase("F")) {
			System.out.println("Qual o nome do Jogador de Futsal");
			jogadorFutsal.setNomeAtleta(entradaDados.next());

			System.out.println("Qual a idade do Jogador de Futsal");
			jogadorFutsal.setIdade(entradaDados.nextInt());

			System.out.println("Qual é a perna mais forte?");
			jogadorFutsal.setPernaMaisForte(entradaDados.next());

			System.out.println("Qual é o valor por Gol marcado?");
			jogadorFutsal.setValorPorGols(entradaDados.nextDouble());

//			System.out.println("Nome Cadastrado: " + jogadorFutsal.nomeAtleta);
//			System.out.println("Idade Cadastrada: " + jogadorFutsal.idade);
//			System.out.println("Qual é a perna mais forte?: " + jogadorFutsal.pernaMaisForte);
//			System.out.println("Qual é o valor por Gol marcado? " + jogadorFutsal.valorPorGols);

			System.out.println("### FIM ###");
		}

		if (opcao.equalsIgnoreCase("B")) {

			System.out.println("Digite o Nome do Jogador De Basquete: ");
			jogadorBasquete.setNomeAtleta(entradaDados.next());

			System.out.println("Digite a Idade do Jogador De Basquete: ");
			jogadorBasquete.setIdade(entradaDados.nextInt());
			System.out.println("Digite o Braco mais forte do Jogador De Basquete: ");
			jogadorBasquete.setBracoMaisForte(entradaDados.next());

			System.out.println("Digite o valor por ponto do Jogador De Basquete: ");
			jogadorBasquete.setValorPorPontos(entradaDados.nextDouble());

//			System.out.println("O nome do jogador de Basquete: " + jogadorBasquete.nomeAtleta );
//			System.out.println("A idade do jogador de Basquete: " + jogadorBasquete.idade );
//			System.out.println("O braco mais forte: " + jogadorBasquete.bracoMaisForte);
//			System.out.println("O valor por pontos: " + jogadorBasquete.valorPorPontos);

			System.out.println("### FIM ###");

		}
	}
}
