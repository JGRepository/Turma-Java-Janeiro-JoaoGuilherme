<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="model.AssistenteAdministrativo" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASSISTENTE</title>
</head>
<body>

	<h2>ASSISTENTE</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/AssistenteController">
		<label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" required><br>
        
        <label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf" required><br>
        
         <label>DIGITE O EMAIL:</label><br>
        <input type="text" name="email" required><br>
        
        
        
        <br><br>
        <button type="submit">ENVIAR</button>
	
	
	
	</form>
	<h3>LISTA DE ASSISTENTE</h3>
	
	<table border="1" cellpadding="5">
			<tr>
				<th>CPF</th>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>ACAO</th>
			</tr>

			<%
				List<AssistenteAdministrativo> lista = (List<AssistenteAdministrativo>) request.getAttribute("listaAtendentes");
	
				if (lista != null) {
					for (AssistenteAdministrativo atendentes : lista) {
			%>
				<tr>
					<td><%= atendentes.getCpf() %></td>
					<td><%= atendentes.getNome() %></td>
					<td><%= atendentes.getEmail() %></td>
					<td>
					<form method="get" action="<%= request.getContextPath() %>/AssistenteController"
					style="display:inline;">
					<input type="hidden" name="acao" value="deletar">
					<input type="hidden" name="cpf" value="<%= atendentes.getCpf() %>">
					<button type="submit" onclick="return confirm('Tem certeza que deseja deletar');">DELETAR</button>
					
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