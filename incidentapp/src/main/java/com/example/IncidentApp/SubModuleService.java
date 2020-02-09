package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubModuleService 
{
	//-----------------------------------------------------
	//Linking it to the repository
	//-----------------------------------------------------
	
	@Autowired
	private SubModuleRepository repos;
	
    public List<SubModule> findSubModules()
	{
		return repos.findSubModules();
	}
}
