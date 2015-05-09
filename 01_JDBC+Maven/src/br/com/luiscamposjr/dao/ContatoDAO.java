package br.com.luiscamposjr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.luiscamposjr.jdbc.ConnectionFactory;
import br.com.luiscamposjr.model.Contato;

public class ContatoDAO {
	
	private Connection connection;

	public ContatoDAO() {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
	    String sql = "insert into contatos" + 
	    		"(nome, email, endereco, dataNascimento)" + 
	    		"values(?,?,?,?)";
	    
	    try {
			
	    	PreparedStatement stmp = this.connection.prepareStatement(sql);
	    	
	    	stmp.setString(1, contato.getNome());
	    	stmp.setString(2, contato.getEmail());
	    	stmp.setString(3, contato.getEndereco());
	    	stmp.setDate(4, new Date(  contato.getDataNascimento().getTimeInMillis()   ));
	    	
	    	stmp.execute();
	    	stmp.close();
	    	
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public void atualiza(Contato contato){
		
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			stmp.setString(1, contato.getNome());
			stmp.setString(2, contato.getEmail());
			stmp.setString(3, contato.getEndereco());
			stmp.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmp.setLong(5, contato.getId());
			
			
			stmp.execute();
			stmp.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
		
	}
	
	public List<Contato> getLista(){
		
		String sql = "select * from contatos";
		
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmp.executeQuery();
			
			while (rs.next()) {
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmp.close();
			
			return contatos;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
		
	}

}
