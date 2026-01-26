package repositorio;

import java.util.List;

import entidade.AssistenteAdministrativo;

public interface RepositorioAtendente {

	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) ;
	public List<AssistenteAdministrativo> listarAssistente ();
}
