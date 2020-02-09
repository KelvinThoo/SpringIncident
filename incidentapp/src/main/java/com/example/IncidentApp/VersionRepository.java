package com.example.IncidentApp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.Version;

@Repository
public interface VersionRepository extends JpaRepository<VersionId, Long>
{
	VersionId findById(long id);

	@Query(value = "select version_id,count(version_id) as counter from incident_log group by version_id", nativeQuery = true)
	List<VersionId> findVersionID();

	

}

