package com.hospitalmgmt.dao;

import java.util.List;

import com.hospitalmgmt.pojo.Appointment;

public interface AppointmentDao {
	
	boolean createAppointment(Appointment appoint);
	
	boolean updateAppointment(Appointment appoint);
	
	boolean deleteAppointment(int appointId);
	
	boolean activateAppointment(int appointId);
	
	Appointment getAppointmentById(int appointId);

	List<Appointment> getAppointmentsByDoctorId(int doctorId, boolean status);
	
	List<Appointment> getAppointmentsByUserId(int userId, boolean status);
	
	List<Appointment> getAllAppointments(boolean status);
}
