package com.hospitalmgmt.dao;

import java.util.List;
import java.util.Map;

import com.hospitalmgmt.pojo.Doctor;

public interface DoctorDao {

	boolean createDoctor(Doctor doctor);
	
	boolean updateDoctor(Doctor doctor);
	
	boolean deleteDoctor(String email);
	
	boolean activeDoctor(String email);
	
	Doctor getDoctorById(int doctorId);

	List<Doctor> getAllDoctors(boolean status);
	
	//for future references
	
//	Doctor getDoctorByEmail(Doctor doctor);
	
	Doctor getDoctorLogin(Doctor doctor);
	
	Map<Integer, String> getAllDoctorsNameAndId(boolean status);
	
}
