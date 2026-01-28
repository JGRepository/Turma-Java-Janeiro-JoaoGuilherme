package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.AssistenteAdministrativo;
import interfaceGrafica.TelaAlterarAssistente;
import interfaceGrafica.TelaDetalharAssistente;
import interfaceGrafica.TelaListarAssistente;
import interfaceGrafica.TelaPrincipal;
import repositorio.RepositorioAssistenteImplementacao;

public class ControladorTelaListarAssistente implements ActionListener {

	JFrame frameTelaListarAssistenteFrame;
	JTextField textoCpf;
	List<AssistenteAdministrativo> listaAssAdministrativos;

	TelaPrincipal telaPrincipal = new TelaPrincipal();
	TelaListarAssistente telaListarAssistente = new TelaListarAssistente();
	TelaAlterarAssistente telaAlterarAssistente = new TelaAlterarAssistente();
	RepositorioAssistenteImplementacao respositorioAssitenteAssistente = new RepositorioAssistenteImplementacao();
	TelaDetalharAssistente telaDetalharAssistente = new TelaDetalharAssistente();

	public ControladorTelaListarAssistente(JTextField textoCpf, List<AssistenteAdministrativo> listaAssistente,
			JFrame frameTelaListarAssistente) {
		this.textoCpf = textoCpf;
		this.listaAssAdministrativos = listaAssistente;
		this.frameTelaListarAssistenteFrame = frameTelaListarAssistente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "DETALHAR": {
			AssistenteAdministrativo assistenteAdministrativo = buscarAtendentePorCpf();
			if (assistenteAdministrativo != null) {

				telaDetalharAssistente.detalharAssistente(buscarAtendentePorCpf());
			} else {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido");
			}
			break;
		}
		case "ALTERAR": {

			AssistenteAdministrativo assistenteAdministrativo = buscarAtendentePorCpf();
			if (assistenteAdministrativo != null) {

				telaAlterarAssistente.alterarAssistente(assistenteAdministrativo);

			} else {

			}

			break;
		}
		case "DELETAR": {

			String cpfDeletar = buscarAtendentePorCpf().getCpf();
			if (cpfDeletar != null) {

				respositorioAssitenteAssistente.deletarAssistente(cpfDeletar);
				JOptionPane.showMessageDialog(null, "CPF Deletado com Sucesso");
				frameTelaListarAssistenteFrame.setVisible(false);

				telaListarAssistente.listarAtendente(respositorioAssitenteAssistente.listarAssistente());

			} else {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido");
			}

		}
		case "MENU INICIAL": {
			frameTelaListarAssistenteFrame.setVisible(false);

			telaPrincipal.menuPrincipal();
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
