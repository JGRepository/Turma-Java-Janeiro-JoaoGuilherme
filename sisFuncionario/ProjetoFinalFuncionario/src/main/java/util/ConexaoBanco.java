package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/funcionarios_db";

	public static Connection conectar() {

		Connection conexao = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexao = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);
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
