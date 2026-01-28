package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.AssistenteAdministrativo;
import interfaceGrafica.TelaListarAssistente;
import repositorio.RepositorioAssistenteImplementacao;

public class ControladorTelaAlterarAssistente implements ActionListener {

	JFrame telaAlterarFrame;
	JTextField nome;
	JTextField cpf;
	JTextField email;
	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();
	TelaListarAssistente telaListarAtendenteFrame = new TelaListarAssistente();
	

	public ControladorTelaAlterarAssistente(JTextField nome, JTextField cpf, JTextField email, JFrame telaAlterar) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telaAlterarFrame = telaAlterar;
		
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
			JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso");
			telaAlterarFrame.setVisible(false);

			telaListarAtendenteFrame.listarAtendente(repositorioAssistenteImplementacao.listarAssistente());
			
		} case "VOLTAR" :{
			telaAlterarFrame.setVisible(false);
		}

		}
	}
}
