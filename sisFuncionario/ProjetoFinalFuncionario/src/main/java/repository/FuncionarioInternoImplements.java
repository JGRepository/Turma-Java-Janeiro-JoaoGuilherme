package repository;

import java.math.BigDecimal;
import java.util.List;

import dao.DaoFuncInterno;
import model.FuncionarioInterno;

public class FuncionarioInternoImplements implements FuncionarioInternoRepository {

	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {

		funcionarioInterno.setNome(upperCase(funcionarioInterno.getNome()));

		return DaoFuncInterno.salvarFuncionarioInternoNoBanco(funcionarioInterno);
	}

	@Override
	public List<FuncionarioInterno> listarFuncionarioInterno() {
		return DaoFuncInterno.listarFuncInternoNoBanco();
	}

	@Override
	public boolean editarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		funcionarioInterno.setNome(upperCase(funcionarioInterno.getNome()));

		return DaoFuncInterno.editarFuncionarioInterno(funcionarioInterno);
	}

	@Override
	public boolean deletarFuncionarioInterno(String cpf) {
		// TODO Auto-generated method stub
		return DaoFuncInterno.deletarFuncionarioInterno(cpf);
	}

	@Override
	public FuncionarioInterno buscarPorFuncionarioInterno(String cpf) {
		// TODO Auto-generated method stub
		return DaoFuncInterno.buscarPorCpf(cpf);
	}

	public String upperCase(String texto) {
		return texto.toUpperCase();
	}

	public void aplicarPlr(FuncionarioInterno funcionarioInterno) {
		if (funcionarioInterno.getSalario() == null)
			return;
		funcionarioInterno.setPlr(funcionarioInterno.getSalario().multiply(new BigDecimal("0.80")));
	}

}
