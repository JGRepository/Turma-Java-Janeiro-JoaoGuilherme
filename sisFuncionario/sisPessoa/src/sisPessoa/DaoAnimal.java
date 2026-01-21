package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoAnimal {

	public boolean salvarNoBanco(Animal animal) {
		boolean salvar = false;

		String comandoSqlInsert = "insert into animal (matricula, nome, nomeTutor) values (?, ?, ?)";
		FabricaConexao fabricaConexao = new FabricaConexao();
		Connection conexaoSisPessoa = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisPessoa = fabricaConexao.conectar();
			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, animal.getMatricula());
			preparaComando.setString(2, animal.getNome());
			preparaComando.setString(3, animal.getNomeTutor());

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
