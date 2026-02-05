package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FuncionarioInterno;
import model.enums.CargoInterno;
import util.ConexaoBanco;

public class DaoFuncInterno {

    public static boolean salvarFuncionarioInternoNoBanco(FuncionarioInterno funcionarioInterno) {

        String sql = "INSERT INTO funcionario_interno (cpf, matricula, nome, data_nascimento, cargo, salario) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionarioInterno.getCpf());
            ps.setString(2, funcionarioInterno.getMatricula());
            ps.setString(3, funcionarioInterno.getNome());
            ps.setDate(4, java.sql.Date.valueOf(funcionarioInterno.getDataNascimento()));
            ps.setString(5, funcionarioInterno.getCargo().name());
            ps.setBigDecimal(6, funcionarioInterno.getSalario());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível salvar funcionario_interno!");
            e.printStackTrace();
            return false;
        }
    }

    public static List<FuncionarioInterno> listarFuncInternoNoBanco() {

        String sql = "SELECT cpf, matricula, nome, data_nascimento, cargo, salario FROM funcionario_interno";
        List<FuncionarioInterno> lista = new ArrayList<>();

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FuncionarioInterno funcInterno = new FuncionarioInterno();

                funcInterno.setCpf(rs.getString("cpf"));
                funcInterno.setMatricula(rs.getString("matricula"));
                funcInterno.setNome(rs.getString("nome"));

               
                funcInterno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());

                funcInterno.setCargo(CargoInterno.valueOf(rs.getString("cargo")));

                // DECIMAL -> BigDecimal
                funcInterno.setSalario(rs.getBigDecimal("salario"));

                lista.add(funcInterno);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar funcionario_interno!");
            e.printStackTrace();
        }

        return lista;
    }

    public static boolean atualizarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {

        String sql = "UPDATE funcionario_interno " +
                     "SET matricula = ?, nome = ?, data_nascimento = ?, cargo = ?, salario = ? " +
                     "WHERE cpf = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionarioInterno.getMatricula());
            ps.setString(2, funcionarioInterno.getNome());
            ps.setDate(3, java.sql.Date.valueOf(funcionarioInterno.getDataNascimento()));
            ps.setString(4, funcionarioInterno.getCargo().name());
            ps.setBigDecimal(5, funcionarioInterno.getSalario());
            ps.setString(6, funcionarioInterno.getCpf());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionario_interno!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletarFuncionarioInterno(String cpf) {

        String sql = "DELETE FROM funcionario_interno WHERE cpf = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar funcionario_interno!");
            e.printStackTrace();
            return false;
        }
    }

    public static FuncionarioInterno buscarPorCpf(String cpf) {

        String sql = "SELECT cpf, matricula, nome, data_nascimento, cargo, salario " +
                     "FROM funcionario_interno WHERE cpf = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                FuncionarioInterno funcInterno = new FuncionarioInterno();
                funcInterno.setCpf(rs.getString("cpf"));
                funcInterno.setMatricula(rs.getString("matricula"));
                funcInterno.setNome(rs.getString("nome"));
                funcInterno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                funcInterno.setCargo(CargoInterno.valueOf(rs.getString("cargo")));
                funcInterno.setSalario(rs.getBigDecimal("salario"));
                return funcInterno;
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionario_interno por CPF!");
            e.printStackTrace();
            return null;
        }
    }
}
