package com.cdac.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.project.entities.Login;
import com.cdac.project.entities.Patient;
import com.cdac.project.entities.PatientRegisteration;
import com.cdac.project.services.LoginService;
import com.cdac.project.services.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@Autowired
	LoginService lservice;
	
	@GetMapping("/allpatients")
	public List<Patient> getAllPatients(){
		return pservice.getAllUsers();
	}
	
	@GetMapping("/getonepatient/{id}")
	public Optional<Patient> getOnePatient(@PathVariable int id) {
		return pservice.getOnePatient(id);
	}
	
	//add new patient
	@PostMapping("/savepatient")
	public Patient savePatient(@RequestBody PatientRegisteration pr) {
			Login l = new Login(pr.getUserName(),pr.getPassword(),"Patient");
			Login inserted = lservice.saveUser(l);
			if(inserted == null) {
				return null;
			}
			else {
				Patient p = new Patient(pr.getFirstName(),pr.getLastName(),pr.getMobileNumber(),pr.getGender(),pr.getBloodGroup(),pr.getDob(),pr.getAadharNumber(),inserted);
				return pservice.savePatient(p);
			}
	}
	
	@PostMapping("/updatepatient")
	public Patient updatePatient(@RequestBody Patient p) {
//		System.out.println(p.getPatient_id());
//		System.out.println(p.getFirstName());
//		System.out.println(p.getLastName());
//		System.out.println(p.getMobileNumber());
//		System.out.println(p.getDob());
//		System.out.println(p.getGender());
//		System.out.println(p.getBlood_group());
//		System.out.println(p.getLogin_id());
		return pservice.updatePatient(p);
	}
}