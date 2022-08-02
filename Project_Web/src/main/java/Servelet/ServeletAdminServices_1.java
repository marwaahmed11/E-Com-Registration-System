package Servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Student;
import Services.AdminServices;
import Services.StudentServices;

/**
 * Servlet implementation class ServeletAdminServices_1
 */
@WebServlet("/ServeletAdminServices_1")
public class ServeletAdminServices_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    AdminServices admin;   
    
   /* public ServeletAdminServices_1() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter ("StudentID") ;
		long Id=Long.parseLong(i);
		ArrayList<String>s=admin.ViewStudentId(Id);
		String Str=null;
		for(int j=0;j<s.size();j++)
		{
			Str=Str+s.get(j)+"\n";
		}
		response.getWriter().append(Str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Student student=admin.Create_Student_Account();
	String Str="Id:"+student.getStudent_id()+" "+"Password:"+student.getStudent_password();
	response.getWriter().append(Str);
	}

}
