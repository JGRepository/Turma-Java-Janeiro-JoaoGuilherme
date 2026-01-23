package entidade;

public class AssistenteAdministrativo extends Pessoa {
	
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
