package codigoFonte;

import java.util.ArrayList;
import java.util.Iterator;
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

				jogadorFutsal.setSalario(jogadorFutsal.calculcarPagamento());
				jogadorFutsal.setPatrocinio(jogadorFutsal.valorPatronicio());

				jogadoresFutsal.add(jogadorFutsal);

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

				
				jogadorBasquete.setSalario(jogadorBasquete.calculcarPagamento());
				jogadorBasquete.setPatrocinio(jogadorBasquete.valorPatronicio());
				
				jogadoresBasquete.add(jogadorBasquete);
			}
			System.out.println("Deseja cadastrar mais um Atleta? Digite [S]/[N]");
			novoCadastroString = entradaDados.next();

		} while (novoCadastroString.equalsIgnoreCase("S"));

		for (JogadorFutsal jogadorFutsalLista : jogadoresFutsal) {
			System.out.println("################Lista de Jogadores de futebol Cadastrados################");
			System.out.println("O nome do jogador de Basquete: " + jogadorFutsalLista.getNomeAtleta());
			System.out.println("Nome Cadastrado: " + jogadorFutsalLista.getNomeAtleta());
			System.out.println("Idade Cadastrada: " + jogadorFutsalLista.getIdade());
			System.out.println("Qual é a perna mais forte?: " + jogadorFutsalLista.getPernaoMaisForte());
			System.out.println("Qual é o valor por Gol marcado? " + jogadorFutsalLista.getValorPorGols());
			System.out.println("Pagamento será: " + jogadorFutsalLista.getSalario());
			System.out.println("Pagamento será: " + jogadorFutsalLista.getPatrocinio());
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

			System.out.println("### FIM ###");
		}
	}
}
