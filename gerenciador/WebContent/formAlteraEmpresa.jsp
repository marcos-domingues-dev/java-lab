<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de empresa</title>
</head>
<body>
	<form action="${linkServletAlteraEmpresa}" method="post">		
		Nome:<input type="text" name="nome" value="${empresa.nome}"/>
		Data abertura:<input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>"/>
		<input type="submit">
	</form>
</body>
</html>