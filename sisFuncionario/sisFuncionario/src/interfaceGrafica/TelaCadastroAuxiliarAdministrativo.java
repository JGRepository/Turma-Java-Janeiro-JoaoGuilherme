package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroAssistenteAdministrativo;

public class TelaCadastroAuxiliarAdministrativo {

	public void formularioAuxiliarAdmnistrativo(JFrame frameTelaPrincipal) {
		String nome = "Digite o nome";
		String cpf = "Digite o CPF";
		String email = "Digite o Email";

		JFrame frameCadastroAssistenteAdministrativo = new JFrame();
		frameCadastroAssistenteAdministrativo.setSize(250, 300);

		JPanel panelAssistenteAdministrativo = new JPanel();

		JLabel labelNome = new JLabel(nome);
		panelAssistenteAdministrativo.add(labelNome);

		JTextField textoNome = new JTextField(10);
		panelAssistenteAdministrativo.add(textoNome);

		JLabel labelCpf = new JLabel(cpf);
		panelAssistenteAdministrativo.add(labelCpf);

		JTextField textoCpf = new JTextField(10);
		panelAssistenteAdministrativo.add(textoCpf);

		JLabel labelEmail = new JLabel(email);
		panelAssistenteAdministrativo.add(labelEmail);

		JTextField textoEmail = new JTextField(10);
		panelAssistenteAdministrativo.add(textoEmail);

		JButton botaoCadastrarSupervisor = new JButton("CADASTRAR");
		panelAssistenteAdministrativo.add(botaoCadastrarSupervisor);
		
		JButton botaoVoltarMenu = new JButton("MENU PRINCIPAL");
		panelAssistenteAdministrativo.add(botaoVoltarMenu);

		frameCadastroAssistenteAdministrativo.setVisible(true);
		frameCadastroAssistenteAdministrativo.setLocationRelativeTo(null);
		frameCadastroAssistenteAdministrativo.add(panelAssistenteAdministrativo);

		ControladorTelaCadastroAssistenteAdministrativo controladorTelaCadastroAssistenteAdministrativo = new ControladorTelaCadastroAssistenteAdministrativo(
				textoNome, textoCpf, textoEmail, frameTelaPrincipal, frameCadastroAssistenteAdministrativo);
		botaoCadastrarSupervisor.addActionListener(controladorTelaCadastroAssistenteAdministrativo);
		botaoVoltarMenu.addActionListener(controladorTelaCadastroAssistenteAdministrativo);

	}
}
