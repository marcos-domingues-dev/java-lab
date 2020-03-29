<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de empresa</title>
</head>
<body>

    <!-- Os inputs do form ser�o enviados ao servidor  -->
    <!-- L�, eles ser�o resgatados como 'par�metros' -->
    <!--   request.getParameter("id") -->
    
	<form action="${linkEntradaServlet}" method="post">		
		Nome:<input type="text" name="nome" value="${empresa.nome}"/>
		Data abertura:<input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>"/>
		<input type="hidden" name="id" value="${empresa.id}" />
    	<input type="hidden" name="acao" value="AlterarEmpresa">
		<input type="submit">
	</form>
</body>
</html>