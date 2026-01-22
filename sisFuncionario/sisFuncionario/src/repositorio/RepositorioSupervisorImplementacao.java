package repositorio;

import bancoDados.dao.DaoSupervisor;
import entidade.SupervisorAuxiliar;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	DaoSupervisor daoSupervisor = new DaoSupervisor();
	
	@Override
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		
		return daoSupervisor.salvarSupervisor(supervisorAuxiliar, null);
	}

}
