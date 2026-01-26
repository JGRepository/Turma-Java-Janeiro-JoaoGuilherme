package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.AssistenteAdministrativo;

public class DaoAssistente {

	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo, String query) {
		boolean salvar = false;
		String sqlQuery;
		
	    if ("INSERT".equalsIgnoreCase(query)) {
	    	sqlQuery = "INSERT INTO assistente (cpf, nome, email) VALUES (?, ?, ?)";
	    } else if ("UPDATE".equalsIgnoreCase(query)) {
	    	sqlQuery = "UPDATE assistente SET nome = ?, email = ? WHERE cpf = ?";
	    } else if ("DELETE".equalsIgnoreCase(query)) {
	    	sqlQuery = "DELETE from assistente where cpf = ?";
			
		} else{
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
	        } else if ("UPDATE".equalsIgnoreCase(query)){
	        	preparaComando.setString(1, assistenteAdministrativo.getNome());
	        	preparaComando.setString(2, assistenteAdministrativo.getEmail());
	        	preparaComando.setString(3, assistenteAdministrativo.getCpf());
	        } else if ("DELETE".equalsIgnoreCase(query)){
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
public List<AssistenteAdministrativo> listarAssistenteAdministrativo() {
		
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
		}
		finally {
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
}
