<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.FuncionarioTerceirizado" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FUNCIONÁRIO TERCEIRIZADO</title>
</head>
<body>

    <h2>FUNCIONÁRIO TERCEIRIZADO</h2>

    <%
        Object usuario = session.getAttribute("usuarioLogado");
        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <%
        FuncionarioTerceirizado funcionarioEdit =
            (FuncionarioTerceirizado) request.getAttribute("funcionarioTerceirizadoEdit");

        boolean editando = (funcionarioEdit != null);
        String acaoForm = editando ? "editar" : "salvar";

        String cpfValue = editando ? funcionarioEdit.getCpf() : "";
        String nomeValue = editando ? funcionarioEdit.getNome() : "";

        String dataNascimentoValue = "";
        if (editando && funcionarioEdit.getDataNascimento() != null) {
            dataNascimentoValue = funcionarioEdit.getDataNascimento().toString(); // yyyy-MM-dd
        }

        String funcaoValue = (editando && funcionarioEdit.getFuncao() != null)
            ? funcionarioEdit.getFuncao().name()
            : "";

        String empresaValue = editando ? funcionarioEdit.getEmpresa() : "";

        String horasValue = "";
        if (editando) {
            horasValue = String.valueOf(funcionarioEdit.getHorasTrabalhadas());
        }
    %>

    <form method="post" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController">
        <input type="hidden" name="acao" value="<%= acaoForm %>">

        <label>DIGITE O CPF:</label><br>
        <input type="text" name="cpf" <%= editando ? "readonly" : "" %> value="<%= cpfValue %>" required><br>

        <label>DIGITE O NOME:</label><br>
        <input type="text" name="nome" value="<%= nomeValue %>" required><br>

        <label>DATA DE NASCIMENTO:</label><br>
        <input type="date" name="dataNascimento" value="<%= dataNascimentoValue %>" required><br>

        <label>FUNÇÃO:</label><br>
        <select name="funcao" required>
            <option value="">Selecione</option>
            <option value="AUX_SERVICOS_GERAIS" <%= "AUX_SERVICOS_GERAIS".equals(funcaoValue) ? "selected" : "" %>>
                AUX_SERVICOS_GERAIS
            </option>
            <option value="ENCARREGADO" <%= "ENCARREGADO".equals(funcaoValue) ? "selected" : "" %>>
                ENCARREGADO
            </option>
            <option value="AJUDANTE" <%= "AJUDANTE".equals(funcaoValue) ? "selected" : "" %>>
                AJUDANTE
            </option>
        </select>
        <br>

        <label>EMPRESA:</label><br>
        <input type="text" name="empresa" value="<%= empresaValue %>" required><br>

        <label>HORAS TRABALHADAS:</label><br>
        <input type="number" name="horasTrabalhadas" value="<%= horasValue %>" required min="0"><br>

        <br><br>
        <button type="submit"><%= editando ? "Alterar" : "Salvar" %></button>
    </form>

    <h3>LISTA DE FUNCIONÁRIOS TERCEIRIZADOS</h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>CPF</th>
            <th>NOME</th>
            <th>DATA NASCIMENTO</th>
            <th>FUNÇÃO</th>
            <th>EMPRESA</th>
            <th>HORAS</th>
            <th>AÇÕES</th>
        </tr>

        <%
            List<FuncionarioTerceirizado> lista =
                (List<FuncionarioTerceirizado>) request.getAttribute("listaFuncionariosTerceirizados");

            if (lista != null) {
                for (FuncionarioTerceirizado f : lista) {
        %>
        <tr>
            <td><%= f.getCpf() %></td>
            <td><%= f.getNome() %></td>
            <td><%= f.getDataNascimento() %></td>
            <td><%= f.getFuncao() %></td>
            <td><%= f.getEmpresa() %></td>
            <td><%= f.getHorasTrabalhadas() %></td>
            <td>
                <form method="get" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController"
                      style="display:inline;">
                    <input type="hidden" name="acao" value="deletar">
                    <input type="hidden" name="cpf" value="<%= f.getCpf() %>">
                    <button type="submit" onclick="return confirm('Tem certeza que deseja deletar?');">
                        Deletar
                    </button>
                </form>

                <form method="get" action="<%= request.getContextPath() %>/FuncionarioTerceirizadoController"
                      style="display:inline;">
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
