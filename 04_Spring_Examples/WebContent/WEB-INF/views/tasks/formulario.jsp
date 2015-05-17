<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Add tasks</h3>
	<form action="adicionaTarefa" method="post">
		   Description: <br />
	    <textarea name="description" rows="5" cols="100"></textarea><br />
	    <form:errors path="task.description" cssStyle="color:red"/><br />
	    
	    <input type="submit" value="Adicionar">
	</form>

</body>
</html>