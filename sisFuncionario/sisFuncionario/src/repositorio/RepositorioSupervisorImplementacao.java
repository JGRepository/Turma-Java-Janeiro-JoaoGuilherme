package repositorio;

import java.util.List;

import bancoDados.dao.DaoSupervisor;
import entidade.SupervisorAuxiliar;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	
	@Override
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		
		return DaoSupervisor.salvarSupervisor(supervisorAuxiliar, null);
	}

	@Override
	public List<SupervisorAuxiliar> listarSupervisor() {
		return DaoSupervisor.listarSupervisorAuxiliar();
	}

	@Override
	public boolean alterarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		return DaoSupervisor.alterarSupervisor(supervisorAuxiliar);
	}

	@Override
	public boolean deletarSupervisor(String cpf) {
		return DaoSupervisor.deletarSupervisor(cpf);
	}

}
