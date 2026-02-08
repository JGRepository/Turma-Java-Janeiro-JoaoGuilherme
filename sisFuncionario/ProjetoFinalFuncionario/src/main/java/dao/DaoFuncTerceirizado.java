package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FuncionarioTerceirizado;
import model.enums.CargoTerceirizado;
import util.ConexaoBanco;

public class DaoFuncTerceirizado {

	public static boolean salvarFuncionarioTerceirizadoNoBanco(FuncionarioTerceirizado funcionario) {

		String sql = "INSERT INTO funcionario_terceirizado "
				+ "(cpf, nome, data_nascimento, funcao, empresa, horas_trabalhadas, senha, lucro, custo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConexaoBanco.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, funcionario.getCpf());
			ps.setString(2, funcionario.getNome());
			ps.setDate(3, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			ps.setString(4, funcionario.getFuncao().name());
			ps.setString(5, funcionario.getEmpresa());
			ps.setInt(6, funcionario.getHorasTrabalhadas());
			ps.setString(7, funcionario.getSenha());
			ps.setBigDecimal(8, funcionario.getLucro());
			ps.setBigDecimal(9, funcionario.getCusto());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("Não foi possível salvar funcionario_terceirizado!");
			e.printStackTrace();
			return false;
		}
	}

	public static List<FuncionarioTerceirizado> listarFuncTerceirizadoNoBanco() {

		String sql = "SELECT cpf, nome, data_nascimento, funcao, empresa, horas_trabalhadas, lucro, custo "
				+ "FROM funcionario_terceirizado";

		List<FuncionarioTerceirizado> lista = new ArrayList<>();

		try (Connection conn = ConexaoBanco.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				FuncionarioTerceirizado funcTerceiro = new FuncionarioTerceirizado();

				funcTerceiro.setCpf(rs.getString("cpf"));
				funcTerceiro.setNome(rs.getString("nome"));
				funcTerceiro.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				funcTerceiro.setFuncao(CargoTerceirizado.valueOf(rs.getString("funcao")));
				funcTerceiro.setEmpresa(rs.getString("empresa"));
				funcTerceiro.setHorasTrabalhadas(rs.getInt("horas_trabalhadas"));
				funcTerceiro.setLucro(rs.getBigDecimal("lucro"));
				funcTerceiro.setCusto(rs.getBigDecimal("custo"));

				lista.add(funcTerceiro);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar funcionario_terceirizado!");
			e.printStackTrace();
		}

		return lista;
	}

	public static boolean editarFuncionarioTerceirizado(FuncionarioTerceirizado funcionario) {

		String sql = "UPDATE funcionario_terceirizado "
				+ "SET nome = ?, data_nascimento = ?, funcao = ?, empresa = ?, horas_trabalhadas = ?, lucro = ? , custo = ? "
				+ "WHERE cpf = ?";

		try (Connection conn = ConexaoBanco.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, funcionario.getNome());
			ps.setDate(2, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			ps.setString(3, funcionario.getFuncao().name());
			ps.setString(4, funcionario.getEmpresa());
			ps.setInt(5, funcionario.getHorasTrabalhadas());
			ps.setBigDecimal(6, funcionario.getLucro());
			ps.setBigDecimal(7, funcionario.getCusto());
			ps.setString(8, funcionario.getCpf());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println("Erro ao atualizar funcionario_terceirizado!");
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deletarFuncionarioTerceirizado(String cpf) {

		String sql = "DELETE FROM funcionario_terceirizado WHERE cpf = ?";

		try (Connection conn = ConexaoBanco.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, cpf);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println("Erro ao deletar funcionario_terceirizado!");
			e.printStackTrace();
			return false;
		}
	}

	public static FuncionarioTerceirizado buscarPorCpf(String cpf) {

		String sql = "SELECT cpf, nome, data_nascimento, funcao, empresa, horas_trabalhadas, lucro, custo "
				+ "FROM funcionario_terceirizado WHERE cpf = ?";

		try (Connection conn = ConexaoBanco.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, cpf);

			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					return null;
				}

				FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
				funcionarioTerceirizado.setCpf(rs.getString("cpf"));
				funcionarioTerceirizado.setNome(rs.getString("nome"));
				funcionarioTerceirizado.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				funcionarioTerceirizado.setFuncao(CargoTerceirizado.valueOf(rs.getString("funcao")));
				funcionarioTerceirizado.setEmpresa(rs.getString("empresa"));
				funcionarioTerceirizado.setHorasTrabalhadas(rs.getInt("horas_trabalhadas"));
				funcionarioTerceirizado.setLucro(rs.getBigDecimal("lucro"));
				funcionarioTerceirizado.setCusto(rs.getBigDecimal("custo"));

				return funcionarioTerceirizado;
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar funcionario_terceirizado por CPF!");
			e.printStackTrace();
			return null;
		}
	}
}
