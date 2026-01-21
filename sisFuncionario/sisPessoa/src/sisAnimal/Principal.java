package sisAnimal;

public class Principal {

	public static void main(String[] args) {
	Animal animal = new Animal("003", "Blue", "Paula");
		
		DaoAnimal daoAnimal = new DaoAnimal();
		daoAnimal.salvarNoBanco(animal);

	}

}
