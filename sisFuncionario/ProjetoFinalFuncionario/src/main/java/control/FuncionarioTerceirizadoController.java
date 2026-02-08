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

		String data = request.getParameter("dataNascimento");
		if (data != null && !data.isBlank()) {
			funcionario.setDataNascimento(LocalDate.parse(data));
		}

		String cargo = request.getParameter("funcao");
		if (cargo != null && !cargo.isBlank()) {
			funcionario.setFuncao(CargoTerceirizado.valueOf(cargo));
		}

		String horasTrabalhadas = request.getParameter("horasTrabalhadas");
		if (horasTrabalhadas != null && !horasTrabalhadas.isBlank()) {
			funcionario.setHorasTrabalhadas(Integer.parseInt(horasTrabalhadas));
		}

		String lucro = request.getParameter("lucro");
		if (lucro != null && !lucro.isBlank()) {
			funcionario.setLucro(new BigDecimal(lucro));
		}

		funcionarioTerceirizadoImplements.aplicarCustos(funcionario);

		if (funcionario.getCusto() == null) {
			funcionario.setCusto(BigDecimal.ZERO);
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
