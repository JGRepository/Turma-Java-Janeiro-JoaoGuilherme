package repository;

import java.util.List;

import model.FuncionarioInterno;

public interface FuncionarioInternoRepository {
	public boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno);

	public List<FuncionarioInterno> listarFuncionarioInterno();

	public boolean editarFuncionarioInterno(FuncionarioInterno funcionarioInterno);

	public boolean deletarFuncionarioInterno(String cpf);

	public FuncionarioInterno buscarPorFuncionarioInterno(String cpf);

}
