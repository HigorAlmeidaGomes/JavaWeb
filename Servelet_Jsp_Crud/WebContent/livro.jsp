<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Livro</title>
</head>
<body>
	<form method="POST" action="LivroController" name="frmAddLivro">
		Codigo Livro: 
		<input type="text" readonly="readonly" name="livroCodigo" value="${livro.codigo }"/>
		<br/> Titulo:
		<input type="text" name="titulo" value="${livro.titulo}"/>	
		<br/> Autor:
		<input type="text" name="autor" value="${livro.autor}"/>
		<br/>Decri��o
		<input type="text" name="descricao" value="${livro.descricao}"/>
		<br/> Pre�o
		<input type="text" name="preco" value="${livro.preco}"/>
		<br/>
		<input type="submit" value="Submit">
		
	</form>

</body>
</html>