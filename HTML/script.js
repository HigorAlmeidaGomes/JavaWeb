
		function myFunction(){
			document.getElementById("demo2").innerHTML = "Paragraph changed. ";
		}
		function alterarTamanha(){
			var tamanhoFonte = document.getElementById('demo').style.fontSize;
			console.log(tamanhoFonte);
			if(tamanhoFonte == "50px"){
				document.getElementById('demo').style.fontSize="30px";
				document.getElementById('demo2').style.fontSize="30px";
			}
			else{
				document.getElementById('demo').style.fontSize="50px";
				document.getElementById('demo2').style.fontSize="50px";
			}
		}