package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaAlterarAssistente;
import entidade.AssistenteAdministrativo;

public class TelaAlterarAssistente {

	public void alterarAssistente(AssistenteAdministrativo assistenteAdministrativo) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaAlterarAssistente = new JFrame("Alterar Assistente");
		frameTelaAlterarAssistente.setSize(300, 180);

		JPanel panelTelaAlterarAssistente = new JPanel();
		panelTelaAlterarAssistente.setLayout(grid);

		panelTelaAlterarAssistente.add(new JLabel("CPF:"));
		JTextField textoCpf = new JTextField(assistenteAdministrativo.getCpf());
		textoCpf.setEditable(false);
		panelTelaAlterarAssistente.add(textoCpf);

		panelTelaAlterarAssistente.add(new JLabel("NOME:"));
		JTextField textoNome = new JTextField(10);
		textoNome.setText(assistenteAdministrativo.getNome());
		panelTelaAlterarAssistente.add(textoNome);

		panelTelaAlterarAssistente.add(new JLabel("EMAIL:"));
		JTextField textoEmail = new JTextField(10);
		textoEmail.setText(assistenteAdministrativo.getEmail());
		panelTelaAlterarAssistente.add(textoEmail);

		JButton botaoAlterar = new JButton("ALTERAR");
		panelTelaAlterarAssistente.add(botaoAlterar);

		JButton botaoVoltar = new JButton("VOLTAR");
		panelTelaAlterarAssistente.add(botaoVoltar);

		frameTelaAlterarAssistente.add(panelTelaAlterarAssistente);
		frameTelaAlterarAssistente.setLocationRelativeTo(null);
		frameTelaAlterarAssistente.setVisible(true);

		ControladorTelaAlterarAssistente controladorTelaAlterarAssistente = new ControladorTelaAlterarAssistente(
				textoNome, textoCpf, textoEmail);
		botaoAlterar.addActionListener(controladorTelaAlterarAssistente);
	}
}
