package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorPaginaPrincipal;

public class TelaPrincipal {


		
		
		public void menuPrincipal() {
			System.out.println("Inicio do metodo menu Principal");
			
			JFrame frameMenuPrincipal = new JFrame();
			frameMenuPrincipal.setSize(300,300);
			
			JPanel panelMenuPrincipal = new JPanel();
			
			JLabel labelOpcao1 = new JLabel("1 - SUPERVISOR AUXILIAR");
			panelMenuPrincipal.add(labelOpcao1);
			
			JLabel labelOpcao2 = new JLabel("2 - ASSISTENTE ADMINISTRATIVO");
			panelMenuPrincipal.add(labelOpcao2);
			
			JTextField caixaTextoOpcao = new JTextField(10);
			panelMenuPrincipal.add(caixaTextoOpcao);
			
			JButton botaoEnviar = new JButton("Enviar");
			panelMenuPrincipal.add(botaoEnviar);
			
			
			frameMenuPrincipal.add(panelMenuPrincipal);
			frameMenuPrincipal.setLocationRelativeTo(null);
			frameMenuPrincipal.setVisible(true); 
			
			ControladorPaginaPrincipal controladorPaginaPrincipal = new ControladorPaginaPrincipal(caixaTextoOpcao, frameMenuPrincipal);
		    botaoEnviar.addActionListener(controladorPaginaPrincipal);
	}
}

