package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

public interface IncidentRepository extends CrudRepository<Incident, Long>
{
	
	Incident findById(long id);
	
	//Find incidents within a time period
	List<Incident> findByCreatedAtBetween(Date start, Date end);
	
	List<Incident> findByErrorType(Integer errorType);
	
	//Above filter and versionId
	List<Incident> findByVersionIdAndCreatedAtBetween(String versionId, Date start, Date end);
	
	//Above super-filter and errorType
	List<Incident> findByVersionIdAndErrorTypeAndCreatedAtBetween(String versionId, Integer errorType, Date start, Date end);
	
	//Above super-mega-filter and submoduleId
	List<Incident> findByVersionIdAndErrorTypeAndSubmoduleIdAndCreatedAtBetween(String versionId, Integer errorType, String submoduleId, Date start, Date end);

}
