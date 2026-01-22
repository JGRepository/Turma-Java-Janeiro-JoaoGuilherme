package entidade;

public class AssistenteAdministrativo extends Pessoa {
	
	 public AssistenteAdministrativo(String cpf, String nome, String email) {
		super(cpf, nome, email);
		// TODO Auto-generated constructor stub
	}

	private String assistenteAdministrativo;
	 private String escritorio;

	public String getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(String escritorio) {
		this.escritorio = escritorio;
	}

	public String getAssistenteAdministrativo() {
		return assistenteAdministrativo;
	}

	public void setAssistenteAdministrativo(String assistenteAdministrativoString) {
		this.assistenteAdministrativo = assistenteAdministrativoString;
	}

}
