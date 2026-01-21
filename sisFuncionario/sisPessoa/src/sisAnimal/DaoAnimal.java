package sisAnimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisPessoa.FabricaConexao;

public class DaoAnimal {

	public boolean salvarNoBanco(Animal animal, String query) {
		boolean salvar = false;
		String sqlQuery;
		
	    if ("INSERT".equalsIgnoreCase(query)) {
	    	sqlQuery = "INSERT INTO animal (matricula, nome, nomeTutor) VALUES (?, ?, ?)";
	    } else if ("UPDATE".equalsIgnoreCase(query)) {
	    	sqlQuery = "UPDATE animal SET nome = ?, nomeTutor = ? WHERE matricula = ?";
	    } else if ("DELETE".equalsIgnoreCase(query)) {
	    	sqlQuery = "DELETE from animal where matricula = ?";
			
		} else{
	        System.out.println("Operação inválida");
	        return false;
	    }


		FabricaConexao fabricaConexao = new FabricaConexao();
		Connection conexaoSisPessoa = null;
		PreparedStatement preparaComando = null;

		
		
		try {
			conexaoSisPessoa = fabricaConexao.conectar();
			preparaComando = conexaoSisPessoa.prepareStatement(sqlQuery);

			if ("INSERT".equalsIgnoreCase(query)) {
				preparaComando.setString(1, animal.getMatricula());
				preparaComando.setString(2, animal.getNome());
				preparaComando.setString(3, animal.getNomeTutor());
	        } else if ("UPDATE".equalsIgnoreCase(query)){
	        	preparaComando.setString(1, animal.getNome());
	        	preparaComando.setString(2, animal.getNomeTutor());
	        	preparaComando.setString(3, animal.getMatricula());
	        } else if ("DELETE".equalsIgnoreCase(query)){
	        	preparaComando.setString(1, animal.getMatricula());
	 
	        }

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
