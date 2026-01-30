package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SupervisorAuxiliar;
import repository.RepositorioSupervisorImplementacao;

/**
 * Servlet implementation class GerenteController
 */
@WebServlet("/SupervisorController")
public class SupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
        String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");
		
		//SE FOR DELETAR
		if("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			repositorioSupervisorImplementacao.deletarSupervisor(cpf);
			
		}
        
        
        request.setAttribute("listaSupervisor", repositorioSupervisorImplementacao.listarSupervisor());
        request.getRequestDispatcher("/Supervisor.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();
		supervisorAuxiliar.setCpf(request.getParameter("cpf"));
		supervisorAuxiliar.setNome(request.getParameter("nome"));
		supervisorAuxiliar.setEmail(request.getParameter("email"));
		RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
		repositorioSupervisorImplementacao.salvarSupervisor(supervisorAuxiliar);
		response.sendRedirect(request.getContextPath()+"/SupervisorController");
	}

}
