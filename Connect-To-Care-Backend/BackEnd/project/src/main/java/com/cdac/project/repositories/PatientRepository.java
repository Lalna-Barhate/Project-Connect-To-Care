package com.cdac.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdac.project.entities.Login;
import com.cdac.project.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query("select p from Patient p where login_id = :id")
	public Patient getOneByLoginId(Login id);
	
	@Query("select p from Patient p where patient_id = :id")
	public Patient getOneById(int id);

}
