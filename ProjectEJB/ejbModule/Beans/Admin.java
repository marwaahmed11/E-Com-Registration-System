package Beans;


import java.util.Set;


import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Session Bean implementation class Admin
 */
@Stateless
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Admin_id=null;
	String Admin_name=null;
	String Admin_password=null;
	String Admin_role="Admin";
	
	@OneToMany(mappedBy="Admin")
	Set<Staff> staff;
	
	@OneToMany(mappedBy="Admin")
	Set<Student> student;
	
	@OneToMany(mappedBy="Admin")
	Set<Course> course;
	
	public Admin()
	{
		
	}
	public Admin(Long id,String name,String pass)
	{
		 this.Admin_id=id;
		 this.Admin_name=name;
		 this.Admin_password=pass;
		 //this.Admin_role=role;
	}
	public Long getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(Long admin_id) {
		Admin_id = admin_id;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getAdmin_password() {
		return Admin_password;
	}
	public void setAdmin_password(String admin_password) {
		Admin_password = admin_password;
	}
	public String getAdmin_role() {
		return Admin_role;
	}
	public void setAdmin_role(String admin_role) {
		Admin_role = admin_role;
	}
	public void set_Staff(Set<Staff> staff) {
		this.staff.addAll(staff);
	}
	public void set_Staff(Staff staff) {
		this.staff.add(staff);
	}
	public Set<Staff>  get_Staff() {
		return staff;
	}
	public void set_Course(Set<Course> course) {
		this.course.addAll(course);
	}
	public void set_Course(Course course) {
		this.course.add(course);
	}
	public Set<Course> get_Course() {
		return course;
	}
	public void set_Student(Set<Student> student) {
		this.student.addAll(student);
	}
	public void set_Student(Student student) {
		this.student.add(student);
	}
	public Set<Student> get_Student() {
		return student;
	}

}