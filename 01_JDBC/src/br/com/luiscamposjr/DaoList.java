package br.com.luiscamposjr;

import java.util.List;

import br.com.luiscamposjr.dao.ContatoDAO;
import br.com.luiscamposjr.model.Contato;

public class DaoList {

	public static void main(String[] args) {

		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> contatos = contatoDAO.getLista();
		
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
		}
		
		
	}

}
