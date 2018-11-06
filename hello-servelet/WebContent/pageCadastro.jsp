<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	function enviarCadastro(nome, profissao,salario) {
		var url = "HelloServelt?nome=" + nome.value + "&profissao="
				+ profissao.value+ "&salario="+salario.value
				
				console.log(url)
		var xmlhttp = new XMLHttpRequest();

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == XMLHttpRequest.DONE) { // XMLHttpRequest.DONE == 4
				if (xmlhttp.status == 200) {
					document.getElementById("Resultado").innerHTML = xmlhttp.responseText;
				}
			}
		};

		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
<title>TESTE 7</title>


</head>
<body>
	<div class="col-sm-11">
		<div class="panel panel-primary">
			<div class="panel-heading">Cadastro</div>
			<div class="panel-body">


				<form method="get"
					onsubmit="enviarCadastro(nome,profissao,salario); return false;">
					<div class="row">
						<fieldset>

							<div class="form-group">
								<label for="nome">Nome</label> <input type="text"
									class="form-control" name="nome" id="nome" autofocus required>
							</div>


							<div class="form-group">
								<label for="login">Profissão</label> <input type="text"
									class="form-control" name="profissao" id="profissao" required>
							</div>

							<div class="form-group">
								<label for="login">Salario</label> <input type="text"
									class="form-control" name="salario" id="salario" required>
							</div>


						</fieldset>
					</div>
					<input type="submit" name="salvar" class="btn btn-primary">
				</form>
				<div id="Resultado"></div>

			</div>
		</div>
</body>
</html>