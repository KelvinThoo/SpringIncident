package com.example.IncidentApp;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "incident_log")
public class SubModule 
{
	//-----------------------------------------------------
	//Incident values
	//-----------------------------------------------------
	
	//Id value that auto-generates
	
	@Id
	private String submoduleId;
	
	private int counter;
	
	//-----------------------------------------------------
	//Default Constructor
	//-----------------------------------------------------
	
	protected SubModule() {}

	//-----------------------------------------------------
	//Incident Constructor
	//-----------------------------------------------------

	public SubModule(
			String submoduleId,
			int counter)
	{	
		this.submoduleId = submoduleId;
		this.counter = counter;
	}

	//-----------------------------------------------------
	//Getters and Setters
	//-----------------------------------------------------
  
	@Column (name = "submodule_id")
	public String getsubmoduleId() 
	{
		return submoduleId;
	}

	public void setsubmoduleId(String submoduleId) 
	{
		this.submoduleId = submoduleId;
	}	

	public int getCounter()
	{
		return counter;
	}

	public void setCounter(int counter)
	{
		this.counter = counter;
	}
}
