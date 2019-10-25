<!DOCTYPE html>
<%@ tablib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil</title>
        <link href="css/resetCss.css" rel ="stylesheet">
        <link href="css/profile.css" rel ="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
        <nav role="navigation">
          <div id="menuToggle">
            <input type="checkbox" />
            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
              <a href="#"><li>Home</li></a>
              <a href="#"><li>About</li></a>
              <a href="#"><li>Info</li></a>
              <a href="#"><li>Contact</li></a>
            </ul>
          </div>
        </nav>

        <div id="welcomeUser">
            <img id="profilePic" src="img/profile-icon.svg">
        </div>
        <div id="userInfo">
            <div id="basicInfo">
                <p>Nombre:</p><br><br>
                <p>Apellido:</p><br><br>
                <p>Correo:</p><br><br>
                <p>Contraseña:</p><br><br>
                <p>Fecha de nacimiento:</p><br><br>

            </div>
            <div id="personalInfo">
                <p>Rafael</p><br><br>
                <p>Rojas Obregón</p><br><br>
                <p>rafael@rojas.com</p><br><br>
                <p>················</p><br><br>
                <p>26 de noviembre de 1997</p><br><br>

            </div>
        </div>  
        <div id="editProfile">
            <button id="editButton"> Editar Perfil </button>
        </div>
    </body>
</html>