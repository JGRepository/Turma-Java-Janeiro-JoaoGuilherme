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

	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar, String query) {
		boolean salvar = false;
		String sqlQuery;
		
	    if ("INSERT".equalsIgnoreCase(query)) {
	    	sqlQuery = "INSERT INTO supervisor (cpf, nome, email) VALUES (?, ?, ?)";
	    } else if ("UPDATE".equalsIgnoreCase(query)) {
	    	sqlQuery = "UPDATE supervisor SET nome = ?, email = ? WHERE cpf = ?";
	    } else if ("DELETE".equalsIgnoreCase(query)) {
	    	sqlQuery = "DELETE from supervisor where cpf = ?";
			
		} else{
	        System.out.println("Operação inválida");
	        return false;
	    }


		FabricaConexao fabricaConexao = new FabricaConexao();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		
		
		try {
			conexaoSisFuncionario = fabricaConexao.conectar();
			preparaComando = conexaoSisFuncionario.prepareStatement(sqlQuery);

			if ("INSERT".equalsIgnoreCase(query)) {
				preparaComando.setString(1, supervisorAuxiliar.getCpf());
				preparaComando.setString(2, supervisorAuxiliar.getNome());
				preparaComando.setString(3, supervisorAuxiliar.getEmail());
	        } else if ("UPDATE".equalsIgnoreCase(query)){
	        	preparaComando.setString(1, supervisorAuxiliar.getNome());
	        	preparaComando.setString(2, supervisorAuxiliar.getEmail());
	        	preparaComando.setString(3, supervisorAuxiliar.getCpf());
	        } else if ("DELETE".equalsIgnoreCase(query)){
	        	preparaComando.setString(1, supervisorAuxiliar.getCpf());
	 
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
	
	public List<SupervisorAuxiliar> listarSupervisorAuxiliar(){
		
		
	
			
			FabricaConexao conexaoFabricaConexao = new FabricaConexao();
			Connection connection = null; 
			PreparedStatement preparaOcomandoSQL = null; 

			String comandoSqlInsert = "select * from supervisor"; 
			
			List<SupervisorAuxiliar> listaGerente = new ArrayList<SupervisorAuxiliar>();
			
			ResultSet resultadoDaTabelaDoBanco = null;
			
			try {
				
				connection = conexaoFabricaConexao.conectar();
				preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
				
				
				resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();
				
				while(resultadoDaTabelaDoBanco.next()) {
					
					SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();
					
					supervisorAuxiliar.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
					
					supervisorAuxiliar.setNome(resultadoDaTabelaDoBanco.getString("nome"));
					
					supervisorAuxiliar.setEmail(resultadoDaTabelaDoBanco.getString("email"));
					
					listaGerente.add(supervisorAuxiliar);
					
					
				}
				
				
			}catch (Exception e) {
				
			
			} finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
													// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

			
			return listaGerente;
		
	}

}
