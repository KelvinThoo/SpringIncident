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
public class VersionId 
{
	//-----------------------------------------------------
	//Incident values
	//-----------------------------------------------------
	
	//Id value that auto-generates
	
	@Id
	private String versionId;
	
	private int counter;
	
	//-----------------------------------------------------
	//Default Constructor
	//-----------------------------------------------------
	
	protected VersionId() {}

	//-----------------------------------------------------
	//Incident Constructor
	//-----------------------------------------------------

	public VersionId(
			String version,
			int counter)
	{	
		this.versionId = version;
		this.counter = counter;
	}

	//-----------------------------------------------------
	//Getters and Setters
	//-----------------------------------------------------
  
	@Column (name = "version_id")
	public String getVersionId() 
	{
		return versionId;
	}

	public void setVersionId(String version_id) 
	{
		this.versionId = version_id;
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
