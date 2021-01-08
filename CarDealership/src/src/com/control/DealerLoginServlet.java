package src.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.back.Employee;

/**
 * Servlet implementation class DealerLoginServlet
 */
@WebServlet("/DealerLoginServlet")
public class DealerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Employee dealerinfo = new Employee();
		
		String dealerusername = request.getParameter("username");
		if (dealerusername != null) {
			dealerinfo.setSalesUserName(dealerusername);
		}
		String dealerpassword = request.getParameter("password");
		if (dealerpassword != null) {
			dealerinfo.setSalesPassword(dealerpassword);
		}
		//String dealerID= request.getParameter("userid");
		//ASK
		//dealerinfo.setSalesID();
		
		
		if (dealerusername.isEmpty() || dealerpassword.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("dealerlogin.jsp");
			rd.include(request, response);
		}
		else
		{
			
			@SuppressWarnings("unchecked")
			ArrayList<Employee> dealerList = (ArrayList<Employee>)session.getAttribute("dealerlist");
			if (dealerList == null) {
				dealerList = new ArrayList<Employee>();
			}
			dealerList.add(dealerinfo);
			
			dealerinfo.setSalesUserName(dealerusername);
			dealerinfo.setSalesPassword(dealerpassword);
			session.setAttribute("myprofile", dealerinfo);
			session.setAttribute("username", dealerusername);
			session.setAttribute("password", dealerpassword);
			//session.setAttribute("userid", dealerID);
			RequestDispatcher rd = request.getRequestDispatcher("dealerprofile.jsp");
			rd.forward(request, response);
		}
	}

}
