package codigoFonte;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Sistema de cadastro de Atleta");
		System.out.println("Digite F para Jogador de Futebol ou V para Jogador de Volei");

		Scanner entradaDados = new Scanner(System.in);
		JogadorFutebol jogadorFutebol = new JogadorFutebol();
		JogadorVolei jogadorVolei = new JogadorVolei();

		String opcao = entradaDados.next();

		if (opcao.equals("F")) {
			System.out.println("Qual o nome do Jogador de Futebol");
			jogadorFutebol.nomeAtleta = entradaDados.next();

			System.out.println("Qual a idade do Jogador de Futebol");
			jogadorFutebol.idade = entradaDados.nextInt();
	
			System.out.println("Qual é a perna mais forte?");
			jogadorFutebol.pernaMaisForte = entradaDados.next();
	
			System.out.println("Qual é o valor por Gol marcado?");
			jogadorFutebol.valorPorGol = entradaDados.nextDouble();
	
			System.out.println("Nome Cadastrado: " + jogadorFutebol.nomeAtleta);
			System.out.println("Idade Cadastrada: " + jogadorFutebol.idade);
			System.out.println("Qual é a perna mais forte?: " + jogadorFutebol.pernaMaisForte);
			System.out.println("Qual é o valor por Gol marcado? " + jogadorFutebol.valorPorGol);

			System.out.println("### FIM ###");
		}
		
		if(opcao.equals("V")){

			System.out.println("Digite o Nome do Jogador De Volei: ");
			jogadorVolei.nomeAtleta = entradaDados.next();

			System.out.println("Digite a Idade do Jogador De Volei: ");
			jogadorVolei.idade = entradaDados.nextInt();

			System.out.println("Digite o Braco mais forte do Jogador De Volei: ");
			jogadorVolei.bracoMaisForte = entradaDados.next();

			System.out.println("Digite o valor por ponto do Jogador De Volei: ");
			jogadorVolei.valorPorPontos = entradaDados.nextDouble();


			System.out.println("O nome do jogador de volei: " + jogadorVolei.nomeAtleta );
			System.out.println("A idade do jogador de Volei: " + jogadorVolei.idade );
			System.out.println("O braco mais forte: " + jogadorVolei.bracoMaisForte );
			System.out.println("O valor por pontos: " + jogadorVolei.valorPorPontos );

			System.out.println("### FIM ###");
		
		}
	}
}
