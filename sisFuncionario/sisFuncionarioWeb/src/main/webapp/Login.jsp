<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<h2>LOGIN DO SISTEMA | CADASTRO DE FUNCIONARIO</h2>

<form method="post"  action="<%=request.getContextPath()%>/LoginController">
<label>USUÁRIO</label><br>
<input type="text" name="usuario" required><br><br>

<label>SENHA:</label><br> 
<input type="text" name="senha" required><br><br>

<button type="submit" name="entrar">ENTRAR</button>



</form>

</body>
</html>