package interfaceGrafica;

import java.util.List;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.SupervisorAuxiliar;

public class ListarSupervisor {

	public void listarResultados(List<SupervisorAuxiliar> listaSupervisorAuxiliares) {
		
		int quantidadeLinhas = listaSupervisorAuxiliares.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(SupervisorAuxiliar gerente: listaSupervisorAuxiliares) {
			
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEmail();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "EMAIL"};
		
		JFrame frameListarGerentes = new JFrame();
		frameListarGerentes.setSize(475, 450);
		
		JTable tabelaGerentes = new JTable(tabelaString, nomeColunas);
		tabelaGerentes.setSize(1000,1000);
		tabelaGerentes.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarGerente = new JScrollPane(tabelaGerentes);
		
		JPanel panelListarGerente = new JPanel();
		panelListarGerente.add(scrollPaneListarGerente);
		
		frameListarGerentes.add(panelListarGerente);
		
	
		frameListarGerentes.setVisible(true);
		
		
	}
}
