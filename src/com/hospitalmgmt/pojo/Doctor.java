package com.hospitalmgmt.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor implements Serializable{
	private int doctorId;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String qual;
	private LocalDate dob;
	private String expertIn;
	private boolean status;

	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getExpertIn() {
		return expertIn;
	}
	public void setExpertIn(String expertIn) {
		this.expertIn = expertIn;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", qual=" + qual + ", dob=" + dob + ", expertIn=" + expertIn + ", status="
				+ status + "]";
	}
	
}
