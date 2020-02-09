package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.Version;

@Repository
public interface SubModuleRepository extends JpaRepository<SubModule, Long>
{
	@Query(value = "select submodule_id,count(submodule_id) as counter from incident_log group by submodule_id", nativeQuery = true)
	List<SubModule> findSubModules();
}

