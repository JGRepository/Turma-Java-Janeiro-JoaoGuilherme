package repositorio;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;

public class RepositorioAssistenteImplementacao implements RepositorioAtendente {

	DaoAssistente daoAssistente = new DaoAssistente();
	
	@Override
	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		return daoAssistente.salvarAssistente(assistenteAdministrativo, null);
	}


	

}