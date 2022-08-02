package Services;

import java.util.ArrayList;
import java.util.Set;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import Beans.Staff;

public interface Staff_Interface {
	public String loginAsStaff(Long id,String pass);
	public String setGrade(Long Staff_id,Long Student_id,Long Course_id,float grade);
	public ArrayList<Student> viewAllStudentInMYCourse(Long Staff_id);

}
