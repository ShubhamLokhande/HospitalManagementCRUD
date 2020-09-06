package com.hospitalmgmt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hospitalmgmt.daoImpl.AppointmentDaoImpl;
import com.hospitalmgmt.daoImpl.DoctorDaoImpl;
import com.hospitalmgmt.daoImpl.UserDaoImpl;
import com.hospitalmgmt.pojo.Appointment;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7803064625846938032L;

	AppointmentDaoImpl appointDaoImpl = new AppointmentDaoImpl();
	DoctorDaoImpl docDaoImpl = new DoctorDaoImpl();
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	private Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action != null && action.equals("getAllAppointment")) {
			List<Appointment> appointList = appointDaoImpl.getAllAppointments(true);
			Map<Integer, String> allDocNameAndId = docDaoImpl.getAllDoctorsNameAndId(true);
			Map<Integer, String> allUserNameAndId = userDaoImpl.getAllUsersNameAndId(true);
			session.setAttribute("appointList", appointList);
			session.setAttribute("docNameMap", allDocNameAndId);
			session.setAttribute("userNameMap", allUserNameAndId);
			session.setAttribute("appointActive", false);
			response.sendRedirect("appointmentList.jsp");
		} else if(action != null && action.equals("getAllAppointmentByFalse")) {
			List<Appointment> appointList = appointDaoImpl.getAllAppointments(false);
			session.setAttribute("appointList", appointList);
			session.setAttribute("appointActive", true);
			response.sendRedirect("appointmentList.jsp");
		} else if(action != null && action.equals("getAppointmentById")) {
			int appointId = Integer.parseInt(request.getParameter("id"));
			Appointment appoint = appointDaoImpl.getAppointmentById(appointId);
	        String appointJsonString = this.gson.toJson(appoint);
	        
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(appointJsonString);
	        out.flush();  
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		if(action != null && action.equals("inputAppointment")) {
			Appointment appoint = new Appointment();
			String appointId = request.getParameter("inputAppointId");
			appoint.setDoctorId(Integer.parseInt(request.getParameter("inputDoctorId")));
			appoint.setUserId(Integer.parseInt(request.getParameter("inputUserId")));
			appoint.setDate(LocalDate.parse(request.getParameter("inputDate")));
			appoint.setTimeSlot(request.getParameter("inputTimeSlot"));
			appoint.setDescription(request.getParameter("inputDescription"));
						
			boolean check = false;
			if(appointId.length() > 0) {
				appoint.setAppointId(Integer.parseInt(appointId));
				check = appointDaoImpl.updateAppointment(appoint);
			} else {
				check = appointDaoImpl.createAppointment(appoint);
			}
			if(check) {
				rd = request.getRequestDispatcher("AppointmentServlet?action=getAllAppointment");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("deleteAppointment")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean check = appointDaoImpl.deleteAppointment(id);
			if(check) {
				rd = request.getRequestDispatcher("AppointmentServlet?action=getAllAppointment");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("activeAppointment")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean check = appointDaoImpl.activateAppointment(id);
			if(check) {
				rd = request.getRequestDispatcher("AppointmentServlet?action=getAllAppointmentByFalse");
				rd.forward(request, response);
			}
		} else if(action != null && action.equals("getAllAppointment")) {
			List<Appointment> appointList = appointDaoImpl.getAllAppointments(true);
			session.setAttribute("appointList", appointList);
			session.setAttribute("appointActive", false);
			response.sendRedirect("appointmentList.jsp");
		} else if(action != null && action.equals("getAllAppointmentByFalse")) {
			List<Appointment> appointList = appointDaoImpl.getAllAppointments(false);
			session.setAttribute("appointList", appointList);
			session.setAttribute("appointActive", true);
			response.sendRedirect("appointmentList.jsp");
		}
	}

}
