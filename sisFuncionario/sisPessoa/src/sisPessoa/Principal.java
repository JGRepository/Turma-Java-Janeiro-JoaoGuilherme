package sisPessoa;


public class Principal {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa("011", "Test", "email@email");

		DaoPessoa daoPessoa = new DaoPessoa();
		daoPessoa.salvarNoBanco(pessoa);

	}

}
