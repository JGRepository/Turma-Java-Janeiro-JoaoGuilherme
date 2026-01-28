package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;
import interfaceGrafica.TelaListarAssistente;
import repositorio.RepositorioAssistenteImplementacao;
import validacao.Validacao;

public class ControladorTelaCadastroAssistenteAdministrativo implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	AssistenteAdministrativo assistenteAdministrativo;
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAssistenteAdministrativo;
	DaoAssistente salvarAssistente = new DaoAssistente();
	TelaListarAssistente telaListarAssistente = new TelaListarAssistente();
	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();
	AssistenteAdministrativo assistenteAdministrativo2 = new AssistenteAdministrativo();

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
			
			assistenteAdministrativo.setNome(nome.getText());
			assistenteAdministrativo.setCpf(cpf.getText());
			assistenteAdministrativo.setEmail(email.getText());
			
			String resultadoValidacao = Validacao.validaAssistente(assistenteAdministrativo);
			AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();
			assistenteAdministrativo.setNome(nome.getText());
			if(resultadoValidacao == null) {
				if (repositorioAssistenteImplementacao.salvarAssistente(assistenteAdministrativo)) {
					
					JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");
	
					nome.setText(null);
					cpf.setText(null);
					email.setText(null);
	
				} else {
					JOptionPane.showMessageDialog(null, "Não foi salvo com sucesso!!!!!");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, resultadoValidacao);
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