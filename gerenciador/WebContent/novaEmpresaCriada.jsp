<!DOCTYPE html>
<%
	//scriplet
	String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
	System.out.println(nomeEmpresa);
%>
<html>
<head>
<title>Resultado de - Nova empresa cadastrada</title>
</head>
<body>
	Nova empresa cadastrada: <%=nomeEmpresa%>
</body>
</html>