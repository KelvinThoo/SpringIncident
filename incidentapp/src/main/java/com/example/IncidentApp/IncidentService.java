package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentService 
{
	//-----------------------------------------------------
	//Linking it to the repository
	//-----------------------------------------------------
	
	@Autowired
	private IncidentRepository repos;
	
	
	//-----------------------------------------------------
	//Some rather mandatory functions
	//-----------------------------------------------------
	
	//Save an incident
	public Incident save(Incident incident)
	{
		repos.save(incident);
		return incident;
	}
	
	//Save a list of incidents to ease population
	public List<Incident> saveMany(List<Incident> incidents)
	{
		repos.saveAll(incidents);
		return incidents;
	}
	
	//Get an incident by Id
	//
	public Incident get(long id)
	{
		return repos.findById(id);
	}

	//Get all incidents
	public List<Incident> getAll()
	{
		return (List<Incident>) repos.findAll();
	}
	
	//Update an incident
	public long update(Incident incident, long id)
	{
		Incident old = repos.findById(id);
		old.setCreatedAt(incident.getCreatedAt());
		old.setVersionId(incident.getVersionId());
		old.setErrorType(incident.getErrorType());
		old.setSubmoduleId(incident.getSubmoduleId());
		repos.save(old);
		return old.getId();
	}
	
	//Delete an incident
	public long delete(long id)
	{
		repos.delete(repos.findById(id));
		return id;
	}

	
	//-----------------------------------------------------
	//Filter find functions
	//-----------------------------------------------------
	
	//Find between two dates
	public List<Incident> getByPeriod(Date start, Date end)
	{
		return repos.findByCreatedAtBetween(start, end);
	}
	
	//Further filter by versionId
	public List<Incident> getMoreByVersion(String versionId, Date start, Date end)
	{
		return repos.findByVersionIdAndCreatedAtBetween(versionId, start, end);
	}
	
	//Further filter again by errorType
	public List<Incident> getMoreByError(String versionId, Integer errorType, Date start, Date end)
	{
		return repos.findByVersionIdAndErrorTypeAndCreatedAtBetween(versionId, errorType, start, end);
	}
	
	//Further filter again by submodule
	public List<Incident> getMoreBySubmodule(String versionId, Integer errorType, String submoduleId, Date start, Date end)
	{
		return repos.findByVersionIdAndErrorTypeAndSubmoduleIdAndCreatedAtBetween(versionId, errorType, submoduleId, start, end);
	}
}
