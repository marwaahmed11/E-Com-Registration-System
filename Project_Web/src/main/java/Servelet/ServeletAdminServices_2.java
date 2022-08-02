package Servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Course;
import Services.AdminServices;

/**
 * Servlet implementation class ServeletAdminServices_2
 */
@WebServlet("/ServeletAdminServices_2")
public class ServeletAdminServices_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    AdminServices admin;  
    
   /* public ServeletAdminServices_2() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> s=admin.viewAllStudents();
		String Str=null;
		for(int j=0;j<s.size();j++)
		{
			Str=Str+s.get(j)+"\n";
		}
		
		response.getWriter().append(Str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iCourse=request.getParameter ("CourseId") ;
		long IdCourse=Long.parseLong(iCourse);
		String nCourse=request.getParameter ("CourseName") ;
		String yCourse=request.getParameter ("CourseYear") ;
		int YCours=Integer.parseInt(yCourse);
		Course course=new Course(IdCourse,nCourse,YCours);
		String Str=admin.Create_Course_Account(course);
		response.getWriter().append(Str);
	}

}
