package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.UsuarioLoginImplements;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();

		}

		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");

		if (cpf == null || cpf.isBlank() || senha == null || senha.isBlank()) {
			request.setAttribute("erro", "Preencha CPF e senha.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		UsuarioLoginImplements usuarioLoginImplements = new UsuarioLoginImplements();
		boolean autenticado = usuarioLoginImplements.loginUsuario(cpf, senha);

		if (autenticado) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuarioLogado", cpf);

			response.sendRedirect(request.getContextPath() + "/home.jsp");
			return;
		}

		request.setAttribute("erro", "CPF ou senha inválidos.");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
