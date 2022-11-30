package com.cdac.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Parameter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parameterId;
	
	@JsonIgnoreProperties("parameter")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patient_id;
	
	@Column(name = "height")
	private String height;
	
	@Column(name = "weight")
	private String weight;

	@Column(name = "bmi")
	private String bmi;
	
	@Column(name = "hb")
	private String hb;
	
	@Column(name = "blood_pressure")
	private String blood_pressure;
	
	@Column(name = "blood_sugar")
	private String blood_sugar;
	
	@Column(name = "blood_group")
	private String blood_group;

	public Parameter() {
		super();
	}

	public Parameter(Patient patient_id, String height, String weight, String bmi, String hb, String blood_pressure,
			String blood_sugar, String blood_group) {
		super();
		this.patient_id = patient_id;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.hb = hb;
		this.blood_pressure = blood_pressure;
		this.blood_sugar = blood_sugar;
		this.blood_group = blood_group;
	}
	
	public Parameter(int parameterId, Patient patient_id,  String height, String weight, String bmi, String hb, String blood_pressure,
			String blood_sugar, String blood_group) {
		super();
		this.parameterId = parameterId;
		this.patient_id = patient_id;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.hb = hb;
		this.blood_pressure = blood_pressure;
		this.blood_sugar = blood_sugar;
		this.blood_group = blood_group;
	}

	public int getParameterId() {
		return parameterId;
	}

	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getBlood_pressure() {
		return blood_pressure;
	}

	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}

	public String getBlood_sugar() {
		return blood_sugar;
	}

	public void setBlood_sugar(String blood_sugar) {
		this.blood_sugar = blood_sugar;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	
	
}
