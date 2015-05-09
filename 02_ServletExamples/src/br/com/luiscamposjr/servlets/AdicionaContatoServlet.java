package br.com.luiscamposjr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import br.com.luiscamposjr.dao.ContatoDAO;
//import br.com.luiscamposjr.model.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionaContatoServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//Com código do exemplo 01 é possível descomentar o codigo abaixo.
		
//		Contato contato = new Contato();
//		contato.setNome(nome);
//		contato.setEmail(email);
//		contato.setEndereco(endereco);
//		contato.setDataNascimento(dataNascimento);
//		
//		ContatoDAO contatoDAO = new ContatoDAO();
//		contatoDAO.adiciona(contato);
		
		
		out.println("<html>");
		out.println("<title>");
		out.println("Adiciona contato");
		out.println("</title>");
		out.println("<body>");
		
//		out.println("Contato ->" + contato.toString() + " foi adicionado com sucedo." );
		
		out.println("</body>");
		out.println("<html>");
		
		out.close();
	
	}

}
