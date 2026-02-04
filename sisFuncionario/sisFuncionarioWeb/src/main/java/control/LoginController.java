package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SupervisorAuxiliar;
import repository.RepositorioAssistenteImplementacao;
import repository.RepositorioSupervisorImplementacao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
	
		
		
		if ("admin".equals(cpf) && "123".equals(senha)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", cpf);
			response.sendRedirect(request.getContextPath() + "/Home.jsp");
					
		}else {
			response.sendRedirect(request.getContextPath() + "/Erro.jsp");
		}
	}

}
