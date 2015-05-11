package br.com.luiscamposjr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

@WebServlet("/AdicionaContatoServlet")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionaContatoServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// log
	    System.out.println("Tentando criar um novo contato...");
	    // acessa o bean
	    Contato contato = new Contato();
	    contato.setNome("Luis01");
	    contato.setEmail("luis01@gmail.com");
	    contato.setEndereco("Copacabana");
	    contato.setDataNascimento(Calendar.getInstance());
	    
	    
	    // adiciona ao banco de dados
	    ContatoDAO dao = new ContatoDAO();
	    dao.adiciona(contato);
	    // ok.... visualização
	    
	    RequestDispatcher req = request.getRequestDispatcher("/contato-adicionado.jsp");
	    req.forward(request, response);
	    
//	    PrintWriter out = response.getWriter();
//	    
//	    out.println("<html>");
//	    out.println("<body>");
//	    out.println("Contato " + contato.getNome() +
//	        " adicionado com sucesso");
//	    out.println("</body>");
//	    out.println("</html>");
	
	}

}
