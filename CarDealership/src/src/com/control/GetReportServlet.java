package src.com.control;

//The application to have a reporting section which display information about all transactions made, 
//including the person who purchase the car. 
//This reporting page should order transaction by date starting with the most recent purchase.

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.back.Car;
import src.com.back.Inventory;
import src.com.back.Person;
import src.com.back.PersonList;

/**
 * Servlet implementation class ReportVehicles
 */
@WebServlet("/ReportVehicles")
public class GetReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Inventory myInventory = new Inventory();
		PersonList myPerson = new PersonList();
		
		Car myCar = new Car();
		ArrayList<Car> displayReports = myInventory.readFile();
		session.setAttribute("report", displayReports);
		
		ArrayList<Car> unsoldInventory = myInventory.filterByUnsold();
		session.setAttribute("vehicleunsold", unsoldInventory);
		
		ArrayList<Car> soldInventory = myInventory.filterBySold();
		session.setAttribute("vehiclesold", soldInventory);		
				
		ArrayList<Person> displayPerson = myPerson.readPerson();
		ArrayList<Person> result = new ArrayList<Person>();
		Person sold = new Person();

		// trying to match up the customer ID in Car with the customer ID in Person
		for (Person temp : displayPerson) {
			if (temp.getCustID() == myCar.getCustID()) {
				sold = temp;
				System.out.println("Compile list of people sold to");
			} else {
				result.add(temp);
			}

		}
		
		result.add(sold);
		
		session.setAttribute("person", result);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
