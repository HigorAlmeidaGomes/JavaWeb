<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de livros</title>
</head>
<body>
	
	<c:out value="${sessionScope.userName }"></c:out>
	<table class="table">
		<td><label>Titulo</label></td>
		<td><label>Autor</label></td>
		<td><label>Descrição</label></td>


		<c:forEach items="${requestScope.listarLivros}" var="livro">
			<tr>
				<td><c:out value="${livro.titulo }"></c:out></td>
				<td><c:out value="${livro.autor }"></c:out></td>
				<td><c:out value="${livro.descricao }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>