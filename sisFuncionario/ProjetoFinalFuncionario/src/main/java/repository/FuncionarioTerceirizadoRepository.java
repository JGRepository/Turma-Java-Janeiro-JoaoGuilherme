package repository;

import java.util.List;

import model.FuncionarioTerceirizado;

public interface FuncionarioTerceirizadoRepository {

	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);

	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado();

	public boolean editarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);

	public boolean deletarFuncionarioTerceirizado(String cpf);

	public FuncionarioTerceirizado buscarPorFuncionarioTerceirizado(String cpf);
}
