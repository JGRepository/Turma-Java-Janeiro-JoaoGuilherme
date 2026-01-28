package validacao;

import entidade.AssistenteAdministrativo;
import entidade.SupervisorAuxiliar;

public class Validacao {

	
	public static String validaSupervisor(SupervisorAuxiliar supervisorAuxiliar) {
		String mensangemRetorno = null;
		
		if(!supervisorAuxiliar.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		if(!(supervisorAuxiliar.getNome() == null) && supervisorAuxiliar.getNome().isBlank()) {
			mensangemRetorno = "NOME NÃO PODE SER VAZIO!!!";
		}
		
		if(!(supervisorAuxiliar.getEmail() == null) && supervisorAuxiliar.getEmail().isBlank()) {
			mensangemRetorno = "EMAIL NÃO PODE SER VAZIO!!!";
		}
		
		return mensangemRetorno;
		
	}
	public static String validaAssistente(AssistenteAdministrativo assistenteAdministrativo) {
		String mensangemRetorno = null;
		
		if(!assistenteAdministrativo.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		if(!(assistenteAdministrativo.getNome() == null) && assistenteAdministrativo.getNome().isBlank()) {
			mensangemRetorno = "NOME NÃO PODE SER VAZIO!!!";
		}
		
		if(!(assistenteAdministrativo.getEmail() == null) && assistenteAdministrativo.getEmail().isBlank()) {
			mensangemRetorno = "SETOR NÃO PODE SER VAZIO!!!";
		}
		
		return mensangemRetorno;
		
	}

}
