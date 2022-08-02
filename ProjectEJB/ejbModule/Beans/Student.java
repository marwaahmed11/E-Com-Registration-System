package Beans;


import java.util.Set;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Session Bean implementation class Student
 */
@Stateless
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Student_id=null;
	
	String Student_name=null;
	String Student_password=null;
	
	String Student_role="Student";
	int Student_year=0;
	
	
	@ManyToOne
	@JoinColumn(name="Admin_id")
	Admin admin;
	
	@ManyToMany
	@JoinTable(
	 name="StudentXCourse",
	 joinColumns=@JoinColumn(name="Student_id"),
	 inverseJoinColumns=@JoinColumn(name="Course_id"))
	Set<Course> course;
	
	public Student()
	{
		
	}
	public Student(Long id,String pass)
	{
		 this.Student_id=id;
		 this.Student_password=pass;
		 
	}
	public Student(Long id,String name,String pass,String role,int year)
	{
		 this.Student_id=id;
		 this.Student_name=name;
		 this.Student_password=pass;
		 this.Student_role=role;
		 this.Student_year=year;
	}
	
	public Long getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(Long student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getStudent_password() {
		return Student_password;
	}
	public void setStudent_password(String student_password) {
		Student_password = student_password;
	}
	public String getStudent_role() {
		return Student_role;
	}
	public void setStudent_role(String student_role) {
		Student_role = student_role;
	}
	public void set_Course(Set<Course> course) {
		this.course.addAll(course);
	}
	public void set_Course(Course course) {
		this.course.add(course);
	}
	public Set<Course>  get_Course() {
		return course;
	}
	public int getStudent_year() {
		return Student_year;
	}
	public void setStudent_year(int student_year) {
		Student_year = student_year;
	}

}