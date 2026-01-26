package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entidade.AssistenteAdministrativo;
import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaDetalharAssistente;

public class ControladorTelaListarAssistente implements ActionListener {

	JFrame frameListarSupervisores;

	JTextField textoCpf;
	List<AssistenteAdministrativo> listaAssAdministrativos;
	TelaDetalharAssistente telaDetalharAssistente = new TelaDetalharAssistente();

	public ControladorTelaListarAssistente(JTextField textoCpf, List<AssistenteAdministrativo> listaAssistente) {
		this.textoCpf = textoCpf;
		this.listaAssAdministrativos = listaAssistente;	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "DETALHAR": {
			telaDetalharAssistente.detalharAssistente(buscarAtendentePorCpf());
			break;
		}
		}
	}

	public AssistenteAdministrativo buscarAtendentePorCpf() {

		for (AssistenteAdministrativo assistenteAdministrativo : listaAssAdministrativos) {
			if (assistenteAdministrativo.getCpf().equals(textoCpf.getText())) {
				return assistenteAdministrativo;
			}

		}
		return null;
	}
}
