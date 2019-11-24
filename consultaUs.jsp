<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Consulta</title>
</head>
<body>
	<h3>Consulta personalizada</h3>
	<p>Por favor escribe aquí tus sintomas</p>
	<form method="post" action="./ConsultaUs">
		<textarea maxlength="550" rows="10" cols="50" name="consultaTx"></textarea>
		<br>
		<input type="submit" value="Enviar" id="button">
	</form>
</body>
</html>
