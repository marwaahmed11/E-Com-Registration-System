package Servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.StaffServices;

/**
 * Servlet implementation class ServeletLoginStaff
 */
@WebServlet("/ServeletLoginStaff")
public class ServeletLoginStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB  
    StaffServices staff; 
    
   /* public ServeletLoginStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String i=request.getParameter ("StaffID") ;
		long Id=Long.parseLong(i);
		String p=request.getParameter ("StaffPassword") ;
		
		
		String a=staff.loginAsStaff(Id, p);
		if(a=="Login Success")
		{
		response.sendRedirect(request. getContextPath() + "/Staff.jsp");
		}
		else
		{
		response.getWriter().append(request.getContextPath()+"/LoginStaff.jsp");
		}
	}

}
