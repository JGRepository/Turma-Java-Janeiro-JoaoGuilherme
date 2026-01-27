package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarAssistente;
import entidade.AssistenteAdministrativo;

public class TelaListarAssistente {

	public void listarAtendente(List<AssistenteAdministrativo> listaAssistente) {

		int quantidadeLinhas = listaAssistente.size();

		String[][] tabelaString = new String[quantidadeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (AssistenteAdministrativo assistenteAdministrativo : listaAssistente) {

			tabelaString[posicaoLinha][posicaoColuna] = assistenteAdministrativo.getCpf();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = assistenteAdministrativo.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = assistenteAdministrativo.getEmail();

			posicaoColuna = 0;
			posicaoLinha++;
		}

		String[] nomeColunas = { "CPF", "NOME", "EMAIL" };

		JFrame frameListarAssistente = new JFrame();
		frameListarAssistente.setSize(650, 500);

		JTable tabelaAssistente = new JTable(tabelaString, nomeColunas);
		tabelaAssistente.setSize(1000, 1000);
		tabelaAssistente.setBounds(30, 40, 300, 300);
		JPanel panelListarAssistente = new JPanel();

		JScrollPane scrollPaneListarAtendente = new JScrollPane(tabelaAssistente);

		JLabel labelCpf = new JLabel("Digite o CPF:");
		panelListarAssistente.add(labelCpf);

		JTextField textCpf = new JTextField(10);
		panelListarAssistente.add(textCpf);

		JButton botaoDetalhar = new JButton("DETALHAR");
		panelListarAssistente.add(botaoDetalhar);
		
		JButton botaoAlterar = new JButton("ALTERAR");
		panelListarAssistente.add(botaoAlterar);
		
		JButton botaoDeletar = new JButton("DELETAR");
		panelListarAssistente.add(botaoDeletar);
		
		JButton botaoMenu = new JButton("MENU INICIAL");
		panelListarAssistente.add(botaoMenu);

		panelListarAssistente.add(scrollPaneListarAtendente);

		frameListarAssistente.add(panelListarAssistente);
		frameListarAssistente.setLocationRelativeTo(null);
		frameListarAssistente.setVisible(true);
		
		ControladorTelaListarAssistente controladorTelaListarAsistente = new ControladorTelaListarAssistente(textCpf, listaAssistente, frameListarAssistente);
		botaoDetalhar.addActionListener(controladorTelaListarAsistente);
		botaoAlterar.addActionListener(controladorTelaListarAsistente);
		botaoDeletar.addActionListener(controladorTelaListarAsistente);
		botaoMenu.addActionListener(controladorTelaListarAsistente);

	}
}
