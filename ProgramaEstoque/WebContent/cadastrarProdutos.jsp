<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
<title>CadastroProduto</title>
</head>
<body>	
<div class="col-sm-11">
		<div class="panel panel-primary">
		  <div class="panel-heading">CadastroProduto</div>
			 <div class="panel-body">
				
				<form method="POST" action="produtoController" name="frmAddProduto">
					Codigo produto: 
					<input type="text" readonly="readonly" name="produtoCodigo" value="${produto.codigo}"/>
					<br/> Nome:
					<input type="text" name="nome" value="${produto.nome}"/>	
					<br/> Descrica:
					<input type="text" name="descricao" value="${produto.descricao}"/>
					<br/>Quantidade
					<input type="text" name="quantidade" value="${produto.quantidade}"/>
					<br/> Valor
					<input type="text" name="valor" value="${produto.valor}"/>
					<br/>
					<input type="submit" value="Submit">
				</form>
				
	
		<div id="Resultado"></div>
	  </div>
	</div>
</div>
</body>
</html>