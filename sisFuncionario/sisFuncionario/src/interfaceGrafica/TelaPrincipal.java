package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal {


		
		
		public void menuPrincipal() {
			System.out.println("Inicio do metodo menuPrincipal");
			
			JFrame frameMenuPrincipal = new JFrame();
			frameMenuPrincipal.setSize(1000,1000);
			
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
			frameMenuPrincipal.setVisible(true); 
			
	}
}

