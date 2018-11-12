<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livro</title>
</head>
<body>
	<table border=1">
		<thead>
			<tr>
				<th>Codigo Livro</th>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Descricao</th>
				<th>Preco</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${livros}" var="livro">
				<tr>
					<td><c:out value="${livro.codigo}" /></td>
					<td><c:out value="${livro.titulo}" /></td>
					<td><c:out value="${livro.autor}" /></td>
					<td><c:out value="${livro.descricao}" /></td>
					<td><c:out value="${livro.preco}" /></td>
					<td><a
						href="LivroController?action=editar&livroId=${livro.codigo }">Update</a></td>
					<td><a
						href="LivroController?action=deletar&livroId=${livro.codigo }">Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="LivroController?action=inserir">Livro</a>
	</p>
</body>
</html>