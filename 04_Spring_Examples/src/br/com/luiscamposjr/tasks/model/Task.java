package br.com.luiscamposjr.tasks.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	
	private Long id;
	
	@NotNull @Size(min=5)
    private String description;
    private boolean finalized;
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Calendar finalizedDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getFinalized() {
		return finalized;
	}
	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	public Calendar getFinalizedDate() {
		return finalizedDate;
	}
	public void setFinalizedDate(Calendar finalizedDate) {
		this.finalizedDate = finalizedDate;
	}

}
