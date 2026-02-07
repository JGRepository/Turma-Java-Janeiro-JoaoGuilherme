package control;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

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

	public FuncionarioTerceirizadoController() {
		super();
	}

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

		if ("editar".equalsIgnoreCase(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioTerceirizado funcionarioEdit = funcionarioTerceirizadoImplements
					.buscarPorFuncionarioTerceirizado(cpf);
			request.setAttribute("funcionarioTerceirizadoEdit", funcionarioEdit);
		}

		request.setAttribute("listaFuncionariosTerceirizados",
				funcionarioTerceirizadoImplements.listarFuncionarioTerceirizado());
		request.getRequestDispatcher("/funcionarioTerceirizado.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		Random random = new Random();

		FuncionarioTerceirizadoImplements funcionarioTerceirizadoImplements = new FuncionarioTerceirizadoImplements();

		FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado();
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setEmpresa(request.getParameter("empresa"));
		funcionario.setNome(request.getParameter("nome"));

		String dataStr = request.getParameter("dataNascimento");
		if (dataStr != null && !dataStr.isBlank()) {
			funcionario.setDataNascimento(LocalDate.parse(dataStr));
		}

		String cargoStr = request.getParameter("funcao");
		if (cargoStr != null && !cargoStr.isBlank()) {
			funcionario.setFuncao(CargoTerceirizado.valueOf(cargoStr));
		}

		String horasStr = request.getParameter("horasTrabalhadas");
		if (horasStr != null && !horasStr.isBlank()) {
			funcionario.setHorasTrabalhadas(Integer.parseInt(horasStr));
		}

		if (!"editar".equalsIgnoreCase(acao)) {
			funcionario.setSenha((Integer.toString(random.nextInt(100, 999999))));
		}

		if ("editar".equalsIgnoreCase(acao)) {
			funcionarioTerceirizadoImplements.editarFuncionarioTerceirizado(funcionario);
		} else {
			funcionarioTerceirizadoImplements.salvarFuncionarioTerceirizado(funcionario);
		}

		response.sendRedirect(request.getContextPath() + "/FuncionarioTerceirizadoController");
	}
}
