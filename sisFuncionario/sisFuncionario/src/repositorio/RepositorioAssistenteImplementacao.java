 package repositorio;

import java.util.List;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;

public class RepositorioAssistenteImplementacao implements RepositorioAtendente {

	DaoAssistente daoAssistente = new DaoAssistente();
	
	@Override
	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		return daoAssistente.salvarAssistente(assistenteAdministrativo, null);
	}

	@Override
	public List<AssistenteAdministrativo> listarAssistente() {
		return daoAssistente.listarAssistenteAdministrativo();
	}


	

}