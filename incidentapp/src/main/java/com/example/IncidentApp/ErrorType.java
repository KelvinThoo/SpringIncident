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
public class ErrorType 
{
	//-----------------------------------------------------
	//Incident values
	//-----------------------------------------------------
	
	//Id value that auto-generates
	
	@Id
	private int errorType;
	
	private int counter;
	
	//-----------------------------------------------------
	//Default Constructor
	//-----------------------------------------------------
	
	protected ErrorType() {}

	//-----------------------------------------------------
	//Incident Constructor
	//-----------------------------------------------------

	public ErrorType(
			int errorType,
			int counter)
	{	
		this.errorType = errorType;
		this.counter = counter;
	}

	//-----------------------------------------------------
	//Getters and Setters
	//-----------------------------------------------------
  
	@Column (name = "error_type")
	public int getErrorType() 
	{
		return errorType;
	}

	public void setVersionId(int errorType) 
	{
		this.errorType = errorType;
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
