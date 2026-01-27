package repositorio;

import java.util.List;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;

public class RepositorioAssistenteImplementacao implements RepositorioAssistente {

	@Override
	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		return DaoAssistente.alterarAssistente(assistenteAdministrativo);
	}

	@Override
	public List<AssistenteAdministrativo> listarAssistente() {
		return DaoAssistente.listarAssistenteAdministrativo();
	}

	@Override
	public boolean alterarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		return DaoAssistente.alterarAssistente(assistenteAdministrativo);
	}

	@Override
	public boolean deletarAssistente(String cpf) {
		
		return DaoAssistente.deletarAssistente(cpf);
	}



}