<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">

<% String usuario = (String)session.getAttribute("usuarioLogado");  


if(usuario == null){
	response.sendRedirect("Login.jsp");
	return;
}

%>

<title>Bem-vindo ao Sistema</title>
</head>
<body>
<h2>Bem-vindo, <%= usuario %></h2>
<h3>MENU</h3>
<li>
<a href="<%=request.getContextPath()%>/AssistenteController">Gerenciar Atendentes</a><br>
<a href="<%=request.getContextPath()%>/SupervisorController">Gerenciar Supervisores</a><br>

</li>
<a href="<%=request.getContextPath()%>/Login.jsp">Sair do Sistema</a>
</body>
</html>