package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioInterno;
import model.enums.CargoInterno;
import repository.FuncionarioInternoImplements;

@WebServlet("/FuncionarioInternoController")
public class FuncionarioInternoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioInternoController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FuncionarioInternoImplements funcionarioInternoImplements = new FuncionarioInternoImplements();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equalsIgnoreCase(acao) && cpf != null && !cpf.isEmpty()) {
			funcionarioInternoImplements.deletarFuncionarioInterno(cpf);
		}

		if ("editar".equalsIgnoreCase(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioInterno funcionarioEdit = funcionarioInternoImplements.buscarPorFuncionarioInterno(cpf);
			request.setAttribute("funcionarioEdit", funcionarioEdit);
		}

		request.setAttribute("listaFuncionariosInternos", funcionarioInternoImplements.listarFuncionarioInterno());
		request.getRequestDispatcher("/funcionarioInterno.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		Random random = new Random();

		FuncionarioInternoImplements funcionarioInternoImplements = new FuncionarioInternoImplements();

		FuncionarioInterno funcionario = new FuncionarioInterno();
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setMatricula(request.getParameter("matricula"));
		funcionario.setNome(request.getParameter("nome"));

		String dataStr = request.getParameter("dataNascimento");
		if (dataStr != null && !dataStr.isBlank()) {
			funcionario.setDataNascimento(LocalDate.parse(dataStr));
		}

		String cargoStr = request.getParameter("cargo");
		if (cargoStr != null && !cargoStr.isBlank()) {
			funcionario.setCargo(CargoInterno.valueOf(cargoStr));
		}

		String salarioStr = request.getParameter("salario");
		if (salarioStr != null && !salarioStr.isBlank()) {
			funcionario.setSalario(new BigDecimal(salarioStr));
		}

		if (!"editar".equalsIgnoreCase(acao)) {
			funcionario.setSenha((Integer.toString(random.nextInt(100, 999999))));
		}

		if ("editar".equalsIgnoreCase(acao)) {
			funcionarioInternoImplements.editarFuncionarioInterno(funcionario);
		} else {
			funcionarioInternoImplements.salvarFuncionarioInterno(funcionario);
		}

		response.sendRedirect(request.getContextPath() + "/FuncionarioInternoController");
	}
}
