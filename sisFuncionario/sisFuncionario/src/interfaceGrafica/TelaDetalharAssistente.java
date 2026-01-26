package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.AssistenteAdministrativo;

public class TelaDetalharAssistente {
	public void detalharAssistente(AssistenteAdministrativo assistenteAdministravo) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaAtendente = new JFrame("Detalhes do Assistente");
		frameTelaAtendente.setSize(300, 180);

		JPanel panelTelaAtendente = new JPanel();
		panelTelaAtendente.setLayout(grid);

		panelTelaAtendente.add(new JLabel("CPF:"));
		panelTelaAtendente.add(new JLabel(assistenteAdministravo.getCpf()));

		panelTelaAtendente.add(new JLabel("NOME:"));
		panelTelaAtendente.add(new JLabel(assistenteAdministravo.getNome()));

		panelTelaAtendente.add(new JLabel("SETOR:"));
		panelTelaAtendente.add(new JLabel(assistenteAdministravo.getEmail()));

		frameTelaAtendente.add(panelTelaAtendente);
		frameTelaAtendente.setLocationRelativeTo(null);
		frameTelaAtendente.setVisible(true);

	}
}
