<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Resultado de - Nova empresa cadastrada</title>
</head>
<body>
	<c:if test="${not empty nomeEmpresa}">
            Empresa ${ nomeEmpresa } cadastrada com sucesso!
        </c:if>

	<c:if test="${empty nomeEmpresa}">
            Nenhuma empresa cadastrada!
        </c:if>
</body>
</html>