package control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioTerceirizado;
import model.enums.CargoTerceirizado;
import repository.FuncionarioTerceirizadoImplements;

@WebServlet("/FuncionarioTerceirizadoController")
public class FuncionarioTerceirizadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FuncionarioTerceirizadoImplements funcionarioTerceirizadoImplements = new FuncionarioTerceirizadoImplements();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equalsIgnoreCase(acao) && cpf != null && !cpf.isEmpty()) {
			funcionarioTerceirizadoImplements.deletarFuncionarioTerceirizado(cpf);
		}

		request.setAttribute("listaFuncionariosTerceirizados",
				funcionarioTerceirizadoImplements.listarFuncionarioTerceirizado());
		request.getRequestDispatcher("/FuncionarioTerceirizadoCrud.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
		funcionarioTerceirizado.setCpf(request.getParameter("cpf"));
		funcionarioTerceirizado.setNome(request.getParameter("nome"));

		String dataStr = request.getParameter("dataNascimento");
		if (dataStr != null && !dataStr.isBlank()) {
			funcionarioTerceirizado.setDataNascimento(LocalDate.parse(dataStr));
		}

		String funcaoStr = request.getParameter("funcao");
		if (funcaoStr != null && !funcaoStr.isBlank()) {
			funcionarioTerceirizado.setFuncao(CargoTerceirizado.valueOf(funcaoStr));
		}
		funcionarioTerceirizado.setEmpresa(request.getParameter("empresa"));

		String horasStr = request.getParameter("horasTrabalhadas");
		if (horasStr != null && !horasStr.isBlank()) {
			funcionarioTerceirizado.setHorasTrabalhadas(Integer.parseInt(horasStr));
		}

		FuncionarioTerceirizadoImplements funcionarioTerceirizadoImplements = new FuncionarioTerceirizadoImplements();
		funcionarioTerceirizadoImplements.salvarFuncionarioTerceirizado(funcionarioTerceirizado);

		response.sendRedirect(request.getContextPath() + "/FuncionarioTerceirizadoController");
	}
}
