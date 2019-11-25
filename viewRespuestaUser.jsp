<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<style>
	table, th, td {
 		 border: 1px solid black;
  		 border-collapse: collapse;
}
	th, td {
 	 padding: 15px;
  	 text-align: center;
}
</style>
</head>
<body>
	<form action="./" method="post">
		<table style="width:100%">
  		<caption>Cuestionarios</caption>
  		<tr>
    		<th>Pregunta</th>
        <th>Respuesta</th>
  		</tr>
  		<c:forEach items="${requestScope.chatList}" var="us">
  			<tr>
  				<td>
  					<c:out value= "${us.mensajeUser}" />
  				</td>
					<td>
  					<c:out value= "${us.respuestaAdmin}" />
  				</td>
			</c:forEach>
		</table>
		<input type="submit" name="boton" value="siguiente">
	</form>
</body>
</html>