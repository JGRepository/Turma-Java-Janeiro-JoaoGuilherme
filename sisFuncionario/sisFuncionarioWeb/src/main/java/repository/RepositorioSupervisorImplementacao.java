package repository;

import java.util.List;

import dao.DaoSupervisor;
import model.SupervisorAuxiliar;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	
	@Override
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		
		return DaoSupervisor.salvarSupervisor(supervisorAuxiliar, "INSERT");
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
