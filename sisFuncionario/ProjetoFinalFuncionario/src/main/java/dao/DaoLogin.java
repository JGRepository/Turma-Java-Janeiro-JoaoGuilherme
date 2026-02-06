package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConexaoBanco;

public class DaoLogin {

	public static boolean autenticar(String cpf, String senhaDigitada) {

		String sql = "SELECT cpf, senha FROM funcionario_interno WHERE cpf = ? " + "UNION "
				+ "SELECT cpf, senha FROM funcionario_terceirizado WHERE cpf = ?";

		try (Connection conn = ConexaoBanco.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, cpf);
			ps.setString(2, cpf);

			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					return false;
				}

				String senhaBanco = rs.getString("senha");

				return senhaDigitada.equals(senhaBanco);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
