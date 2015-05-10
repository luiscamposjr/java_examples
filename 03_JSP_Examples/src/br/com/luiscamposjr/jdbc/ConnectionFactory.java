package br.com.luiscamposjr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:80/01_jdbc", "root", "root");
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
