package util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import dao.DaoFuncInterno;
import model.FuncionarioInterno;
import model.enums.CargoInterno;

public class TesteBancada {
	public static void main(String[] args) {

		// 1) INSERT
		FuncionarioInterno f = new FuncionarioInterno();
		f.setCpf("11111111111");
		f.setMatricula("MAT-001");
		f.setNome("João Guilherme");
		f.setDataNascimento(LocalDate.of(1995, 5, 10));
		f.setCargo(CargoInterno.ASSISTENTE);
		f.setSalario(new BigDecimal("5000.00"));

		boolean okInsert = DaoFuncInterno.salvarFuncionarioInternoNoBanco(f);
		System.out.println("INSERT interno: " + okInsert);

		// 2) LIST
		List<FuncionarioInterno> lista = DaoFuncInterno.listarFuncInternoNoBanco();
		System.out.println("TOTAL internos: " + lista.size());
		for (FuncionarioInterno item : lista) {
			System.out.println(
					item.getCpf() + " | " + item.getNome() + " | " + item.getCargo() + " | PLR=" + item.getPlr());
		}

		// 3) BUSCAR
		FuncionarioInterno buscado = DaoFuncInterno.buscarPorCpf("11111111111");
		System.out.println("BUSCADO: " + (buscado == null ? "null" : buscado.getNome()));

		// 4) UPDATE
		if (buscado != null) {
			buscado.setNome("JG Atualizado");
			buscado.setSalario(new BigDecimal("6500.00"));
			boolean okUpdate = DaoFuncInterno.editarFuncionarioInterno(buscado);
			System.out.println("UPDATE interno: " + okUpdate);
		}

		// 5) DELETE (descomente quando quiser testar)
		// boolean okDelete = DaoFuncInterno.deletarFuncionarioInterno("11111111111");
		// System.out.println("DELETE interno: " + okDelete);
	}
}
