<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
	<link href="css/tablasChat.css" rel ="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>

	<header>
	<nav role="navigation">
		<div id="menuToggle">
			<input type="checkbox" />
			<span></span>
			<span></span>
			<span></span>

			<ul id="menu">
				<a href="./landingUsers.jsp"><li>Inicio</li></a>
				<a href="ProgramarRecordatorio"><li>Programar Recordatorio</li></a>
				<a href="TransitionServlet"><li>Consulta un médico</li></a>
				<a href="TransitionRespuesta"><li>Ver Respuesta</li></a>
				<a href="Logout"><li>Cerrar Sesión</li></a>
			</ul>
		</div>
	</nav>
	</header>

	<form action="./landingUsers.jsp" method="post">
		<table class="pure-table pure-table-horizontal">
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
		<div class="buttoncenter">
				<input type="submit" name="boton" value="siguiente" id="button">
		</div>
	</form>
</body>
</html>
