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

import src.com.back.Car;
import src.com.back.Person;
import src.com.back.PersonList;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		Person holdInfo = new Person();
		PersonList myPerson = new PersonList();
		
		String firstname = request.getParameter("firstname");
		if (firstname != null) {
			holdInfo.setFirstName(firstname);
		}
		
		String lastname = request.getParameter("lastname");
		if (lastname != null) {
			holdInfo.setLastName(lastname);
		}
		
		String street = request.getParameter("street");
		if (street != null) {
			holdInfo.setStreet(street);
		}
		
		String city = request.getParameter("city");
		if (city != null) {
			holdInfo.setCity(city);
		}
		
		String state = request.getParameter("state");
		if (state != null) {
			holdInfo.setState(state);
		}
		
		String zip = request.getParameter("zip");
		if (zip != null) {
			int tempZip = Integer.parseInt(zip);
			holdInfo.setZip(tempZip);
		}
		
		String phonenumber = request.getParameter("phonenumber");
		if (phonenumber != null) {
			long tempPhone = Long.parseLong(phonenumber);
			holdInfo.setPhoneNumber(tempPhone);
		}
		
		String username = request.getParameter("username");
		if (username != null) {
			holdInfo.setUsername(username);
		}
		String password = request.getParameter("password");
		if (password != null) {
			holdInfo.setPassword(password);
		}
			
		
		if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty()
				|| street.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty() || 
				phonenumber.isEmpty()) {
			
			RequestDispatcher rd2 = request.getRequestDispatcher("newuser.jsp");
			rd2.include(request, response);
		}
		else 
		{
			ArrayList<Person> fullListing = myPerson.readPerson();
			
			fullListing.add(holdInfo);
			PersonList newGuyOrGal = new PersonList();

			String tempString = "";
			for (Person temp : fullListing) {
				tempString += temp.toString();
			}

			String newPerson = newGuyOrGal.writePerson(tempString);
			
			session.setAttribute("addedperson", newPerson);
			session.setAttribute("firstname", firstname);
			session.setAttribute("lastname", lastname);
			
			session.setAttribute("username", username);
			session.setAttribute("phonenumber", phonenumber);
			session.setAttribute("password", password);
			session.setAttribute("personlist", fullListing);
			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}

	}

}
