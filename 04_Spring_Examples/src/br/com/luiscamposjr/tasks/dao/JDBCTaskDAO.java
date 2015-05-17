package br.com.luiscamposjr.tasks.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.ui.Model;

import br.com.luiscamposjr.tasks.jdbc.ConnectionFactory;
import br.com.luiscamposjr.tasks.model.Task;


public class JDBCTaskDAO {
	
	private Connection connection;

	public JDBCTaskDAO() {
		
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Task task) {
		
	    String sql = "insert into tasks" + 
	    		"(description, finalized)" + 
	    		"values(?,?)";
	    try {
	    	PreparedStatement stmp = this.connection.prepareStatement(sql);
	    	
	    	stmp.setString(1, task.getDescription());
	    	stmp.setBoolean(2,false);
	    	
	    	stmp.execute();
	    	stmp.close();
	    	
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public void remove(Task task) {
		
		String sql = "delete from tasks where id=?";
		
		try {
			
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			stmp.setLong(1, task.getId());
			
			stmp.execute();
			stmp.close();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public Task buscaPorId(Long id, Model model) {
		
		String sql = "select * from tasks where id=?";
		ResultSet rs ;
		Task task = new Task();
		try {
			
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			stmp.setLong(1, id);
			
			rs = stmp.executeQuery();
			
			if(rs!=null && rs.next()){
				task.setId(rs.getLong("id"));
				task.setDescription(rs.getString("description"));
				task.setFinalized(rs.getBoolean("finalized"));
	        }
			
			rs.close();
			stmp.close();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return task;
	}
	
	public void update(Task task){
		
		String sql = "update tasks set description=?, finalized=?, finalizedDate=? where id=?";
		
		try {
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			stmp.setString(1, task.getDescription());
			stmp.setBoolean(2, task.getFinalized());
			stmp.setDate(3, new Date(task.getFinalizedDate().getTimeInMillis()));
			stmp.setLong(4, task.getId());

			stmp.execute();
			stmp.close();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
		
	}
	
	public List<Task> getList(){
		
		String sql = "select id, description, finalized from tasks";
		
		try {
			List<Task> tasks = new ArrayList<Task>();
			PreparedStatement stmp = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmp.executeQuery();
			
			while (rs.next()) {
				
				Task task = new Task();
				task.setId(rs.getLong("id"));
				task.setDescription(rs.getString("description"));
				task.setFinalized(rs.getBoolean("finalized"));
				
				Calendar data = Calendar.getInstance();
				data.setTime((java.util.Date) (rs.getDate("finalizedDate") != null ? rs.getDate("finalizedDate") : new java.util.Date().getTime()));
				task.setFinalizedDate(data);
				
				tasks.add(task);
			}
			
			rs.close();
			stmp.close();
			
			return tasks;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
		
	}

}
