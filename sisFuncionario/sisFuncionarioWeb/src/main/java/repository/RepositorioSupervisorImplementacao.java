package repository;

import java.util.List;

import dao.DaoSupervisor;
import model.SupervisorAuxiliar;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	
	@Override
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		supervisorAuxiliar.setNome(metodoUpercase(supervisorAuxiliar.getNome()));
		supervisorAuxiliar.setEmail(metodoUpercase(supervisorAuxiliar.getEmail()));
		
		return DaoSupervisor.salvarSupervisor(supervisorAuxiliar, "INSERT");
	}

	@Override
	public List<SupervisorAuxiliar> listarSupervisor() {
		return DaoSupervisor.listarSupervisorAuxiliar();
	}

	@Override
	public boolean alterarSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		supervisorAuxiliar.setNome(metodoUpercase(supervisorAuxiliar.getNome()));
		supervisorAuxiliar.setEmail(metodoUpercase(supervisorAuxiliar.getEmail()));
		return DaoSupervisor.alterarSupervisor(supervisorAuxiliar);
	}

	@Override
	public boolean deletarSupervisor(String cpf) {
		return DaoSupervisor.deletarSupervisor(cpf);
	}
	public String metodoUpercase(String texto) {

		return texto.toUpperCase();
	}

}
