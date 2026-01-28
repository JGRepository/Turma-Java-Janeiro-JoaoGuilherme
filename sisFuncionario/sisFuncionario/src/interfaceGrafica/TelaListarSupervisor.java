package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarSupervisor;
import entidade.SupervisorAuxiliar;

public class TelaListarSupervisor {

	public void listarSupervisor(List<SupervisorAuxiliar> listaSupervisorAuxiliares) {

		int quantidadeLinhas = listaSupervisorAuxiliares.size();

		String[][] tabelaString = new String[quantidadeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (SupervisorAuxiliar supervisorAuxiliar : listaSupervisorAuxiliares) {

			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getCpf();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getEmail();

			posicaoColuna = 0;
			posicaoLinha++;
		}

		String[] nomeColunas = { "CPF", "NOME", "EMAIL" };

		JFrame frameListarSupervisores = new JFrame();
		frameListarSupervisores.setSize(700, 500);

		JTable tabelaSupervisor = new JTable(tabelaString, nomeColunas);
		tabelaSupervisor.setSize(1000, 1000);
		tabelaSupervisor.setBounds(30, 40, 300, 300);

		JPanel panelListarSupervisor = new JPanel();

		JScrollPane scrollPaneListarSupervisor = new JScrollPane(tabelaSupervisor);

		JLabel labelCpf = new JLabel("Digite o CPF");
		panelListarSupervisor.add(labelCpf);

		JTextField textoCpf = new JTextField(15);
		panelListarSupervisor.add(textoCpf);

		JButton botaoDetalhar = new JButton("DETALHAR");
		panelListarSupervisor.add(botaoDetalhar);
		
		JButton botaoAlterar = new JButton("ALTERAR");
		panelListarSupervisor.add(botaoAlterar);
		
		JButton botaoDeletar = new JButton("DELETAR");
		panelListarSupervisor.add(botaoDeletar);
		
		JButton botaoMenu = new JButton("MENU INICIAL");
		panelListarSupervisor.add(botaoMenu);

		panelListarSupervisor.add(scrollPaneListarSupervisor);

		frameListarSupervisores.add(panelListarSupervisor);
		frameListarSupervisores.setLocationRelativeTo(null);

		frameListarSupervisores.setVisible(true);
		
		ControladorTelaListarSupervisor controladorTelaListarSupervisor = new ControladorTelaListarSupervisor(textoCpf, listaSupervisorAuxiliares, frameListarSupervisores);
		botaoDetalhar.addActionListener(controladorTelaListarSupervisor);
		botaoAlterar.addActionListener(controladorTelaListarSupervisor);
		botaoDeletar.addActionListener(controladorTelaListarSupervisor);
		botaoMenu.addActionListener(controladorTelaListarSupervisor);


	}
}
