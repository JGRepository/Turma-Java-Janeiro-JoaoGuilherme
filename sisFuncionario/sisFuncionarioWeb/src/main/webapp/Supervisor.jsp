<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.FuncionarioTerceirizado"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
p
 String usuario = (String)session.getAttribute("usuarioLogado");  


if(usuario == null){
	response.sendRedirect("Login.jsp");
	return;
}
%>
<title>SUPERVISOR</title>
</head>
<body>

	<h2>SUPERVISOR</h2>

	<form method="post"
		action="<%=t(request.getContextPath%>/SupervisorController">
		<label>DIGITE O NOME:</label><br> <input type="text" name="nome"
			required><br> <label>DIGITE O CPF:</label><br> <input
			type="text" name="cpf" required><br> <label>DIGITE
			O EMAIL:</label><br> <input type="text" name="email" required><br>



		<br>
		<br>
		<button type="submit" name="acao" value="enviar">ENVIAR</button>
		<button type="submit" name="acao" value="alterar">ALTERAR</button>



	</form>




	<h3>LISTA DE SUPERVISOR</h3>

	<table border="1" cellpadding="5">
		<tr>
			<th>NOME</th>
			<th>CPF</th>
			<th>EMAIL</th>
			<th>ACAO</th>

		</tr>

		<%
		p

				List<FuncionarioTerceirizado> lista = (List<FuncionarioTerceirizado>) request.getAttribute("listaSupervisor");

				if (lista != null) {
			for (FuncionarioTerceirizado supervisores : lista) {
		%>
		<tr>
			<td><%=supervisores.getNome()%></td>
			<td><%=supervisores.getCpf()%></td>
			<td><%=supervisores.getEmail()%></td>
			<td>
				<form method="get"
					action="<%=request.getContextPath()%>/SupervisorController"
					style="display: inline;">
					<input type="hidden" name="acao" value="deletar"> <input
						type="hidden" name="cpf" value="<%=supervisores.getCpf()%>">
					<button type="submit"
						onclick="return confirm('Tem certeza que deseja deletar?');">DELETAR</button>

				</form>

			</td>
		</tr>
		<%
		}
		}
		%>
	</table>


</body>
</html>