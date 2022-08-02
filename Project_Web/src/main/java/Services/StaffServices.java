package Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Beans.Admin;
import Beans.Course;
import Beans.Staff;
import Beans.Student;
@MessageDriven
@Path("/staff")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@RolesAllowed("admin")
public class StaffServices implements Staff_Interface{

	@EJB
	@PersistenceContext(unitName="hello")
	EntityManager entitymanager;
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/loginAsStaff")
	@Override
	public String loginAsStaff(Long Staff_id,String Staff_pass) {
		try {
			Staff staff=entitymanager.find(Staff.class, Staff_id);
			if(staff!=null)
			{
				if(staff.getStaff_password()==Staff_pass)
				{
					return "Login Success" ;
				}
				else
					return "Incorrect Password";
					
			
			}
			else
			{
				return "this Staff not found";
				
			}
		/*boolean l;
		try {
			Staff staff=new Staff(id,pass);
			l=entitymanager.contains(staff);
			
	    	if(l==true) 
	    	  return "Login Success";
	    	else
	    		return "Error, try again";*/
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
	}

	@POST
	@Path("/setGrade")
	@Override
	public String setGrade(Long Staff_id,Long Student_id,Long Course_id,float grade) {
		Staff staff=entitymanager.find(Staff.class, Staff_id);
		
		if(staff!=null)
		{
			List<Course> c= (List<Course>) staff.getCourses();
			for(int i=0;i<c.size();i++)
			{
				if(c.get(i).getCourse_id()==Course_id)
				{
				     List<Student> s=(List<Student>)c.get(i).getStudents();
				     for(int j=0;j<s.size();j++)
						{
				    	    if( s.get(j).getStudent_id()==Student_id) 
				    	    {
				    		  c.get(i).setCourse_grade(grade);
				    		  return "Grade added Successfully";
				    	    }
						}
				}
			}
		}
		else
		{
			return "this Staff not found";
			
		}
		return null;

		
	}
	
	@GET
	@Path("/viewAllStudentInMYCourse")
	@Override
	public ArrayList<Student> viewAllStudentInMYCourse(Long Staff_id) {
		Staff staff=entitymanager.find(Staff.class, Staff_id);
		ArrayList<Student> s=new ArrayList<Student>();
		if(staff!=null)
		{
			List<Course> c= (List<Course>) staff.getCourses();
			for(int i=0;i<c.size();i++)
			{
			s.addAll(i,c.get(i).getStudents());
			}
			return s;
		
		}
		else
		{
			System.out.println("this Staff not found");
			return null;
		}

		
		
	}

}
