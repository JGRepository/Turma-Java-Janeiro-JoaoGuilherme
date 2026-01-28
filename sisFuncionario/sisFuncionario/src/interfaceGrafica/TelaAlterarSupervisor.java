package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaAlterarSupervisor;
import entidade.SupervisorAuxiliar;

public class TelaAlterarSupervisor {

	public void alterarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaAlterarSupervisor = new JFrame("Alterar Supervisor");
		frameTelaAlterarSupervisor.setSize(300, 180);

		JPanel panelTelaAlterarSupervisor = new JPanel();
		panelTelaAlterarSupervisor.setLayout(grid);

		panelTelaAlterarSupervisor.add(new JLabel("CPF:"));
		JTextField textoCpf = new JTextField(supervisorAuxiliar.getCpf());
		textoCpf.setEditable(false);
		panelTelaAlterarSupervisor.add(textoCpf);

		panelTelaAlterarSupervisor.add(new JLabel("NOME:"));
		JTextField textoNome = new JTextField(10);
		textoNome.setText(supervisorAuxiliar.getNome());
		panelTelaAlterarSupervisor.add(textoNome);

		panelTelaAlterarSupervisor.add(new JLabel("EMAIL:"));
		JTextField textoEmail = new JTextField(10);
		textoEmail.setText(supervisorAuxiliar.getEmail());
		panelTelaAlterarSupervisor.add(textoEmail);

		JButton botaoAlterar = new JButton("ALTERAR");
		panelTelaAlterarSupervisor.add(botaoAlterar);

		JButton botaoVoltar = new JButton("VOLTAR");
		panelTelaAlterarSupervisor.add(botaoVoltar);

		frameTelaAlterarSupervisor.add(panelTelaAlterarSupervisor);
		frameTelaAlterarSupervisor.setLocationRelativeTo(null);
		frameTelaAlterarSupervisor.setVisible(true);

		ControladorTelaAlterarSupervisor controladorTelaAlterarSupervisor = new ControladorTelaAlterarSupervisor(
				textoNome, textoCpf, textoEmail, frameTelaAlterarSupervisor);
		botaoAlterar.addActionListener(controladorTelaAlterarSupervisor);
		botaoVoltar.addActionListener(controladorTelaAlterarSupervisor);
	}
}
