<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.FuncionarioInterno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FUNCIONÁRIO INTERNO CRUD</title>
</head>
<body>

    <h2>FUNCIONÁRIO INTERNO CRUD</h2>

    <%
        Object usuario = session.getAttribute("usuarioLogado");
        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <%
        FuncionarioInterno funcionarioEdit = (FuncionarioInterno) request.getAttribute("funcionarioEdit");
        boolean editando = (funcionarioEdit != null);
        String acaoForm = editando ? "editar" : "salvar";

        String cpfValue = editando ? funcionarioEdit.getCpf() : "";
        String matriculaValue = editando ? funcionarioEdit.getMatricula() : "";
        String nomeValue = editando ? funcionarioEdit.getNome() : "";

        // LocalDate -> "yyyy-MM-dd" para preencher input type="date"
        String dataNascimentoValue = "";
        if (editando && funcionarioEdit.getDataNascimento() != null) {
            dataNascimentoValue = funcionarioEdit.getDataNascimento().toString();
        }

        String cargoValue = editando && funcionarioEdit.getCargo() != null ? funcionarioEdit.getCargo().name() : "";
        String salarioValue = editando && funcionarioEdit.getSalario() != null ? funcionarioEdit.getSalario().toString() : "";
    %>

    <form method="post" action="<%= request.getContextPath() %>/FuncionarioInternoController">
        <input type="hidden" name="acao" value="<%= acaoForm %>">

        <label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf" <%= editando ? "readonly" : "" %> value="<%= cpfValue %>" required><br>

        <label>DIGITE A MATRÍCULA:</label><br>
        <input type="text" name="matricula" value="<%= matriculaValue %>" required><br>

        <label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" value="<%= nomeValue %>" required><br>

        <label>DATA DE NASCIMENTO:</label><br>
        <input type="date" name="dataNascimento" value="<%= dataNascimentoValue %>" required><br>

        <label>CARGO:</label><br>
        <select name="cargo" required>
            <option value="">Selecione</option>
            <option value="GERENTE" <%= "GERENTE".equals(cargoValue) ? "selected" : "" %>>GERENTE</option>
            <option value="COORDENADOR" <%= "COORDENADOR".equals(cargoValue) ? "selected" : "" %>>COORDENADOR</option>
            <option value="ASSISTENTE" <%= "ASSISTENTE".equals(cargoValue) ? "selected" : "" %>>ASSISTENTE</option>
        </select>
        <br>

        <label>SALÁRIO:</label><br>
        <input type="text" name="salario" value="<%= salarioValue %>" required placeholder="Ex: 5000.00"><br>

        <br><br>
        <button type="submit"><%= editando ? "Alterar" : "Salvar" %></button>
    </form>

    <h3>LISTA DE FUNCIONÁRIOS INTERNOS</h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>CPF</th>
            <th>MATRÍCULA</th>
            <th>NOME</th>
            <th>DATA NASCIMENTO</th>
            <th>CARGO</th>
            <th>SALÁRIO</th>
            <th>AÇÕES</th>
        </tr>

        <%
            List<FuncionarioInterno> lista = (List<FuncionarioInterno>) request.getAttribute("listaFuncionariosInternos");

            if (lista != null) {
                for (FuncionarioInterno f : lista) {
        %>
        <tr>
            <td><%= f.getCpf() %></td>
            <td><%= f.getMatricula() %></td>
            <td><%= f.getNome() %></td>
            <td><%= f.getDataNascimento() %></td>
            <td><%= f.getCargo() %></td>
            <td><%= f.getSalario() %></td>
            <td>
                <form method="get" action="<%= request.getContextPath() %>/FuncionarioInternoController" style="display:inline;">
                    <input type="hidden" name="acao" value="deletar">
                    <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                    <button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
                        Deletar
                    </button>
                </form>

                <form method="get" action="<%= request.getContextPath() %>/FuncionarioInternoController" style="display:inline;">
                    <input type="hidden" name="acao" value="editar">
                    <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                    <button type="submit">Editar</button>
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
