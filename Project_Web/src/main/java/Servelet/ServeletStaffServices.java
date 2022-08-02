package Servelet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Course;
import Beans.Student;
import Services.StaffServices;
import Services.StudentServices;


@WebServlet("/ServeletStaffServices")
public class ServeletStaffServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    StaffServices staff;
    
    /*public ServeletStaffServices() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter ("StaffID") ;
		long Id=Long.parseLong(i);
		ArrayList<Student>s=staff.viewAllStudentInMYCourse(Id);
        String Str=null;
		
		
		for(int j=0;j<s.size();j++)
		{
			Str=Str+s.get(j).getStudent_name()+" "+s.get(j).getStudent_id()+" "+s.get(j).getStudent_year()+"\n";
		}
		response.getWriter().append(Str);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String i=request.getParameter ("StaffID") ;
		long Id=Long.parseLong(i);
		String iStudent=request.getParameter ("StudentID") ;
		long IdStudent=Long.parseLong(iStudent);
		String iCourse=request.getParameter ("CourseID") ;
		long IdCourse=Long.parseLong(iCourse);
		String g=request.getParameter ("grade") ;
		float grade=Float.parseFloat(g);
	    String Str=	staff.setGrade(Id, IdStudent, IdCourse, grade);
	    response.getWriter().append(Str);
	}

}
