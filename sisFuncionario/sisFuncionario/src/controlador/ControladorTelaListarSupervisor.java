package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaDetalharSupervisor;

public class ControladorTelaListarSupervisor implements ActionListener {

	JTextField textoCpf;
	List<SupervisorAuxiliar> listaSupervisor;
	TelaDetalharSupervisor telaDetalharSupervisor = new TelaDetalharSupervisor();

	public ControladorTelaListarSupervisor(JTextField textCpf, List<SupervisorAuxiliar> listaSupervisor) {

		this.textoCpf = textCpf;
		this.listaSupervisor = listaSupervisor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaDetalharSupervisor.detalharSupervisor(buscarSupervisorPorCpf());

	}

	public SupervisorAuxiliar buscarSupervisorPorCpf() {

		for (SupervisorAuxiliar supervisorAuxiliar : listaSupervisor) {
			if (supervisorAuxiliar.getCpf().equals(textoCpf.getText())) {
				return supervisorAuxiliar;
			}

		}
		return null;
	}
}
