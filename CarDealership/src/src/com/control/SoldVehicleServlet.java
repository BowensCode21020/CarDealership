package src.com.control;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SoldVehicleServlet
 */
@WebServlet("/SoldVehicleServlet")
public class SoldVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoldVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);	

		String person = request.getParameter("sort");
		
		@SuppressWarnings("unchecked")
		ArrayList<Car> invoiceCar = (ArrayList<Car>) request.getAttribute("detailvehicle");
		

		@SuppressWarnings("unchecked")
		ArrayList<Person> invoicePerson = (ArrayList<Person>) request.getAttribute("personlist");
		
		@SuppressWarnings("unchecked")
		Person invoiceCard = (Person) request.getAttribute("cardlist");
		Person addPerson = new Person();
		Car addPurchased = new Car();
		PersonList fullList = new PersonList();

		ArrayList<Person> fullListing =  fullList.readPerson();
		if (fullListing == null) {
			fullListing = new ArrayList<Person>();
		}
		
		fullListing.add(invoiceCard);
		
		String tempPerson = "";
		for (Person temp : fullListing) {
			tempPerson += temp.toString();
		}
		
		String newPerson = fullList.writePerson(tempPerson);
		
		session.setAttribute("addedcard", newPerson);

		
		
//		for (Person temp : personCardList) {
//			if(temp.getCustID() = invoiceCard.getCustID())) {
//				
//			}
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
