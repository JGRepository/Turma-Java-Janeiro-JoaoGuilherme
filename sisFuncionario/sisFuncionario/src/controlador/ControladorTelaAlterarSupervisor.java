package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaListarSupervisor;
import repositorio.RepositorioSupervisorImplementacao;

public class ControladorTelaAlterarSupervisor implements ActionListener {

	JFrame telaAlterarFrame;
	JTextField nome;
	JTextField cpf;
	JTextField email;
	RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
	TelaListarSupervisor telaListarSupervisor = new TelaListarSupervisor();
	

	public ControladorTelaAlterarSupervisor(JTextField nome, JTextField cpf, JTextField email, JFrame telaAlterar) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telaAlterarFrame = telaAlterar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "ALTERAR": {
			SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();
			supervisorAuxiliar.setNome(nome.getText());
			supervisorAuxiliar.setCpf(cpf.getText());
			supervisorAuxiliar.setEmail(email.getText());
			
			telaAlterarFrame.setVisible(false);
			repositorioSupervisorImplementacao.alterarSupervisor(supervisorAuxiliar);
			JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso");

			telaListarSupervisor.listarSupervisor(repositorioSupervisorImplementacao.listarSupervisor());
			
		} case "VOLTAR" :{
			telaAlterarFrame.setVisible(false);
		}

		}
	}
}
