package br.com.luiscamposjr;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.luiscamposjr.jdbc.ConnectionFactory;

public class JDBCExample {

	public JDBCExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		
		String sql = "insert into contatos" + 
					 "(nome, email, endereco, dataNascimento)" + 
					 "values(?,?,?,?)";
		
		PreparedStatement stmp = conexao.prepareStatement(sql);
		
		stmp.setString(1, "Luis Campos");
		stmp.setString(2, "luiscamposjr@gmail.com");
		stmp.setString(3, "Av. Princesa Isabel");
		stmp.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
		
		stmp.execute();
		stmp.close();
		System.out.println("Gravado");
		
		conexao.close();


	}

}
