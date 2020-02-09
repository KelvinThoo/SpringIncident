package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorTypeService 
{
	//-----------------------------------------------------
	//Linking it to the repository
	//-----------------------------------------------------
	
	@Autowired
    private ErrorTypeRepository repos;
	
    public List<ErrorType> findErrorTypes()
	{
		return repos.findErrorTypes();
    }
    
}
