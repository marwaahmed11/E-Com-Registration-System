package Services;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import Beans.Admin;
import Beans.Course;
import Beans.Student;
import Beans.Staff;


@Stateful
@Path("/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@RolesAllowed("customer")
public class StudentServices implements Student_Interface{
	@EJB
	@PersistenceContext(unitName="hello")
	EntityManager entitymanager;


	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/loginAsStudent")
	@Override
	public String loginAsStudent(Long Student_id,String Student_pass) {
		
		try {
			Student student=entitymanager.find(Student.class, Student_id);
			if(student!=null)
			{
				if(student.getStudent_password()==Student_pass)
				{
					return "Login Success" ;
				}
				else
					return "Incorrect Password";
					
			
			}
			else
			{
				return "this Student not found";
				
			}
			
		
		/*	
		 * boolean l;
		 * Student student=new Student(id,pass);
			l=entitymanager.contains(student);
			
	    	if(l==true) 
	    	  return "Login Success";
	    	else
	    		return "Error, try again";*/
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
	}

	@GET
    @Path("/viewAllStudentCourses/{id}")
	@Override
	public Set<Course> viewAllStudentCourses(@PathParam("id") Long Student_id) {
		Student student =entitymanager.find(Student.class, Student_id);
		if(student!=null)
		{
			
		return student.get_Course();
		}
		else
		{
			System.out.println("this Student not found");
			return null;
		}
	}

	@POST
    @Path("/registerInCourse")
	@Override
	public String registerInCourse(Long Student_id,Course course) {
		Student student=entitymanager.find(Student.class, Student_id);
		if(student!=null)
		{
			if(student.getStudent_year()>=course.getCourse_year())
			{
				student.set_Course(course);
				return "Registration Success found";
			}
			else
				return "this course not available for your year";
		}
		else
			return "this Student not found";
	}



}
