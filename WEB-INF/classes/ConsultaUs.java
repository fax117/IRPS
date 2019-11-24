import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ConsultaUs")
public class ConsultaUs extends HttpServlet{

	public void init(ServletConfig config){
		try{
			super.init(config);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

			//------Connection to mySQL setup STARTS-------
			//credentials
			String dbbase = getServletContext().getInitParameter("base");
			String dbusuario = getServletContext().getInitParameter("usuario");
			String dbpassword = getServletContext().getInitParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");

			//general setup - driver setup, connection, statement setup
			String url = "jdbc:mysql://localhost/"+dbbase+"?useSSL=false&allowPublicKeyRetrieval=true";
			Connection con = DriverManager.getConnection(url,dbusuario,dbpassword);
			Statement stat = con.createStatement();

			//------Connection to mySQL setup ENDS----------

			//------User register STARTS------

			//retrieve values from register's forms

			Cookie[] cookies = request.getCookies();

			ResultSet res1 = stat.executeQuery("SELECT id_usuario FROM Usuario WHERE `Correo electronico` ='" + cookies[1].getValue() + "';");

			if( request.getSession(false).getAttribute("user").equals("usuario") ) {
				if(res1.next() ) {
					String usuarioId = res1.getString("id_usuario");
					String consulta = request.getParameter("consultaTx");
					String asunto = request.getParameter("asuntoParam");
					int estado = 0;
					//save values in database
					int res = stat.executeUpdate("INSERT INTO Chat(id_usuario, pregunta, contestada, asunto) VALUES (\""
						+ usuarioId + "\",\""+ consulta + "\",\""+ estado + "\", \""+ asunto + "\");");
				}
				response.sendRedirect("./landingUsers.jsp");
			}

			stat.close();
			con.close();

			//Cambiar


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
