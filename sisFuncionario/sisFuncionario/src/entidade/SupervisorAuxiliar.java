package entidade;

public class SupervisorAuxiliar extends Pessoa {

	public SupervisorAuxiliar(String cpf, String nome, String email) {
		super(cpf, nome, email);
		// TODO Auto-generated constructor stub
	}

	private String supervisorAuxiliar;
	private String patio;

	public String getPatio() {
		return patio;
	}

	public void setPatio(String patio) {
		this.patio = patio;
	}

	public String getSupervisorAuxiliar() {
		return supervisorAuxiliar;
	}

	public void setSupervisorAuxiliar(String supervisorAuxiliar) {
		this.supervisorAuxiliar = supervisorAuxiliar;
	}

}
