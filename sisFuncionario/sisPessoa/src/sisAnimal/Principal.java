package sisAnimal;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Animal animalInsert = new Animal("003", "Blue", "Paula");
		Animal animalUpdate = new Animal("003", "Cenoura", "Joao");
		Animal animalDelete = new Animal("003", null, null);

		DaoAnimal daoAnimal = new DaoAnimal();

		String opcaoQuery;


		do {
			opcaoQuery = JOptionPane.showInputDialog("Digite [I] para INSERT, [U] para UPDATE e [D] para DELETE");
			
			if (opcaoQuery.equalsIgnoreCase("I")) {
				daoAnimal.salvarNoBanco(animalInsert, "INSERT");
				
			} else if (opcaoQuery.equalsIgnoreCase("U")) {
				daoAnimal.salvarNoBanco(animalUpdate, "UPDATE");
				
			} else if (opcaoQuery.equalsIgnoreCase("D")) {
				daoAnimal.salvarNoBanco(animalUpdate, "DELETE");
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, selecione alguma opção válida.");
			
			}
		
		} while (!opcaoQuery.equalsIgnoreCase("I") && !opcaoQuery.equalsIgnoreCase("U") && !opcaoQuery.equalsIgnoreCase("D"));
	}
}


