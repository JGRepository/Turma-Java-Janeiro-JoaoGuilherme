package bancoDados.dao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.AssistenteAdministrativo;

public class DaoAssistente {

	public static boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo, String query) {
		boolean salvar = false;
		String sqlQuery;

		if ("INSERT".equalsIgnoreCase(query)) {
			sqlQuery = "INSERT INTO assistente (cpf, nome, email) VALUES (?, ?, ?)";
		} else if ("UPDATE".equalsIgnoreCase(query)) {
			sqlQuery = "UPDATE assistente SET nome = ?, email = ? WHERE cpf = ?";
		} else if ("DELETE".equalsIgnoreCase(query)) {
			sqlQuery = "DELETE from assistente where cpf = ?";

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
				preparaComando.setString(1, assistenteAdministrativo.getCpf());
				preparaComando.setString(2, assistenteAdministrativo.getNome());
				preparaComando.setString(3, assistenteAdministrativo.getEmail());
			} else if ("UPDATE".equalsIgnoreCase(query)) {
				preparaComando.setString(1, assistenteAdministrativo.getNome());
				preparaComando.setString(2, assistenteAdministrativo.getEmail());
				preparaComando.setString(3, assistenteAdministrativo.getCpf());
			} else if ("DELETE".equalsIgnoreCase(query)) {
				preparaComando.setString(1, assistenteAdministrativo.getCpf());

			}

			preparaComando.execute();
			salvar = true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar o INSERT");
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

	public static List<AssistenteAdministrativo> listarAssistenteAdministrativo() {

		Connection connection = null;
		PreparedStatement prepararOcomandoSql = null;
		String comandoSqlInsert = "select * from assistente";
		List<AssistenteAdministrativo> listaAssistente = new ArrayList<AssistenteAdministrativo>();
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connection = FabricaConexao.conectar();
			prepararOcomandoSql = connection.prepareStatement(comandoSqlInsert);
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {

				AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();

				assistenteAdministrativo.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				assistenteAdministrativo.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				assistenteAdministrativo.setEmail(resultadoDaTabelaDoBanco.getString("email"));
				listaAssistente.add(assistenteAdministrativo);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (connection != null) {
					connection.close();

				}
				if (prepararOcomandoSql != null) {
					prepararOcomandoSql.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return listaAssistente;
	}

	public static boolean alterarAssistente(AssistenteAdministrativo assistenteAdministrativo) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE assistente SET nome = ?,  email = ? WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.conectar();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, assistenteAdministrativo.getNome());
			preparedStatement.setString(2, assistenteAdministrativo.getEmail());
			preparedStatement.setString(3, assistenteAdministrativo.getCpf());

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
	
	public static boolean deletarAssistente(String cpf) {
		
		Boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from assistente where cpf = ? ";
		
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
