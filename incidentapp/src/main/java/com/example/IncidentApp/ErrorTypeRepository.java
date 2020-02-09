package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.Version;

@Repository
public interface ErrorTypeRepository extends JpaRepository<ErrorType, Long>
{
	VersionId findById(long id);

	@Query(value = "select error_type,count(error_type) as counter from incident_log group by error_type", nativeQuery = true)
	List<ErrorType> findErrorTypes();

	

}

