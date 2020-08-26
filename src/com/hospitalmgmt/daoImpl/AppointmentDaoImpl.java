package com.hospitalmgmt.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospitalmgmt.config.DataBaseConnection;
import com.hospitalmgmt.dao.AppointmentDao;
import com.hospitalmgmt.pojo.Appointment;
import com.hospitalmgmt.system.CustomEnum.Action;

public class AppointmentDaoImpl implements AppointmentDao{

	Connection connection = DataBaseConnection.getConnection(); 
	
	@Override
	public boolean createAppointment(Appointment appoint) {
		String sql = "insert into appointment(doctorId,userId,date,timeSlot,description,action,status) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, appoint.getDoctorId());
			ps.setInt(2, appoint.getUserId());
			ps.setString(3, appoint.getDate().toString());
			ps.setString(4, appoint.getTimeSlot());
			ps.setString(5, appoint.getDescription());
			ps.setString(6, appoint.getAction().toString());
			ps.setBoolean(7, true);
			
			int check = ps.executeUpdate();
			if(check > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAppointment(Appointment appoint) {
		String sql = "update appointment set doctorId=?,userId=?,date=?,timeSlot=?,description=? where appointId=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, appoint.getDoctorId());
			ps.setInt(2, appoint.getUserId());
			ps.setString(3, appoint.getDate().toString());
			ps.setString(4, appoint.getTimeSlot());
			ps.setString(5, appoint.getDescription());
			ps.setInt(7, appoint.getAppointId());
			
			int check = ps.executeUpdate();
			if(check > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAppointment(int appointId) {
		return changeAppointmentStatus(appointId, false);
	}

	@Override
	public boolean activateAppointment(int appointId) {
		return changeAppointmentStatus(appointId, true);
	}
	
	private boolean changeAppointmentStatus(int appointId, boolean status) {
		// used for deleteAppointment and activeAppointment
		String sql = "update appointment set status=? where appointId=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, status);
			ps.setInt(2, appointId);
			
			int check = ps.executeUpdate();
			if(check > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Appointment getAppointmentById(int appointId) {
		String sql = "select * from appointment where appointId=?";
		
		Appointment appoint = new Appointment();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, appointId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				appoint.setAppointId(rs.getInt(1));
				appoint.setDoctorId(rs.getInt(2));
				appoint.setUserId(rs.getInt(3));
				appoint.setDate(LocalDate.parse(rs.getString(4)));
				appoint.setTimeSlot(rs.getString(5));
				appoint.setDescription(rs.getString(6));
				appoint.setAction(Action.valueOf(rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appoint;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorId(int doctorId, boolean status) {
		return getAppointmentsByDynamicEntity(status, doctorId, "doctor");
	}

	@Override
	public List<Appointment> getAppointmentsByUserId(int userId, boolean status) {
		return getAppointmentsByDynamicEntity(status, userId, "user");
	}
	
	@Override
	public List<Appointment> getAllAppointments(boolean status) {
		return getAppointmentsByDynamicEntity(status, 0, "all");
	}
	
	private List<Appointment> getAppointmentsByDynamicEntity(boolean status, int id, String type) {
		//used for getAppointmentsByUserId and getAppointmentsByDoctorId
		String sql = null;
		if(type.equals("user")) {
			sql = "select * from appointment where doctorId=? and status=?";
		} else if(type.equals("doctor")) {
			sql = "select * from appointment where userId=? and status=?";
		} else if(type.equals("all")){
			sql = "select * from appointment status=?";
		} else {
			System.out.println("Something goes wrong....\nInvalid type specified in the method");
			return null;
		}
		
		List<Appointment> appointList = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setBoolean(2, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appoint = new Appointment();
				appoint.setAppointId(rs.getInt(1));
				appoint.setDoctorId(rs.getInt(2));
				appoint.setUserId(rs.getInt(3));
				appoint.setDate(LocalDate.parse(rs.getString(4)));
				appoint.setTimeSlot(rs.getString(5));
				appoint.setDescription(rs.getString(6));
				appoint.setAction(Action.valueOf(rs.getString(7)));
				
				appointList.add(appoint);
			}
			return appointList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointList;
	}
}
