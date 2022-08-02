package Services;

import java.util.Set;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import Beans.Staff;
public interface Student_Interface {
	   public String loginAsStudent(Long id,String pass);
	   public Set<Course> viewAllStudentCourses(Long Student_id);
	   public String registerInCourse(Long Student_id,Course course);
	   
	   
}
