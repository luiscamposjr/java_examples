package br.com.luiscamposjr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TesteThreadServlet")
public class TesteThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int contator = 0;
       
    public TesteThreadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		contator++;
		
		PrintWriter out = response.getWriter();
		
		out.println(contator);
		
		
		
	}

}
