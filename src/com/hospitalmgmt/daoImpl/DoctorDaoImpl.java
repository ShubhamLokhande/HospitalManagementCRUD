package com.hospitalmgmt.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospitalmgmt.config.DataBaseConnection;
import com.hospitalmgmt.dao.DoctorDao;
import com.hospitalmgmt.pojo.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	Connection connection = DataBaseConnection.getConnection();
	
	@Override
	public boolean createDoctor(Doctor doctor) {
		String sql = "insert into doctor(name,email,password,gender,qual,dob,expertIn,status) values(?,?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getEmail());
			ps.setString(3, doctor.getPassword());
			ps.setString(4, doctor.getGender());
			ps.setString(5, doctor.getQual());
			ps.setString(6, doctor.getDob().toString());
			ps.setString(7, doctor.getExpertIn());
			ps.setBoolean(8, true);
			
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
	public boolean updateDoctor(Doctor doctor) {
		String sql = "update doctor set name=?,email=?,password=?,gender=?,qual=?,dob=?,expertIn=? where doctorId=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getEmail());
			ps.setString(3, doctor.getPassword());
			ps.setString(4, doctor.getGender());
			ps.setString(5, doctor.getQual());
			ps.setString(6, doctor.getDob().toString());
			ps.setString(7, doctor.getExpertIn());
			ps.setInt(8, doctor.getDoctorId());
			
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
	public Doctor getDoctorById(int doctorId) {
		String sql = "select * from doctor where doctorId=?";
		Doctor doctor = new Doctor();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				doctor.setDoctorId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setEmail(rs.getString(3));
				doctor.setPassword(rs.getString(4));
				doctor.setGender(rs.getString(5));
				doctor.setQual(rs.getString(6));
				doctor.setDob(LocalDate.parse(rs.getString(7)));
				doctor.setExpertIn(rs.getString(8));
				doctor.setStatus(rs.getBoolean(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
	
	@Override
	public boolean deleteDoctor(String email) {
		return changeDoctorStatus(email, false);
	}

	@Override
	public boolean activeDoctor(String email) {
		return changeDoctorStatus(email, true);
	}

	private boolean changeDoctorStatus(String email, boolean status) {
		// used for deleteDoctor and activeDoctor
		String sql = "update doctor set status=? where email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, status);
			ps.setString(2, email);
			
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
	public List<Doctor> getAllDoctors(boolean status) {
		String sql = "select * from doctor where status=?";
		List<Doctor> doctorList = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Doctor stud = new Doctor();
				stud.setDoctorId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setEmail(rs.getString(3));
				stud.setPassword(rs.getString(4));
				stud.setGender(rs.getString(5));
				stud.setQual(rs.getString(6));
				stud.setDob(LocalDate.parse(rs.getString(7)));
				stud.setExpertIn(rs.getString(8));
				stud.setStatus(rs.getBoolean(9));
				
				doctorList.add(stud);
			}
			return doctorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorList;
	}

/**	
	//for future references
	
	@Override
	public Doctor getDoctorByEmail(String email) {
		String sql = "select * from doctor where email=?";
		Doctor doctor = new Doctor();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				doctor.setDoctorId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setEmail(rs.getString(3));
				doctor.setPassword(rs.getString(4));
				doctor.setGender(rs.getString(5));
				doctor.setQual(rs.getString(6));
				doctor.setDob(LocalDate.parse(rs.getString(7)));
				doctor.setExpertIn(rs.getString(8));
				doctor.setStatus(rs.getBoolean(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}	**/
	
	@Override
	public Doctor getDoctorLogin(Doctor doctor) {
		String sql = "select email,password from doctor where email=?";
		Doctor doc = new Doctor();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, doctor.getEmail());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				doc.setEmail(rs.getString(1));
				doc.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
