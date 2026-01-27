package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;
import gerenciaArquivo.ManipuladorArquivo;
import interfaceGrafica.TelaListarAssistente;
import repositorio.RepositorioAssistenteImplementacao;
import repositorio.RepositorioSupervisorImplementacao;

public class ControladorTelaCadastroAssistenteAdministrativo implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	AssistenteAdministrativo assistenteAdministrativo;
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAssistenteAdministrativo;
	DaoAssistente salvarAssistente = new DaoAssistente();
	TelaListarAssistente telaListarAssistente = new TelaListarAssistente();
	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();


	public ControladorTelaCadastroAssistenteAdministrativo(JTextField nome, JTextField cpf, JTextField email,
			JFrame frameTelaPrincipal, JFrame frameCadastroAssistenteAdministrativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroAssistenteAdministrativo = frameCadastroAssistenteAdministrativo;
	}

	public ControladorTelaCadastroAssistenteAdministrativo(JTextField textCpf,
			List<AssistenteAdministrativo> listaAssistente) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());

		switch (e.getActionCommand()) {
		case "CADASTRAR": {

			AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();
			assistenteAdministrativo.setNome(nome.getText());

			if (!assistenteAdministrativo.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");

			} else {
				assistenteAdministrativo.setCpf(cpf.getText());
				assistenteAdministrativo.setEmail(email.getText());

				if (salvarAssistente.salvarAssistente(assistenteAdministrativo, "INSERT")) {

					JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");

					nome.setText(null);
					cpf.setText(null);
					email.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
				}
			}

			break;
		}

		case "MENU PRINCIPAL": {
			frameCadastroAssistenteAdministrativo.setVisible(false);
			frameTelaPrincipal.setVisible(true);

			break;
		}
		
		case "LISTAR" :{
			telaListarAssistente.listarAtendente(repositorioAssistenteImplementacao.listarAssistente());
			frameCadastroAssistenteAdministrativo.setVisible(false);
			break;
		}
		}

	}

}