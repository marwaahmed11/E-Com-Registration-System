package Beans;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Stateless
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Course_id=null;
	
	String Course_name=null;
	int Course_year=0;
	float Course_grade=-1;
	
	
	@ManyToOne
	@JoinColumn(name="Staff_id")
	Staff staff;
	
	
	@ManyToOne
	@JoinColumn(name="Admin_id")
	Admin admin;
	
	@ManyToMany(mappedBy="Course")
	 private Set<Student> students;
	
	
	public Course()
	{
		
	}
	public Course(Long id,String name,int year)
	{
		 this.Course_id=id;
		 this.Course_name=name;
		 this.Course_year=year;
	}
	public Long getCourse_id() {
		return Course_id;
	}
	public void setCourse_id(Long course_id) {
		Course_id = course_id;
	}
	public String getCourse_name() {
		return Course_name;
	}
	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}
	public int getCourse_year() {
		return Course_year;
	}
	public void setCourse_year(int course_year) {
		Course_year = course_year;
	}
	
	public void setCourse_grade(float course_grade) {
		Course_grade = course_grade;
	}
	public float getCourse_grade() {
		return Course_grade;
	}
	
	public void set_admin(Admin admin) {
		this.admin=admin;
	}
	public Admin get_admin() {
		return admin;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students .addAll(students) ;
	}
	public void setStudents(Student student) {
		this.students.add(student);
	}
}