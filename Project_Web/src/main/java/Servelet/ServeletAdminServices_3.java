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
import Beans.Staff;
import Services.AdminServices;

/**
 * Servlet implementation class ServeletAdminServices_3
 */
@WebServlet("/ServeletAdminServices_3")
public class ServeletAdminServices_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    AdminServices admin;
    
    /*public ServeletAdminServices_3() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course> c= (List<Course>)admin.viewAllCourses();
		String Str=null;
		for(int j=0;j<c.size();j++)
		{
			Str=Str+c.get(j).getCourse_name()+" "+c.get(j).getCourse_id()+" "+c.get(j).getCourse_year()+"\n";
		}
		response.getWriter().append(Str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter ("StaffId") ;
		long Id=Long.parseLong(i);
		String iCourse=request.getParameter ("CourseId") ;
		long IdCourse=Long.parseLong(iCourse);
		String nCourse=request.getParameter ("CourseName") ;
		String yCourse=request.getParameter ("CourseYear") ;
		int YCours=Integer.parseInt(yCourse);
		Course course=new Course(IdCourse,nCourse,YCours);
		Set <Course>courses=null;
		courses.add(course);
		
		Staff staff=admin.Create_Staff_Account(Id, courses);
		String Str="Id:"+staff.getStaff_id()+" "+"Password:"+staff.getStaff_password();
		response.getWriter().append(Str);
	}

}
