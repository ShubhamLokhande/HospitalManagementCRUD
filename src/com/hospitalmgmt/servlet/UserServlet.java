package com.hospitalmgmt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hospitalmgmt.daoImpl.DoctorDaoImpl;
import com.hospitalmgmt.daoImpl.UserDaoImpl;
import com.hospitalmgmt.pojo.Doctor;
import com.hospitalmgmt.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	   
	private static final long serialVersionUID = 6934943802662772521L;
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action != null && action.equals("getAllUser")) {
			List<User> userList = userDaoImpl.getAllUsers(true);
			session.setAttribute("userList", userList);
			session.setAttribute("userActive", false);
			response.sendRedirect("userList.jsp");
		} else if(action != null && action.equals("getAllUserByFalse")) {
			List<User> userList = userDaoImpl.getAllUsers(false);
			session.setAttribute("userList", userList);
			session.setAttribute("userActive", true);
			response.sendRedirect("userList.jsp");
		} else if(action != null && action.equals("getUserById")) {
			int userId = Integer.parseInt(request.getParameter("id"));
			User user = userDaoImpl.getUserById(userId);
	        String employeeJsonString = this.gson.toJson(user);
	        
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(employeeJsonString);
	        out.flush();  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		if(action != null && action.equals("inputUser")) {
			User user = new User();
			String userId = request.getParameter("inputUserId");
			user.setName(request.getParameter("inputName"));
			user.setEmail(request.getParameter("inputEmail"));
			user.setPassword(request.getParameter("inputPassword"));
			user.setGender(request.getParameter("inputGender"));
			user.setQual(request.getParameter("inputQual"));
			user.setDob(LocalDate.parse(request.getParameter("inputDob")));
			user.setMobileNo(request.getParameter("inputMobileNo"));
			user.setAddress(request.getParameter("inputAddress"));
			boolean check = false;
			if(userId.length() > 0) {
				user.setUserId(Integer.parseInt(userId));
				check = userDaoImpl.updateUser(user);
			} else {
				check = userDaoImpl.createUser(user);
			}
			if(check) {
				rd = request.getRequestDispatcher("UserServlet?action=getAllUser");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("deleteUser")) {
			String email = request.getParameter("email");
			boolean check = userDaoImpl.deleteUser(email);
			if(check) {
				rd = request.getRequestDispatcher("UserServlet?action=getAllUser");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("activeUser")) {
			String email = request.getParameter("email");
			boolean check = userDaoImpl.activateUser(email);
			if(check) {
				rd = request.getRequestDispatcher("UserServlet?action=getAllUserByFalse");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("getAllUser")) {
			List<User> userList = userDaoImpl.getAllUsers(true);
			session.setAttribute("userList", userList);
			session.setAttribute("userActive", false);
			response.sendRedirect("userList.jsp");
		} else if(action != null && action.equals("getAllUserByFalse")) {
			List<User> userList = userDaoImpl.getAllUsers(false);
			session.setAttribute("userList", userList);
			session.setAttribute("userActive", true);
			response.sendRedirect("userList.jsp");
		}
	}

}
