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

/**
 * Servlet implementation class ServeletLoginAdmin
 */
@WebServlet("/ServeletLoginAdmin")
public class ServeletLoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    AdminServices admin; 
    
    /*public ServeletLoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter ("AdminId") ;
		long Id=Long.parseLong(i);
		String p=request.getParameter ("AdminPassword") ;
		
		
		String a=admin.loginAsAdmin(Id, p);
		if(a=="Login Success")
		{
		response.sendRedirect(request. getContextPath() + "/Admin.jsp");
		}
		else
		{
		response.getWriter().append(request.getContextPath()+"/LoginAdmin.jsp");
		
		}
	}

}
