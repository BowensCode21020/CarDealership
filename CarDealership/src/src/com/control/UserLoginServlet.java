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

import src.com.back.Person;
import src.com.back.PersonList;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		PersonList plist = new PersonList();
		ArrayList<Person> person = plist.readPerson();
		
		// if the username or password field is empty, the page will
		// stay on the same page.
		if (username.isEmpty() || password.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else
		{ // Will run through written txt file and see if the username and password
			// checks out.
			for (Person tempPerson : person) {
				if (tempPerson.getUsername().equals(username) && tempPerson.getPassword().equals(password)) {
					session.setAttribute("username", tempPerson);
					session.setAttribute("password", tempPerson);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("buyVehicle.jsp");
			rd.forward(request, response);
		}
		
	}

}
