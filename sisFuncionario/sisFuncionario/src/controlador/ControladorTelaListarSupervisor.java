package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaAlterarSupervisor;
import interfaceGrafica.TelaDetalharSupervisor;
import interfaceGrafica.TelaListarSupervisor;
import interfaceGrafica.TelaPrincipal;
import repositorio.RepositorioSupervisorImplementacao;

public class ControladorTelaListarSupervisor implements ActionListener {

	JFrame frameTelaListarSupervisorFrame;
	JTextField textoCpf;
	List<SupervisorAuxiliar> listaSupervisor;

	
	TelaPrincipal telaPrincipal = new TelaPrincipal();
	TelaListarSupervisor telaListarSupervisor = new TelaListarSupervisor();
	TelaAlterarSupervisor telaAlterarSupervisor = new TelaAlterarSupervisor();
	RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
	TelaDetalharSupervisor telaDetalharSupervisor = new TelaDetalharSupervisor();
	
	public ControladorTelaListarSupervisor(JTextField textCpf, List<SupervisorAuxiliar> listaSupervisor, JFrame frameTelaListarSupervisorFrame) {

		this.textoCpf = textCpf;
		this.listaSupervisor = listaSupervisor;
		this.frameTelaListarSupervisorFrame = frameTelaListarSupervisorFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "DETALHAR": {
			SupervisorAuxiliar supervisorAuxiliar = buscarSupervisorPorCpf();
			if (supervisorAuxiliar != null) {

				telaDetalharSupervisor.detalharSupervisor(buscarSupervisorPorCpf());
			} else {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido");
			}
			break;
		}
		case "ALTERAR": {

			SupervisorAuxiliar supervisorAuxiliar = buscarSupervisorPorCpf();
			if (supervisorAuxiliar != null) {

				telaAlterarSupervisor.alterarSupervisor(supervisorAuxiliar);

			} else {

			}

			break;
		}
		case "DELETAR": {

			String cpfDeletar = buscarSupervisorPorCpf().getCpf();
			if (cpfDeletar != null) {

				repositorioSupervisorImplementacao.deletarSupervisor(cpfDeletar);
				JOptionPane.showMessageDialog(null, "CPF Deletado com Sucesso");
				frameTelaListarSupervisorFrame.setVisible(false);

				telaListarSupervisor.listarSupervisor(repositorioSupervisorImplementacao.listarSupervisor());

			} else {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido");
			}

		}
		case "MENU INICIAL": {
			frameTelaListarSupervisorFrame.setVisible(false);

			telaPrincipal.menuPrincipal();
		}
		}

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
