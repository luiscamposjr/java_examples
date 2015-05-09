package br.com.luiscamposjr;

import java.util.Calendar;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

public class ExampleDAO {

	public ExampleDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Luis Campos Junior");
		contato.setEmail("luiscamposjr@gmail.com");
		contato.setEndereco("Copacabana");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.adiciona(contato);
		System.out.println("Gravado com DAO");

	}

}
