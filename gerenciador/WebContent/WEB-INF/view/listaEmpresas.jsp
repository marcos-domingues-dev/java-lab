<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas</title>
</head>
<body>

    <c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>

	Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>
				<a href="/gerenciador/entrada?acao=MostrarEmpresa&id=${empresa.id}">Alterar</a>
				<a href="/gerenciador/entrada?acao=RemoverEmpresa&id=${empresa.id}">Remover</a>
				</li>
		</c:forEach>
	</ul>
</body>
</html>