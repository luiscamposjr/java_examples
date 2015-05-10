package br.com.luiscamposjr.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

@WebServlet("/TesteListagem")
public class TesteListagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.service(arg0, arg1);
		
		System.out.println("teste");
		
		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> contatos = contatoDAO.getLista();
		
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
		}
	}
}
