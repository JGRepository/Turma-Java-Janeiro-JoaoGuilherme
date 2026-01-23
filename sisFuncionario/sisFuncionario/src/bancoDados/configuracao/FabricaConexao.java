package bancoDados.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sis_funcionario";

	public  Connection conectar() {

		Connection conexao = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexao = DriverManager.getConnection(BANCO_URL, USUARIO,SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro Na linha do Class.ForName");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erro na linha DriverManager");
		}
		return conexao;
	}

}
