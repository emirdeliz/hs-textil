package br.com.hs.sistema.constant;

public class Email {
	
	public static String ASSUNTO_FORNECEDOR_TEMPLATE = "Cotação Material";
	
	public static String ASSUNTO_CLIENTE_TEMPLATE = "Promoção HS Têxtil";
	
	public static String MSG_FORNECEDOR_TEMPLATE = 
		"<html>"+
			"<head>"+
			"<title>::: HS Têxtil :::</title>"+
			"<style>"+
			"a:link {"+
				"color: #046380;"+
				"text-decoration: underline;"+
			"}"+															
			"a:visited {"+
				"color: #A7A37E;"+
				"text-decoration: none;"+
			"}"+															
			"a:hover {"+
				"color: #002F2F;"+
				"text-decoration: underline;"+
			"}"+															
			"a:active {"+
				"color: #046380;"+
				"text-decoration: none;"+
			"}"+
			"</style>"+
			"</head>"+
			"<body>"+			
			"<table align='center' width='700px' cellpadding='0' cellspacing='0'>"+
				"<tr>"+
					"<td bgcolor='#efefef' style='border-bottom: #666666 1px solid;'><br>"+
					"<table border='0' align='center'>"+
						"<tr>"+
							"<td style='font-family: ar julian; font-size: 50px; color: #6F7900;'>HS Têxtil</td>"+
						"</tr>"+
					"</table>"+
					"<br>"+
					"</td>"+
				"</tr>"+
				"<tr>"+
					"<td>"+
					"<table width='510' border='0' cellpadding='0' cellspacing='0'"+
						"align='center' height='100%'>"+
						"<tr>"+
							"<td>"+
							"<p style='font-family: verdana; font-size: 25px; color: #783200;'><br>"+
							"Cotação</p>"+
							"<p style='font-family: verdana; font-size: 12px; color: #192A38; text-align: justify;'>"+
							"Olá, <br>"+
							"<br>"+
							"Tudo bem?<br>"+
							"<br>"+
							"Você esta recebendo este e-mail da empresa HSTêxtil porque "+
							"necessitamos do seguinte material em nosso estoque <strong>_material_</strong>. Se "+
							"possível gostaríamos que você acessasse nosso portal e informasse a "+
							"cotação para o mesmo. Para acessar o portal você deverá informar o "+
							"usuário: _usuario_ e a senha: 123. O endereço do portal é <span"+
								" style='text-decoration: underline;'>www.hstextil.com.br.</span><br>"+
							"<br>"+
							"Grato desde já,</p>"+
						"</tr>"+
						"<tr>"+
							"<td><span style='font-family: verdana; color: #787878'>"+
							"<strong> <span style='font-size: xx-small;'>HS"+
							"Têxtil</span> </strong> <span style='font-size: xx-small;'><br>"+
							"<strong>Tel: </strong>(47) 3465-1025<br>"+
							"<strong>Endereços:</strong> Rua Chico Mendes, 53 - Itinga -"+
							"Joinville - SC<br>"+
							"<strong>Web:</strong> <span style='color: #666666'> <span"+
								"style='text-decoration: underline;'>www.hstextil.com.br</span></span> <br>"+							
							"<span style='font-size: xx-small;'><i>O homem é trabalhador. Se não é isto então não"+
							"é nada.(Joseph Conrad)</i></span></span></span>"+
							"</p>"+
							"</td>"+
						"</tr>"+
					"</table>"+
			"</table>"+															
			"</body>"+
		"</html>";		

	public static String MSG_CLIENTE_TEMPLATE = 
		"<html>"+
			"<head>"+
			"<title>::: HS Têxtil :::</title>"+
			"<style>"+
			"a:link {"+
				"color: #046380;"+
				"text-decoration: underline;"+
			"}"+															
			"a:visited {"+
				"color: #A7A37E;"+
				"text-decoration: none;"+
			"}"+															
			"a:hover {"+
				"color: #002F2F;"+
				"text-decoration: underline;"+
			"}"+															
			"a:active {"+
				"color: #046380;"+
				"text-decoration: none;"+
			"}"+
			"</style>"+
			"</head>"+
			"<body>"+			
			"<table align='center' width='700px' cellpadding='0' cellspacing='0'>"+
				"<tr>"+
					"<td bgcolor='#efefef' style='border-bottom: #666666 1px solid;'><br>"+
					"<table border='0' align='center'>"+
						"<tr>"+
							"<td style='font-family: ar julian; font-size: 50px; color: #6F7900;'>HS Têxtil</td>"+
						"</tr>"+
					"</table>"+
					"<br>"+
					"</td>"+
				"</tr>"+
				"<tr>"+
					"<td>"+
					"<table width='510' border='0' cellpadding='0' cellspacing='0'"+
						"align='center' height='100%'>"+
						"<tr>"+
							"<td>"+
							"<p style='font-family: verdana; font-size: 25px; color: #783200;'><br>"+
							"Nova Promoção</p>"+
							"<p style='font-family: verdana; font-size: 12px; color: #192A38; text-align: justify;'>"+
							"Olá, <br>"+
							"<br>"+
							"Tudo bem?<br>"+
							"<br>"+
							"_msg_"+
							"<br><br>"+
							"Grato desde já,</p>"+
						"</tr>"+
						"<tr>"+
							"<td><span style='font-family: verdana; color: #787878'>"+
							"<strong> <span style='font-size: xx-small;'>HS"+
							"Têxtil</span> </strong> <span style='font-size: xx-small;'><br>"+
							"<strong>Tel: </strong>(47) 3465-1025<br>"+
							"<strong>Endereços:</strong> Rua Chico Mendes, 53 - Itinga -"+
							"Joinville - SC<br>"+
							"<strong>Web:</strong> <span style='color: #666666'> <span"+
								"style='text-decoration: underline;'>www.hstextil.com.br</span></span> <br>"+							
							"<span style='font-size: xx-small;'><i>O homem é trabalhador. Se não é isto então não"+
							"é nada.(Joseph Conrad)</i></span></span></span>"+
							"</p>"+
							"</td>"+
						"</tr>"+
					"</table>"+
			"</table>"+															
		"</body>"+
	"</html>";
}
