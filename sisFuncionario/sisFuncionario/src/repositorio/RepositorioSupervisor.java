package repositorio;

import java.util.List;

import entidade.SupervisorAuxiliar;

public interface RepositorioSupervisor {
	
	public boolean salvarSupervisor(SupervisorAuxiliar supervisorAuxiliar);

	public List<SupervisorAuxiliar> listarSupervisor();

	public boolean alterarSupervisor(SupervisorAuxiliar supervisorAuxiliar);

	public boolean deletarSupervisor(String cpf);
}
