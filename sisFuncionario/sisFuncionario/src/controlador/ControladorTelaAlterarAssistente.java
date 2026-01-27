package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entidade.AssistenteAdministrativo;
import repositorio.RepositorioAssistenteImplementacao;

public class ControladorTelaAlterarAssistente implements ActionListener {

	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();

	JTextField nome;
	JTextField cpf;
	JTextField email;
	

	public ControladorTelaAlterarAssistente(JTextField nome, JTextField cpf, JTextField email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "ALTERAR": {
			AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();
			assistenteAdministrativo.setNome(nome.getText());
			assistenteAdministrativo.setCpf(cpf.getText());
			assistenteAdministrativo.setEmail(email.getText());
			
			repositorioAssistenteImplementacao.alterarAssistente(assistenteAdministrativo);

		}

		}
	}
}
