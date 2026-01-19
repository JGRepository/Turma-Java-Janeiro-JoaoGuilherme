package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.AssistenteAdministrativo;
import entidade.SupervisorAuxiliar;

public class ManipuladorArquivo {
	
	public boolean registrarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {
		
		String enderecoArquivo = "C:\\GitHub\\Curso_Java\\Aluno\\sisFuncionario\\sisFuncionario\\registroSupervisor.txt";
		
		try {
		
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do Supervisor é: "+ supervisorAuxiliar.getNome() );
			bufferedWriter.newLine();
			bufferedWriter.append("O CPF do supervisor é:" + supervisorAuxiliar.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O email do supervisor é: " + supervisorAuxiliar.getEmail());
			
			bufferedWriter.close();
			
			return true;
			
		
		
		} catch (IOException e) {
			System.out.println("Erro ao salvar o gerente");
			return false;
		}
	
	}
	public boolean registrarAssistenteAdministrativo(AssistenteAdministrativo assistenteAdministrativo) {
		
		String enderecoArquivo = "C:\\GitHub\\Curso_Java\\Aluno\\sisFuncionario\\sisFuncionario\\registroAssistente.txt";
		
		try {
			
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do Assistente é: "+ assistenteAdministrativo.getNome() );
			bufferedWriter.newLine();
			bufferedWriter.append("O CPF do Assistente é:" + assistenteAdministrativo.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O email do Assistente é: " + assistenteAdministrativo.getEmail());
			
			bufferedWriter.close();
			
			return true;
			
			
			
		} catch (IOException e) {
			System.out.println("Erro ao salvar o gerente");
			return false;
		}
		
	}

}