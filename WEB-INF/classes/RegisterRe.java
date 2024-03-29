import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Vector;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RegisterRe")
public class RegisterRe extends HttpServlet{

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
			String name = request.getParameter("ReName");
			String email = request.getParameter("ReEmail");
			String password = request.getParameter("RePW");
			String type = request.getParameter("ReType");

			//save values in database
			int res = stat.executeUpdate("insert into Investigador(Clearance,Nombre, Correo, Contrasena) VALUES (\""
				+ type + "\",\""+ name + "\", \"" + email + "\", \"" + password + "\");");

			stat.close();
			con.close();


			response.sendRedirect("./LandingPageAdmin.jsp");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
