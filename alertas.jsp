<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %> 

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alerta</title>
        <link href="css/resetCss.css" rel ="stylesheet">
        <link href="css/home.css" rel ="stylesheet">
        <link href="css/alertas.css" rel="stylesheet">
        
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
              <a href="#"><li>Home</li></a>
              <a href="#"><li>About</li></a>
              <a href="#"><li>Info</li></a>
              <a href="#"><li>Contact</li></a>
            </ul>
          </div>
        </nav>
          <img class="header-icons" id="profile-icon" src="img/profile-icon.svg">
        </header>
        
        <div id="bod">
            <div  class="title">
                <h1>Recordatorio</h1>
            </div>
            
          
          <p class="cent">Escoge un número para fijar un recordatorio.</p>

          <ul id="chooseIRPS">
            <button><li>1</li></button>
            <button><li>2</li></button>
            <button><li>3</li></button>
            <button><li>4</li></button>
            <button><li>5</li></button>
            <button><li>6</li></button>
            <button><li>7</li></button>
            <button><li>8</li></button>
            <button><li>9</li></button>
            <button><li>10</li></button>
            <button><li>10+</li></button>
          </ul>

          <p class="cent">Por predeterminado, se manda notificación cuando el IRPS aparece con tu número o superior a él</p>
        </div>
        


    </body>
</html>