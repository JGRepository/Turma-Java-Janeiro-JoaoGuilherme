package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
