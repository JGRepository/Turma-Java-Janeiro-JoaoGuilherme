package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroSupervisor;

public class TelaCadastroSupervisor {

	public void formularioSupervisor(JFrame frameTelaPrincipal) {
		String nome = "Digite o nome";
		String cpf = "Digite o CPF";
		String email = "Digite o Email";

		JFrame frameCadastroSupervisor = new JFrame();
		frameCadastroSupervisor.setSize(250, 300);

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
		
		JButton botaoVoltarMenu = new JButton("MENU PRINCIPAL");
		panelSupervisor.add(botaoVoltarMenu);

		frameCadastroSupervisor.setVisible(true);
		frameCadastroSupervisor.setLocationRelativeTo(null);
		frameCadastroSupervisor.add(panelSupervisor);

		ControladorTelaCadastroSupervisor controladorTelaCadastroSupervisor = new ControladorTelaCadastroSupervisor(
				textoNome, textoCpf, textoEmail, frameTelaPrincipal, frameCadastroSupervisor);
		botaoCadastrarSupervisor.addActionListener(controladorTelaCadastroSupervisor);
		botaoVoltarMenu.addActionListener(controladorTelaCadastroSupervisor);

	}
}
