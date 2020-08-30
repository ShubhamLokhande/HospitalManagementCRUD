package com.hospitalmgmt.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospitalmgmt.config.DataBaseConnection;
import com.hospitalmgmt.dao.UserDao;
import com.hospitalmgmt.pojo.User;

public class UserDaoImpl implements UserDao{

	Connection connection = DataBaseConnection.getConnection();
	
	@Override
	public boolean createUser(User user) {
		String sql = "insert into user(name,email,password,gender,qual,dob,mobileNo,address,status) values(?,?,?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getQual());
			ps.setString(6, user.getDob().toString());
			ps.setString(7, user.getMobileNo());
			ps.setString(8, user.getAddress());
			ps.setBoolean(9, true);
			
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
	public boolean updateUser(User user) {
		String sql = "update user set name=?,email=?,password=?,gender=?,qual=?,dob=?,mobileNo=?,address=? where userId=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getQual());
			ps.setString(6, user.getDob().toString());
			ps.setString(7, user.getMobileNo());
			ps.setString(8, user.getAddress());
			ps.setInt(9, user.getUserId());
			
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
	public User getUserById(int userId) {
		String sql = "select * from user where userId=?";
		User user = new User();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setQual(rs.getString(6));
				user.setDob(LocalDate.parse(rs.getString(7)));
				user.setMobileNo(rs.getString(8));
				user.setAddress(rs.getString(9));
				user.setStatus(rs.getBoolean(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	@Override
	public boolean deleteUser(String email) {
		String sql = "update user set status=? where email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, false);
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
	public boolean activateUser(String email) {
		String sql = "update user set status=? where email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, true);
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
	public List<User> getAllUsers(boolean status) {
		String sql = "select * from user where status=?";
		List<User> userList = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User stud = new User();
				stud.setUserId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setEmail(rs.getString(3));
				stud.setPassword(rs.getString(4));
				stud.setGender(rs.getString(5));
				stud.setQual(rs.getString(6));
				stud.setDob(LocalDate.parse(rs.getString(7)));
				stud.setMobileNo(rs.getString(8));
				stud.setAddress(rs.getString(9));
				stud.setStatus(rs.getBoolean(10));
				
				userList.add(stud);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

/**	
	//for future references
	
	@Override
	public User getUserByEmail(String email) {
		String sql = "select * from user where email=?";
		User user = new User();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				doctor.setUserId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setEmail(rs.getString(3));
				doctor.setPassword(rs.getString(4));
				doctor.setGender(rs.getString(5));
				doctor.setQual(rs.getString(6));
				doctor.setDob(LocalDate.parse(rs.getString(7)));
				doctor.setMobileNo(rs.getString(8));
				doctor.setAddress(rs.getString(9));
				doctor.setStatus(rs.getBoolean(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}	**/
	
	@Override
	public User getUserLogin(User user) {
		String sql = "select email,password from user where email=?";
		User newUser = new User();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				newUser.setEmail(rs.getString(1));
				newUser.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newUser;
	}

}
