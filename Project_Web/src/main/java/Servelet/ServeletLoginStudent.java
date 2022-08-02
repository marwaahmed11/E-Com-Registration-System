package Servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.StudentServices;

/**
 * Servlet implementation class ServeletLoginStudent
 */
@WebServlet("/ServeletLoginStudent")
public class ServeletLoginStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    StudentServices Student; 
    
    /*public ServeletLoginStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter ("StudentID") ;
		long Id=Long.parseLong(i);
		String p=request.getParameter ("StudentPassword") ;
		
		
		String a=Student.loginAsStudent(Id, p);
		if(a=="Login Success")
		{
		response.sendRedirect(request. getContextPath() + "/Student.jsp");
		}
		else
		{
		response.getWriter().append(request.getContextPath()+"/LoginStudent.jsp");
		}
	}

}
