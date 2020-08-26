package com.hospitalmgmt.pojo;

import java.time.LocalDate;

import com.hospitalmgmt.system.CustomEnum;
import com.hospitalmgmt.system.CustomEnum.Action;

public class Appointment {
	
	private int appointId;
	private int doctorId;
	private int userId;
	private LocalDate date;
	private String timeSlot;
	private String description;
	private Action action;
	private boolean status;
	
	public int getAppointId() {
		return appointId;
	}
	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action2) {
		this.action = action2;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
