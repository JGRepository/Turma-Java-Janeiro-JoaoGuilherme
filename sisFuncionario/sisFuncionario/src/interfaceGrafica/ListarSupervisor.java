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
		
		
		for(SupervisorAuxiliar supervisorAuxiliar: listaSupervisorAuxiliares) {
			
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getEmail();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "EMAIL"};
		
		JFrame frameListarSupervisores = new JFrame();
		frameListarSupervisores.setSize(475, 450);
		
		JTable tabelaSupervisor = new JTable(tabelaString, nomeColunas);
		tabelaSupervisor.setSize(1000,1000);
		tabelaSupervisor.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarSupervisor = new JScrollPane(tabelaSupervisor);
		
		JPanel panelListarSupervisor = new JPanel();
		panelListarSupervisor.add(scrollPaneListarSupervisor);
		
		frameListarSupervisores.add(panelListarSupervisor);
		
	
		frameListarSupervisores.setVisible(true);
		
		
	}
}
