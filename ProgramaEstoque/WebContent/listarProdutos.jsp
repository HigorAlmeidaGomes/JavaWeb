<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
<title>Listar Produto</title>
</head>
<body>
<form class="form-inline" method="get" action="LivroController">
		<input type="text" name = "buscarProduto" class="form-control" id="buscarProduto">
		<input type="submit" value="Buscar" class="btn btn-default">
		<input type="hidden" name="action" value="buscarProduto">
	</form>

	<table class= "table"">
		<thead>
			<tr>
				<th>Codigo Produto</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Quantidade</th>
				<th>Valor</th>
				<th colspan="2">Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><c:out value="${produto.codigo}" /></td>
					<td><c:out value="${produto.nome}" /></td>
					<td><c:out value="${produto.descricao}" /></td>
					<td><c:out value="${produto.quantidade}" /></td>
					<td><c:out value="${produto.valor}" /></td>
					<td><a
						href="produtoController?action=editar&produtoId=${produto.codigo}">Update</a></td>
					<td><a
						href="produtoController?action=deletar&produtoId=${produto.codigo}">Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="produtoController?action=inserir">Cadastrar Produto</a>
	</p>

</body>
</html>