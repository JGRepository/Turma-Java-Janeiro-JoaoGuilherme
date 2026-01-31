package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AssistenteAdministrativo;
import repository.RepositorioAssistenteImplementacao;

/**
 * Servlet implementation class AtendenteController
 */
@WebServlet("/AssistenteController")
public class AssistenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssistenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();
		String acao = request.getParameter("acao");
			String cpf = request.getParameter("cpf");
			
			//SE FOR DELETAR
			if("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
				repositorioAssistenteImplementacao.deletarAssistente(cpf);
				
			}
	        
	        
	        request.setAttribute("listaAtendentes", repositorioAssistenteImplementacao.listarAssistente());
	        request.getRequestDispatcher("/Assistente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();
		assistenteAdministrativo.setCpf(request.getParameter("cpf"));
		assistenteAdministrativo.setNome(request.getParameter("nome"));
		assistenteAdministrativo.setEmail(request.getParameter("email"));
		
		RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();
		repositorioAssistenteImplementacao.salvarAssistente(assistenteAdministrativo);
		response.sendRedirect(request.getContextPath()+"/AssistenteController");

	}

}
