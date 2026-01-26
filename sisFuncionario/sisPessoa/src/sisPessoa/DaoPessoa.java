package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoPessoa {

	public boolean salvarNoBanco(Pessoa pessoa) {
		boolean salvar = false;

		String comandoSqlInsert = "insert into pessoa (cpf, nome, email) values (?, ?, ?)";
		Connection conexaoSisPessoa = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisPessoa = FabricaConexao.conectar();
			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, pessoa.getCpf());
			preparaComando.setString(2, pessoa.getNome());
			preparaComando.setString(3, pessoa.getEmail());

			preparaComando.execute();
			salvar = true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar o INSERT");
			e.printStackTrace();
		} finally {
			try {
				if (conexaoSisPessoa != null) {
					conexaoSisPessoa.close();
				}
				if (preparaComando != null) {
					preparaComando.close();
				}
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return salvar;
	}

}
