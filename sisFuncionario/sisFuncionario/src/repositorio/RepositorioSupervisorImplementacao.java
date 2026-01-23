package repositorio;

import java.util.List;

import bancoDados.dao.DaoSupervisor;
import entidade.SupervisorAuxiliar;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	DaoSupervisor daoSupervisor = new DaoSupervisor();
	
	@Override
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		
		return daoSupervisor.salvarSupervisor(supervisorAuxiliar, null);
	}

	@Override
	public List<SupervisorAuxiliar> listarSupervisor() {
		return daoSupervisor.listarSupervisorAuxiliar();
	}

}
