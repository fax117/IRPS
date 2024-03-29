import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CuestionarioDiarioBoton")
public class CuestionarioDiarioServlet extends HttpServlet{

	public void init(ServletConfig config){
		try{
			super.init(config);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try{

			String dbbase = getServletContext().getInitParameter("base");
			String dbusuario = getServletContext().getInitParameter("usuario");
			String dbpassword = getServletContext().getInitParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+dbbase+"?useSSL=false&allowPublicKeyRetrieval=true";
			Connection con = DriverManager.getConnection(url,dbusuario,dbpassword);
			Statement stat = con.createStatement();

			Cookie[] cookies = request.getCookies();
			ResultSet res1 = stat.executeQuery("SELECT id_usuario FROM Usuario WHERE `Correo electronico` ='" + cookies[1].getValue() + "';");
			int checkRedirect = 4;

			if( request.getSession(false).getAttribute("user").equals("usuario") ) {
				if(res1.next() ) {
					String usuarioId = res1.getString("id_usuario");
					ResultSet res2 = stat.executeQuery("SELECT encuestaPorLlenar,edad FROM CuestionarioInicial WHERE id_usuario = " + usuarioId + ";");
					if (res2.next()){
						String encuesta = res2.getString("encuestaPorLlenar");
						int edad = res2.getInt("edad");
						if(encuesta.equals("Asma")){
							if(edad < 10){
								checkRedirect = 1;
							}
							else{
								checkRedirect = 2;
							}
						}
						if(encuesta.equals("EPOC")){
							checkRedirect = 3;
						}
						if(encuesta.equals("Otra")){
							checkRedirect = 4;
						}
					}
				}
			}

			//Agrega current IRPS value a la tabla de usuario
			//Recupera viejo string
			ResultSet getCustomIndex = stat.executeQuery("SELECT IndicePersonalizado FROM usuario where `Correo electronico` = '" + cookies[1].getValue() + "';");
			String updateList = "";
			while(getCustomIndex.next()){
				String javaCustomIndex = getCustomIndex.getString("IndicePersonalizado");
				System.out.println("Current value of javaCustomIndex is: " + javaCustomIndex);
				if(javaCustomIndex == null){
					javaCustomIndex = "";
				}
				//Agrega nuevo string a la DB
				UserLandingRedirect redirect = new UserLandingRedirect();
				String irpsVal = "5";
				try{
					irpsVal = redirect.loadLanding();
				}
				catch(Exception e){
					//
				}
				if(javaCustomIndex.length()>=1){
					updateList = javaCustomIndex + "," + irpsVal;
					System.out.println("Current value of updateList is: " + updateList);
				}
				else{
					updateList = irpsVal;
				}
			}
			int res3 = stat.executeUpdate("update usuario set IndicePersonalizado = '" + updateList + "' where `Correo electronico` = '" + cookies[1].getValue() + "';");


			if(checkRedirect == 1){
				response.sendRedirect("./kidAsQuiz.jsp");
			}
			else if(checkRedirect == 2){
				response.sendRedirect("./asthmaQuiz.jsp");
			}
			else if(checkRedirect == 3){
				response.sendRedirect("./epocQuiz.jsp");
			}
			else if(checkRedirect == 4){
				response.sendRedirect("./healthyQuiz.jsp");
			}
			else{
				response.sendRedirect("./landingUsers.jsp");
			}

			System.out.println(checkRedirect);

			stat.close();
			con.close();


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}