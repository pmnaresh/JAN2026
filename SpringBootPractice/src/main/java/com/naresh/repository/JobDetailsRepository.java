package com.naresh.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naresh.entity.JobDetails;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {

	@Query(value = """
			SELECT *
			FROM job_details
			WHERE created_timestamp >= :start
			  AND created_timestamp < :end
			""", nativeQuery = true)
	List<JobDetails> findByCreatedDate(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

	@Query(value = """
			SELECT * from job_details where facility_id =:facilityId and job_id=:jobId;
			""", nativeQuery = true)
	List<JobDetails> findByFacilityIdandJobId(@Param("facilityId") String facilityId, @Param("jobId") int jobId);

}
