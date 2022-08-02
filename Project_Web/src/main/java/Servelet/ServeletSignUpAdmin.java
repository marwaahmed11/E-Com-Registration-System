package Servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Admin;
import Services.AdminServices;


@WebServlet("/Servelet1")
public class ServeletSignUpAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB  
    AdminServices admin;
    
   /* public Servelet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter ("AdminId") ;
		long Id=Long.parseLong(i);
		String n=request.getParameter("AdminName");
		String p=request.getParameter ("AdminPassword") ;
		Admin ad=new Admin(Id,n,p);
		
		String a=admin.register(ad);
		if(a=="Register Success")
		{
		response.sendRedirect(request. getContextPath() + "/LoginAdmin.jsp");
		}
		else
		{
		response.getWriter().append(request.getContextPath()+"/NewFile.jsp");
		}

	}

}
