package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
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
@Singleton
@Path("/admin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("admin")
public class AdminServices implements Admin_Interface{

	//@EJB
	@PersistenceContext(unitName="hello")
	EntityManager entitymanager;
	
	/*@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		
	   return "Login Success";
	    	
	}*/
    private static String generatePassword(int length) {
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      
	      String pass = String.valueOf(password);
	      return pass;
	   }
    
    
    
	@Override
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	public String register(Admin admin)  {
	     try {
	    	 entitymanager.persist(admin);
	    	 return "Register Success";
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
	     
	   }

	@Override
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/loginAsAdmin")
	public String loginAsAdmin(Long Admin_id,String Admin_pass) {
		try {
			Student student=entitymanager.find(Student.class,Admin_id);
			if(student!=null)
			{
				if(student.getStudent_password()==Admin_pass)
				{
					return "Login Success" ;
				}
				else
					return "Incorrect Password";
					
			
			}
			else
			{
				return "this Admin not found";
				
			}
			
			/*boolean l;
			try {
				l=entitymanager.contains(admin);
		    	if(l==true) 
		    	  return "Login Success";
		    	else
		    		return "Error, try again";
		     }catch(Exception e) {
		    	 throw new EJBException (e);
		     }*/
		
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
		
	}
	
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Create_Student_Account")
	@Override
	public Student Create_Student_Account() {
		  int min = 1;
	      int max = 10000;
	        
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		  String s= String.format("%05d", random_int);
		  long Id=Long.parseLong(s);
		 String pass =generatePassword(7);
		 Student student=new Student(Id,pass);
		// TODO Auto-generated method stub
		 try {
	    	 entitymanager.persist( student);
	    	 return student;
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
		
	}
	
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Create_Staff_Account")
	@Override
	public Staff Create_Staff_Account(Long Id,Set<Course>courses) {
		
		/* int min = 1;
	     int max = 10000;
	        
	     int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		 String s= String.format("%05d", random_int);
		 long Id=Long.parseLong(s);*/
		 String pass =generatePassword(7);
		 Staff staff=new Staff(Id,pass);
		 staff.setCourses(courses);
		
		 try {
	    	 entitymanager.persist( staff);
	    	 return staff;
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
		
	}
	
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Create_Course_Account")
	@Override
	public String Create_Course_Account(Course course) {
		try {
	    	 entitymanager.persist(course);
	    	 return "Register Success";
	     }catch(Exception e) {
	    	 throw new EJBException (e);
	     }
	}
	
	
	@GET
	@Path("/ViewStudentId/{id}")
	@Override
	public ArrayList<String> ViewStudentId(@PathParam("id") Long Student_id) {
		Student student=entitymanager.find(Student.class, Student_id);
		ArrayList<String> Str=new ArrayList<String>();
		if(student!=null)
		{
			
			List<Course> c= (List<Course>) student.get_Course();
			for(int i=0;i<c.size();i++)
			{
				if(c.get(i).getCourse_grade()>=50)
				{
					Str.add(c.get(i).getCourse_name()+" passed");
				}
				else if(c.get(i).getCourse_grade()==-1)
				{
					Str.add(c.get(i).getCourse_name()+" current");
				}
			}
			return Str;
			
		}
		else
		{
			System.out.println("this Student not found");
			return null;
		}
		
	}
	
	@GET
	@Path("/ViewStudentId1/{id}")
	@Override
	public Set<Course> ViewStudentId1(@PathParam("id") Long Student_id) {
		Student student=entitymanager.find(Student.class, Student_id);
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
	
	
	@GET
	@Path("/viewAllStudents")
	@Override
	public ArrayList<String> viewAllStudents() {
		TypedQuery<Student> query=entitymanager.createQuery("SELECT p FROM Student p",Student.class);
		//return (Set<Student>) query.getResultList();
		int k=0;
		List<Student> s= query.getResultList();
		ArrayList<String> Str=new ArrayList<String>();
		for(int i=0;i<s.size();i++)
		{
			List<Course> c=(List<Course>) s.get(i).get_Course();
			for(int j=0;j<c.size();j++)
			{
				if(c.get(j).getCourse_grade()>=50)
				{
					k++;
				}
				
			}
			Str.add(s.get(i).getStudent_name()+s.get(i).getStudent_id()+k);
			k=0;
		}
		return Str;
	}
	
	
	@GET
	@Path("/viewAllStudents1")
	@Override
	public Set<Student> viewAllStudents1() {
		TypedQuery<Student> query=entitymanager.createQuery("SELECT p FROM Student p",Student.class);
		return (Set<Student>) query.getResultList();
		
	}
	
	@GET
	@Path("/viewAllCourses")
	@Override
	public Set<Course> viewAllCourses() {
		TypedQuery<Course> query=entitymanager.createQuery("SELECT p FROM Course p",Course.class);
		return (Set<Course>) query.getResultList();
	}
	
	

}
