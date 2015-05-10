package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luiscamposjr.jdbc.ConnectionFactory;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/Primeiro")
public class PrimeiroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try(Connection con = ConnectionFactory.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select nome from contatos")) {	
			PrintWriter out = response.getWriter();
			
			while(rs.next()){
				String nome = rs.getString("nome");
				out.println(nome + " teste " + "<br><br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
