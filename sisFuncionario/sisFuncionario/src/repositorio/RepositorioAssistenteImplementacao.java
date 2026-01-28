package repositorio;

import java.util.List;

import bancoDados.dao.DaoAssistente;
import entidade.AssistenteAdministrativo;

public class RepositorioAssistenteImplementacao implements RepositorioAssistente {

	@Override
	public boolean salvarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		assistenteAdministrativo.setNome(metodoUpercase(assistenteAdministrativo.getNome()));
		assistenteAdministrativo.setEmail(metodoUpercase(assistenteAdministrativo.getEmail()));
		return DaoAssistente.salvarAssistente(assistenteAdministrativo);
	}

	@Override
	public List<AssistenteAdministrativo> listarAssistente() {
		return DaoAssistente.listarAssistenteAdministrativo();
	}

	@Override
	public boolean alterarAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		assistenteAdministrativo.setNome(metodoUpercase(assistenteAdministrativo.getNome()));
		assistenteAdministrativo.setEmail(metodoUpercase(assistenteAdministrativo.getEmail()));
		return DaoAssistente.alterarAssistente(assistenteAdministrativo);
	}

	@Override
	public boolean deletarAssistente(String cpf) {

		return DaoAssistente.deletarAssistente(cpf);
	}

	public String metodoUpercase(String texto) {

		return texto.toUpperCase();
	}

}