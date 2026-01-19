package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTextField;

import interfaceGrafica.TelaCadastroAuxiliarAdministrativo;
import interfaceGrafica.TelaCadastroSupervisor;

public class ControladorPaginaPrincipal implements ActionListener {
	JTextField opcao;
	TelaCadastroSupervisor telaCadastroSupervisor = new TelaCadastroSupervisor();
	TelaCadastroAuxiliarAdministrativo telaCadastroAuxiliarAdministrativo = new TelaCadastroAuxiliarAdministrativo();
	JFrame frameTelaPrincipal;


	public ControladorPaginaPrincipal(JTextField valorCaixaTextoOpcao, JFrame frameTelaPrincipal) {
		this.opcao = valorCaixaTextoOpcao;
		this.frameTelaPrincipal = frameTelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcao.getText()) {
		case "1": {
			telaCadastroSupervisor.formularioSupervisor(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			break;
		}
		case "2": {
			telaCadastroAuxiliarAdministrativo.formularioAuxiliarAdmnistrativo(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}

	}

}
