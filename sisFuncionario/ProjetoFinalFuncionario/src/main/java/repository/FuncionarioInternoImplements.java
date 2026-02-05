package repository;

import java.util.List;

import dao.DaoFuncInterno;
import model.FuncionarioInterno;

public class FuncionarioInternoImplements implements FuncionarioInternoRepository {

	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		return DaoFuncInterno.salvarFuncionarioInternoNoBanco(funcionarioInterno);
	}

	@Override
	public List<FuncionarioInterno> listarFuncionarioInterno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarFuncionarioInterno(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FuncionarioInterno buscarPorFuncionarioInterno(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
