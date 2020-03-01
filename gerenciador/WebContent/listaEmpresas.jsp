<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lista de empresas:
	<br />
<ul>
    <%
        List<Empresa> listaEmpresas = (List<Empresa>) request.getAttribute("listaEmpresas");
        for (Empresa empresa : listaEmpresas) {
    %>
        <li><%= empresa.getNome() %></li>
    <%
        }
    %>
</ul>
</body>
</html>