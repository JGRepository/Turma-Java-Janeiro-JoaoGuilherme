package repository;

import java.util.List;

import model.AssistenteAdministrativo;

public interface RepositorioAssistente {

	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) ;
	public List<AssistenteAdministrativo> listarAssistente ();
	
	public boolean alterarAssistente (AssistenteAdministrativo assistenteAdministrativo);
	
	public boolean deletarAssistente(String cpf);
	
	
}
