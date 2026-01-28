package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.SupervisorAuxiliar;

public class DaoSupervisor {

	public static boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar, String query) {
		boolean salvar = false;
		String sqlQuery;

		if ("INSERT".equalsIgnoreCase(query)) {
			sqlQuery = "INSERT INTO supervisor (cpf, nome, email) VALUES (?, ?, ?)";
		} else if ("UPDATE".equalsIgnoreCase(query)) {
			sqlQuery = "UPDATE supervisor SET nome = ?, email = ? WHERE cpf = ?";
		} else if ("DELETE".equalsIgnoreCase(query)) {
			sqlQuery = "DELETE from supervisor where cpf = ?";

		} else {
			System.out.println("Operação inválida");
			return false;
		}

		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = FabricaConexao.conectar();
			preparaComando = conexaoSisFuncionario.prepareStatement(sqlQuery);

			if ("INSERT".equalsIgnoreCase(query)) {
				preparaComando.setString(1, supervisorAuxiliar.getCpf());
				preparaComando.setString(2, supervisorAuxiliar.getNome());
				preparaComando.setString(3, supervisorAuxiliar.getEmail());
			} else if ("UPDATE".equalsIgnoreCase(query)) {
				preparaComando.setString(1, supervisorAuxiliar.getNome());
				preparaComando.setString(2, supervisorAuxiliar.getEmail());
				preparaComando.setString(3, supervisorAuxiliar.getCpf());
			} else if ("DELETE".equalsIgnoreCase(query)) {
				preparaComando.setString(1, supervisorAuxiliar.getCpf());

			}

			preparaComando.execute();
			salvar = true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar o COMANDO");
			e.printStackTrace();
		} finally {
			try {
				if (conexaoSisFuncionario != null) {
					conexaoSisFuncionario.close();
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

	public static List<SupervisorAuxiliar> listarSupervisorAuxiliar() {

		Connection connection = null;
		PreparedStatement preparaOcomandoSQL = null;

		String comandoSqlInsert = "select * from supervisor";

		List<SupervisorAuxiliar> listaSupervisorAuxiliar = new ArrayList<SupervisorAuxiliar>();

		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connection = FabricaConexao.conectar();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);

			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {

				SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();

				supervisorAuxiliar.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				supervisorAuxiliar.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				supervisorAuxiliar.setEmail(resultadoDaTabelaDoBanco.getString("email"));
				listaSupervisorAuxiliar.add(supervisorAuxiliar);

			}

		} catch (Exception e) {

		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
				if (preparaOcomandoSQL != null) {
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return listaSupervisorAuxiliar;

	}
	public static boolean alterarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE supervisor SET nome = ?,  email = ? WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.conectar();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, supervisorAuxiliar.getNome());
			preparedStatement.setString(2, supervisorAuxiliar.getEmail());
			preparedStatement.setString(3, supervisorAuxiliar.getCpf());

			preparedStatement.execute();

			resultadoBoolean = true;

		} catch (Exception e) {

		} finally {
			try {
				if (connectar != null) {
					connectar.close();

				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return resultadoBoolean;
	}
	
	public static boolean deletarSupervisor(String cpf) {
		
		Boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from supervisor where cpf = ? ";
		
		try {
			conectar = FabricaConexao.conectar();
			preparedStatement = conectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, cpf);
			preparedStatement.execute();

			deletar = true;
			
		} catch (Exception e) {
			
		}finally {
			try {
				if (conectar != null) {
					conectar.close();

				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}
		
		return deletar;
	}
}
