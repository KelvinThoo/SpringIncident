package com.example.IncidentApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*")
@RestController
public class IncidentController 
{
	//-----------------------------------------------------
	//Linking it to the service
	//-----------------------------------------------------

	@Autowired
	private IncidentService service;
	
	//-----------------------------------------------------
	//Very essential functions, veryyyyyyy
	//-----------------------------------------------------
	
	//Save an incident
	@PostMapping("/incident")
	//Requests an incident json file
	public Incident save(@RequestBody Incident incident)
	{
		return service.save(incident);
	}
		
	//Gets an incident by Id
	@GetMapping("/incident/{id}")
	public Incident getById(@PathVariable("id") long id)
	{
		return service.get(id);
	}

	//Gets all incidents
	@GetMapping("/incidents")
	public List<Incident> getAll()
	{
		return service.getAll();
	}

	//Get all incidents with post
	@PostMapping("/postIncidents")
	public List<Incident> getAllPost()
	{
		return service.getAll();
	}
	
	//Update an incident
	@PutMapping("/incident/{id}")
	public Incident update(@PathVariable("id") long id, @RequestBody Incident incident)
	{
		service.update(incident, id);
		return incident;
	}
	
	//Delete an incident
	@DeleteMapping("/incident/{id}")
	public String delete(@PathVariable("id") long id)
	{
		service.delete(id);
		return("Incident" + id + " has been covered up, boss");
	}
	
	//-----------------------------------------------------
	//Equally essential filter functions
	//-----------------------------------------------------

	//Declaring data format
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	//Get incidents by filtering body file
	@RequestMapping(value = "/incidentsearch", method = RequestMethod.POST)
	public List<Incident> getFilteredIncidents(@RequestBody ObjectNode on) throws ParseException
	{
		String start = on.get("startDate").asText();
		String end = on.get("endDate").asText();
		
		Date startDate = new Date();
		Date endDate = new Date();
		
		String version = on.get("version").asText();
		String submodule = on.get("submodule").asText();
		
		String error = on.get("error").asText();
		Integer errorno = 0;
		
		//Converting values
		if(!start.isEmpty())
		{
			startDate = df.parse(start);
		}
		
		if(!end.isEmpty())
		{
			endDate = df.parse(end);
		}
		
		if(!error.isEmpty())
		{
			errorno = Integer.parseInt(error);
		}
		
		//Applying filters
		if(start.isEmpty() || end.isEmpty())
		{
			return getAll();
		}
		
		else if(version.isEmpty())
		{
			return service.getByPeriod(startDate, endDate);
		}
		
		else if(error.isEmpty())
		{
			return service.getMoreByVersion(version, startDate, endDate);
		}
		
		else if(submodule.isEmpty())
		{
			return service.getMoreByError(version, errorno, startDate, endDate);
		}
		
		return service.getMoreBySubmodule(version, errorno, submodule, startDate, endDate);
	}
	
	//Last but not least, save a list of incidents
	@PostMapping("/incidents")
	public List<Incident> saveAll(@RequestBody List<Incident> incidents)
	{
		return service.saveMany(incidents);
	}
}
