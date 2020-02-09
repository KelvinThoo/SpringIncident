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
@Table(name = "incident_log")
public class Incident 
{
	//-----------------------------------------------------
	//Incident values
	//-----------------------------------------------------
	
	//Id value that auto-generates
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date createdAt;
	private String versionId;
	private Integer errorType;
	private String submoduleId;
	
	//-----------------------------------------------------
	//Default Constructor
	//-----------------------------------------------------
	
	protected Incident() {}

	//-----------------------------------------------------
	//Incident Constructor
	//-----------------------------------------------------

	public Incident(
			Date date, 
			String version, 
			Integer error, 
			String submodule)
	{	
		this.createdAt = date;
		this.versionId = version;
		this.errorType = error;
		this.submoduleId = submodule;
	}

	//-----------------------------------------------------
	//Getters and Setters
	//-----------------------------------------------------

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public Date getCreatedAt() 
	{
		return createdAt;
	}

	public void setCreatedAt(Date created_at) 
	{
		this.createdAt = created_at;
	}

	@Column(name = "version_id", nullable = false)
	public String getVersionId() 
	{
		return versionId;
	}

	public void setVersionId(String version_id) 
	{
		this.versionId = version_id;
	}

	public Integer getErrorType() 
	{
		return errorType;
	}

	public void setErrorType(Integer error_type) 
	{
		this.errorType = error_type;
	}

	public String getSubmoduleId() 
	{
		return submoduleId;
	}

	public void setSubmoduleId(String submodule_id) 
	{
		this.submoduleId = submodule_id;
	}
	
}
