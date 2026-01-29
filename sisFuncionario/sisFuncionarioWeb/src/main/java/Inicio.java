
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String titulo = "<h2>Formulário JAVA</h2>";

		String html = "<!DOCTYPE html>" + "<html lang='pt-br'>" + "<head>" + "  <meta charset='UTF-8'>"
				+ "  <title>Metodo GET/POST</title>" + "</head>" + "<body style='font-family: Arial; padding: 20px;'>" +

				titulo +

				"  <form method='post' action='" + request.getContextPath() + "/Inicio'>"
				+ "    <label>Digite o Nome:</label><br>" + "    <input type='text' name='nome' required>" +"<br>"+"<br>"
				+ "    <label>Digite o CPF:</label><br>" + "    <input type='text' name='cpf' required>"+"<br>"+"<br>"
				+ "    <label>Digite o Email:</label><br>" + "    <input type='text' name='email' required>"+"<br>"
				+ "    <br><br>" + "    <button type='submit'>Enviar</button>" + "  </form>" +

				"</body>" + "</html>";

		response.getOutputStream().write(html.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String nomeCadastrado = "Nome Cadastrado foi:" + request.getParameter("nome") + "<br>";
		String cpfCadastrado = "CPF Cadastrado foi:" + request.getParameter("cpf") + "<br>";
		String emailCadastrado = "Email Cadastrado foi:" + request.getParameter("email") + "<br>";

		response.getOutputStream().write(nomeCadastrado.getBytes(StandardCharsets.UTF_8));
		response.getOutputStream().write(cpfCadastrado.getBytes(StandardCharsets.UTF_8));
		response.getOutputStream().write(emailCadastrado.getBytes(StandardCharsets.UTF_8));
	}

}
