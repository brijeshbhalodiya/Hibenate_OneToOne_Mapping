package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Person;
import com.bean.PersonDetail;
import com.dao.PersonDao;
import com.util.PersonUtil;

@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("insert")) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			
			PersonDetail pd = new PersonDetail();
			pd.setFname(fname);
			pd.setLname(lname);
			pd.setEmail(email);
			PersonDao.insertPersonDetail(pd);
			
			Person p = new Person();
			p.setpDetail(pd);
			PersonDao.insertPersonDetail(p);
			System.out.println("Data Inserted");
			
			response.sendRedirect("show.jsp");
			
		}else if(action.equalsIgnoreCase("edit")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			Person p = PersonDao.findById(pid);
			request.setAttribute("Person", p);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("update")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			Person p = PersonDao.findById(pid);
			PersonDetail pd = p.getpDetail();
			pd.setFname(request.getParameter("fname"));
			pd.setLname(request.getParameter("lname"));
			pd.setEmail(request.getParameter("email"));
			p.setpDetail(pd);
			PersonDao.doUpdatePerson(p);
			response.sendRedirect("show.jsp");
		}else if(action.equalsIgnoreCase("delete")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			PersonDao.deletePerson(pid);
			response.sendRedirect("show.jsp");
		}
		
		
	}

}
