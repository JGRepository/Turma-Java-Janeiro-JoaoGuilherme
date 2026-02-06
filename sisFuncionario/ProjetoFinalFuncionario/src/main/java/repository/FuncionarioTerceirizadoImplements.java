package repository;

import java.util.List;

import dao.DaoFuncTerceirizado;
import model.FuncionarioTerceirizado;

public class FuncionarioTerceirizadoImplements implements FuncionarioTerceirizadoRepository {

	@Override
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		funcionarioTerceirizado.setNome(upperCase(funcionarioTerceirizado.getNome()));
		return DaoFuncTerceirizado.salvarFuncionarioTerceirizadoNoBanco(funcionarioTerceirizado);
	}

	@Override
	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado() {
		// TODO Auto-generated method stub
		return DaoFuncTerceirizado.listarFuncTerceirizadoNoBanco();
	}

	@Override
	public boolean editarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		funcionarioTerceirizado.setNome(upperCase(funcionarioTerceirizado.getNome()));
		return DaoFuncTerceirizado.editarFuncionarioTerceirizado(funcionarioTerceirizado);
	}

	@Override
	public boolean deletarFuncionarioTerceirizado(String cpf) {
		// TODO Auto-generated method stub
		return DaoFuncTerceirizado.deletarFuncionarioTerceirizado(cpf);
	}

	@Override
	public FuncionarioTerceirizado buscarPorFuncionarioTerceirizado(String cpf) {
		// TODO Auto-generated method stub
		return DaoFuncTerceirizado.buscarPorCpf(cpf);
	}

	public String upperCase(String texto) {
		return texto.toUpperCase();
	}

}
