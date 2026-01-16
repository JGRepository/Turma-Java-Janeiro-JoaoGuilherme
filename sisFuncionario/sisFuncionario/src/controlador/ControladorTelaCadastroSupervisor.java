package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import gerenciaArquivo.ManipuladorArquivo;

public class ControladorTelaCadastroSupervisor implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	SupervisorAuxiliar supervisorAuxiliar;
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	
	
	public ControladorTelaCadastroSupervisor (JTextField nome, JTextField cpf, JTextField email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());
		
		SupervisorAuxiliar supervisor = new SupervisorAuxiliar();
		supervisor.setNome(nome.getText());
		supervisor.setCpf(cpf.getText());
		supervisor.setEmail(email.getText());
		
		
		
		if(manipuladorArquivo.registrarSupervisor(supervisor)) {
			JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");
			
		}else {
			JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
		}
		
		
		
	}

}