package br.com.luiscamposjr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.print("testando kkkk");
		
		System.out.println("teste");
		
		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> contatos = contatoDAO.getLista();
		
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
			out.print(contato.getNome());
		}
		
		
	}

}
