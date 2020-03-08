<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas</title>
</head>
<body>
	Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li>${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>