package Servelet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Course;
import Services.StudentServices;

/**
 * Servlet implementation class ServeletStudentServices
 */
@WebServlet("/ServeletStudentServices")
public class ServeletStudentServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    StudentServices Student; 
    
    public ServeletStudentServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter ("StudentID") ;
		long Id=Long.parseLong(i);
		String Str=null;
		
		List<Course> c= (List<Course>) Student.viewAllStudentCourses(Id);
		for(int j=0;j<c.size();j++)
		{
			Str=Str+c.get(j).getCourse_name()+" "+c.get(j).getCourse_id()+" "+c.get(j).getCourse_grade()+"\n";
		}
		response.getWriter().append(Str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter ("StudentID") ;
		long Id=Long.parseLong(i);
		String iCourse=request.getParameter ("CourseID") ;
		long IdCourse=Long.parseLong(iCourse);
		String nCourse=request.getParameter ("CourseName") ;
		String yCourse=request.getParameter ("CourseYear") ;
		int YCours=Integer.parseInt(yCourse);
		Course course=new Course(IdCourse,nCourse,YCours);
		
		response.getWriter().append(Student.registerInCourse(Id, course));
	}

}
