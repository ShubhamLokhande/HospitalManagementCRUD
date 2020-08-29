package com.hospitalmgmt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmgmt.dao.DoctorDao;
import com.hospitalmgmt.daoImpl.DoctorDaoImpl;
import com.hospitalmgmt.daoImpl.UserDaoImpl;
import com.hospitalmgmt.pojo.Doctor;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4413742373356834256L;

	DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action != null && action.equals("logout")) {
			session.removeAttribute("loggedAs");
			session.removeAttribute("loggedEmail");
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action != null && action.equals("login")) {
			String loginAs = request.getParameter("inputLoginAs");
			String email = request.getParameter("inputEmail");
			String password = request.getParameter("inputPassword");

			if(loginAs != null && loginAs.equals("doctor")) {
				Doctor doctor = new Doctor();
				doctor.setEmail(email);
				doctor.setPassword(password);
				
				Doctor newDoc = doctorDaoImpl.getDoctorLogin(doctor);

				if(newDoc!=null && 	newDoc.getEmail() != null && newDoc.getPassword() != null &&
									newDoc.getEmail().equals(doctor.getEmail()) &&
									newDoc.getPassword().equals(doctor.getPassword())) {
					
					session.setAttribute("loggedAs", loginAs);
					session.setAttribute("loggedEmail", email);
					response.sendRedirect("index.jsp");
				} else {
					System.out.println("not success");
				}
			}
		}
	}

}
