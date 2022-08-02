package Beans;


import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Stateless
@Entity
public class Staff<T> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Staff_id=null;
	String Staff_name=null;
	String Staff_password=null;
	
	
	@ManyToOne
	@JoinColumn(name="id")
	Admin admin;
	
	@OneToMany(mappedBy="Staff")
	Set<Course> courses;
	
	
	
  public Staff()
	{
		
	}
   public Staff(Long id,String password)
	{
		this.Staff_id=id;
		this.Staff_password=password;
	}
   public Staff(Long id,String name,String password)
	{
		this.Staff_id=id;
		this.Staff_name=name;
		this.Staff_password=password;
	}
   public Long getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(Long staff_id) {
		Staff_id = staff_id;
	}
	public String getStaff_name() {
		return Staff_name;
	}
	public void setStaff_name(String staff_name) {
		Staff_name = staff_name;
	}
	public String getStaff_password() {
		return Staff_password;
	}
	public void setStaff_password(String staff_password) {
		Staff_password = staff_password;
	}
	
	public void set_Admin(Admin admin) {
		this.admin=admin;
	}
	public Admin get_Admin() {
		return admin;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses .addAll(courses);
	}
	public void setCourses(Course course) {
		this.courses .add(course) ;
	}
	
}


