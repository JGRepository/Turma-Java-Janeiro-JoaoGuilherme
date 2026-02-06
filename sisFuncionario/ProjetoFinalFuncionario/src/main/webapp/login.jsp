<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
  <h2>Login do Sistema de Cadastro de Funcionários</h2>

  <%-- Mensagem de erro (se o controller setar) --%>
  <%
    String erro = (String) request.getAttribute("erro");
    if (erro != null) {
  %>
      <p style="color:red;"><%= erro %></p>
  <%
    }
  %>

  <form method="post" action="<%= request.getContextPath() %>/LoginController">
    <label>Usuario:</label>
    <input type="text" name="cpf" required autocomplete="username"><br><br>

    <label>Senha:</label>
    <input type="password" name="senha" required autocomplete="current-password"><br><br>

    <button type="submit">Entrar</button>
  </form>
</body>
</html>
