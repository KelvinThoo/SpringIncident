package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionIdService 
{
	//-----------------------------------------------------
	//Linking it to the repository
	//-----------------------------------------------------
	
	@Autowired
	private VersionRepository repos;
	
    public List<VersionId> findVersionId()
	{
		return repos.findVersionID();
	}
}
