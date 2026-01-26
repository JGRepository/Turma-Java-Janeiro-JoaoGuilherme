package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.SupervisorAuxiliar;

public class TelaDetalharSupervisor {
	public void detalharSupervisor(SupervisorAuxiliar supervisorAuxiliar) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaSupervisor = new JFrame("Detalhes do Supervisor");
		frameTelaSupervisor.setSize(300, 180);

		JPanel panelTelaSupervisor = new JPanel();
		panelTelaSupervisor.setLayout(grid);

		panelTelaSupervisor.add(new JLabel("CPF:"));
		panelTelaSupervisor.add(new JLabel(supervisorAuxiliar.getCpf()));

		panelTelaSupervisor.add(new JLabel("NOME:"));
		panelTelaSupervisor.add(new JLabel(supervisorAuxiliar.getNome()));

		panelTelaSupervisor.add(new JLabel("EMAIL:"));
		panelTelaSupervisor.add(new JLabel(supervisorAuxiliar.getEmail()));

		frameTelaSupervisor.add(panelTelaSupervisor);
		frameTelaSupervisor.setLocationRelativeTo(null);
		frameTelaSupervisor.setVisible(true);

	
	}
}
