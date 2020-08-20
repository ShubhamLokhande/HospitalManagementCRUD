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
import com.hospitalmgmt.pojo.Doctor;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	   
	private static final long serialVersionUID = 6934943802662772521L;
	
	DoctorDaoImpl docDaoImpl = new DoctorDaoImpl();
	
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action != null && action.equals("getAllDoctor")) {
			List<Doctor> docList = docDaoImpl.getAllDoctors(true);
			session.setAttribute("docList", docList);
			session.setAttribute("doctorActive", false);
			response.sendRedirect("doctorList.jsp");
		} else if(action != null && action.equals("getAllDoctorByFalse")) {
			List<Doctor> docList = docDaoImpl.getAllDoctors(false);
			session.setAttribute("docList", docList);
			session.setAttribute("doctorActive", true);
			response.sendRedirect("doctorList.jsp");
		} else if(action != null && action.equals("getDoctorById")) {
			int doctorId = Integer.parseInt(request.getParameter("id"));
			Doctor doctor = docDaoImpl.getDoctorById(doctorId);
	        String employeeJsonString = this.gson.toJson(doctor);
	        
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
		if(action != null && action.equals("inputDoctor")) {
			Doctor doctor = new Doctor();
			String docId = request.getParameter("inputDoctorId");
			doctor.setName(request.getParameter("inputName"));
			doctor.setEmail(request.getParameter("inputEmail"));
			doctor.setPassword(request.getParameter("inputPassword"));
			doctor.setGender(request.getParameter("inputGender"));
			doctor.setQual(request.getParameter("inputQual"));
			doctor.setDob(LocalDate.parse(request.getParameter("inputDob")));
			doctor.setExpertIn(request.getParameter("inputExpertIn"));
			boolean check = false;
			if(docId.length() > 0) {
				doctor.setDoctorId(Integer.parseInt(docId));
				check = docDaoImpl.updateDoctor(doctor);
			} else {
				check = docDaoImpl.createDoctor(doctor);
			}
			if(check) {
				rd = request.getRequestDispatcher("DoctorServlet?action=getAllDoctor");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("deleteDoctor")) {
			String email = request.getParameter("email");
			boolean check = docDaoImpl.deleteDoctor(email);
			if(check) {
				rd = request.getRequestDispatcher("DoctorServlet?action=getAllDoctor");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("activeDoctor")) {
			String email = request.getParameter("email");
			boolean check = docDaoImpl.activeDoctor(email);
			if(check) {
				rd = request.getRequestDispatcher("DoctorServlet?action=getAllDoctorByFalse");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("getAllDoctor")) {
			List<Doctor> docList = docDaoImpl.getAllDoctors(true);
			session.setAttribute("docList", docList);
			session.setAttribute("doctorActive", false);
			response.sendRedirect("doctorList.jsp");
		} else if(action != null && action.equals("getAllDoctorByFalse")) {
			List<Doctor> docList = docDaoImpl.getAllDoctors(false);
			session.setAttribute("docList", docList);
			session.setAttribute("doctorActive", true);
			response.sendRedirect("doctorList.jsp");
		}
	}

}
