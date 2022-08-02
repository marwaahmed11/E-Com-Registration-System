package Services;

import java.util.ArrayList;
import java.util.Set;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import Beans.Staff;

public interface Admin_Interface {
   public String register(Admin admin);
   public String loginAsAdmin(Long Admin_id,String Admin_pass);
   
   public Student Create_Student_Account ();
   public Staff Create_Staff_Account (Long Id,Set<Course>courses);
   public String Create_Course_Account(Course course);
   
   public Set<Course>  ViewStudentId1(Long Student_id);
   public ArrayList<String>  ViewStudentId(Long Student_id);
   
   public Set<Student> viewAllStudents1();
   public ArrayList<String> viewAllStudents();
   
   public Set<Course> viewAllCourses();
   

}
