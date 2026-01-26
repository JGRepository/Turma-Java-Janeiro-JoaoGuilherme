package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.dao.DaoSupervisor;
import entidade.SupervisorAuxiliar;
import gerenciaArquivo.ManipuladorArquivo;
import interfaceGrafica.TelaListarSupervisor;
import repositorio.RepositorioSupervisorImplementacao;

public class ControladorTelaCadastroSupervisor implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	SupervisorAuxiliar supervisorAuxiliar;
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	JFrame frameTelaPrincipal;
	JFrame frameCadastroSupervisor;
	DaoSupervisor salvarSupervisor = new DaoSupervisor();
	TelaListarSupervisor listarSupervisor = new TelaListarSupervisor();
	RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();

	public ControladorTelaCadastroSupervisor(JTextField nome, JTextField cpf, JTextField email,
			JFrame frameTelaPrincipal, JFrame frameCadastroSupervisor) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroSupervisor = frameCadastroSupervisor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());

		switch (e.getActionCommand()) {
		case "CADASTRAR": {

			SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();

			supervisorAuxiliar.setNome(nome.getText());

			if (!supervisorAuxiliar.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");

			} else {
				supervisorAuxiliar.setCpf(cpf.getText());
				supervisorAuxiliar.setEmail(email.getText());

				if (salvarSupervisor.salvarSupervisor(supervisorAuxiliar, "INSERT")) {

					JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");

					nome.setText(null);
					cpf.setText(null);
					email.setText(null);

				}

				else {
					JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
				}
			}

			break;
		}

		case "MENU PRINCIPAL": {
			frameCadastroSupervisor.setVisible(false);
			frameTelaPrincipal.setVisible(true);

			break;
		}
		case "LISTAR": {
			listarSupervisor.listarResultados(repositorioSupervisorImplementacao.listarSupervisor());
			break;
		}

		case "DETALHAR": {
			System.out.println("chegou aqui");

		}
		}
	}

}
