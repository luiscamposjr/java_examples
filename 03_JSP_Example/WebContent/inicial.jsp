<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.luiscamposjr.model.Contato"%>
<%@page import="br.com.luiscamposjr.dao.ContatoDAO"%>
<%@page import="br.com.luiscamposjr.jdbc.ConnectionFactory"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  

	ContatoDAO contatoDAO = new ContatoDAO();
	List<Contato> lista = new ArrayList<Contato>();
	lista = contatoDAO.getLista();
	
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

%>

<table border="1">
	<% for(Contato contato : lista){ %>
	<tr>
		<td><%= contato.getId() %></td>	
		<td><%= contato.getNome() %></td>	
		<td><%= contato.getEmail() %></td>	
		<td><%= contato.getEndereco() %></td>	
		<td><%= dataFormatada.format(contato.getDataNascimento().getTime()) %></td>	
	</tr>
	<% } %>
</table>




</body>
</html>