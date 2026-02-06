package repository;

import dao.DaoLogin;

public class UsuarioLoginImplements implements UsuarioLogin {

	@Override
	public boolean loginUsuario(String cpf, String senha) {
		return DaoLogin.autenticar(cpf, senha);
	}

}
