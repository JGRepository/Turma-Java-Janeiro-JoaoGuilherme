package repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	public void aplicarCustos(FuncionarioTerceirizado funcionarioTerceirizado) {
		if (funcionarioTerceirizado == null)
			return;

		if (funcionarioTerceirizado.getFuncao() == null)
			return;

		int horasInt = funcionarioTerceirizado.getHorasTrabalhadas();
		if (horasInt <= 0)
			return;

		if (funcionarioTerceirizado.getLucro() == null)
			return;

		BigDecimal horas = BigDecimal.valueOf(horasInt);

		BigDecimal valorHora = funcionarioTerceirizado.getFuncao().getValorHora();
		if (valorHora == null)
			return;

		BigDecimal base = valorHora.multiply(horas);
		BigDecimal adicionalLucro = funcionarioTerceirizado.getLucro().multiply(new BigDecimal("0.30"));
		BigDecimal custo = base.add(adicionalLucro).setScale(2, RoundingMode.HALF_UP);

		funcionarioTerceirizado.setCusto(custo);
	}

}
