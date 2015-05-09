package br.com.luiscamposjr;

import java.sql.Date;
import java.util.Calendar;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

public class DAOUpdate {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setId(3L);
		contato.setNome("Luis Campos Jr");
		contato.setEmail("lcamposjr@gmail.com");
		contato.setEndereco("Rio de Janeiro");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.atualiza(contato);
		
		
	}

}
