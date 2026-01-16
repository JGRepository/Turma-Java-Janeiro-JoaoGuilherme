package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroSupervisor;

public class TelaCadastroSupervisor {

	public void formularioSupervisor() {
		String nome = "Digite o nome";
		String cpf = "Digite o CPF";
		String email = "Digite o Email";

		JFrame frameCadastroSupervisorFrame = new JFrame();
		frameCadastroSupervisorFrame.setSize(300, 300);

		JPanel panelSupervisor = new JPanel();

		JLabel labelNome = new JLabel(nome);
		panelSupervisor.add(labelNome);

		JTextField textoNome = new JTextField(10);
		panelSupervisor.add(textoNome);

		JLabel labelCpf = new JLabel(cpf);
		panelSupervisor.add(labelCpf);

		JTextField textoCpf = new JTextField(10);
		panelSupervisor.add(textoCpf);

		JLabel labelEmail = new JLabel(email);
		panelSupervisor.add(labelEmail);

		JTextField textoEmail = new JTextField(10);
		panelSupervisor.add(textoEmail);

		JButton botaoCadastrarSupervisor = new JButton("CADASTRAR");
		panelSupervisor.add(botaoCadastrarSupervisor);

		frameCadastroSupervisorFrame.setVisible(true);
		frameCadastroSupervisorFrame.setLocationRelativeTo(null);
		frameCadastroSupervisorFrame.add(panelSupervisor);

		ControladorTelaCadastroSupervisor controladorTelaCadastroSupervisor = new ControladorTelaCadastroSupervisor(
				textoNome, textoCpf, textoEmail);
		botaoCadastrarSupervisor.addActionListener(controladorTelaCadastroSupervisor);

	}
}
