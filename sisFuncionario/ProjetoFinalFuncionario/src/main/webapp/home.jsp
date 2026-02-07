<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.FuncionarioInterno" %>
<%@ page import="model.FuncionarioTerceirizado" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<%
    Object usuario = session.getAttribute("usuarioLogado");

    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String nome = "";
    String cpf = "";
    String tipoUsuario = "";

    if (usuario instanceof FuncionarioInterno) {
        FuncionarioInterno interno = (FuncionarioInterno) usuario;
        nome = interno.getNome();
        cpf = interno.getCpf();
        tipoUsuario = "Funcionário Interno";
    } else if (usuario instanceof FuncionarioTerceirizado) {
        FuncionarioTerceirizado terceiro = (FuncionarioTerceirizado) usuario;
        nome = terceiro.getNome();
        cpf = terceiro.getCpf();
        tipoUsuario = "Funcionário Terceirizado";
    }
%>

</head>
<body>

<h2>Bem-vindo ao Sistema</h2>

<h3>MENU</h3>

<ul>
    <li>
        <a href="<%= request.getContextPath() %>/FuncionarioInternoController">
            Gerenciar Funcionários Internos
        </a>
    </li>

    <li>
        <a href="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
            Gerenciar Funcionários Terceirizados
        </a>
    </li>
</ul>

<br>

<a href="<%= request.getContextPath() %>/LoginController">Sair</a>

</body>
</html>
