package src.com.control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import src.com.back.Car;
import src.com.back.Inventory;
import src.com.back.Person;
import src.com.back.PersonList;

/**
 * Servlet implementation class BuyVehicle
 */
@WebServlet("/BuyVehicleServlet")
public class BuyVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyVehicleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		// Create values r/t session and parse, etc.
		Inventory myInventory = new Inventory();
		ArrayList<Car> vehicleList = myInventory.readFile();
		PersonList list = new PersonList();
		
		ArrayList<Person> holdInfo = list.readPerson();
		Person buyer = holdInfo.get(0);
		String thisVIN = request.getParameter("carVIN");
		Car selected = (Car) request.getAttribute("detailvehicle");
		
		//new list if null
		if(selected == null) {
			selected = new Car();
		}
		String cardNumber = request.getParameter("cardnumber");
		String bidNumber = request.getParameter("bid");
		
		// determine bid option value, if available
		if (bidNumber != null) {
			
			bidNumber = Double.toString(selected.getCarPrice());
		}
		
		String expMonth = request.getParameter("expirationmonth");
		String expYear = request.getParameter("expirationyear");
		String cardCvv = request.getParameter("cvv");

		for (Car temp : vehicleList) {
			if (temp.getcarVIN().equals(thisVIN)) {
				selected.setCarPrice(temp.getCarPrice());
			}
		}
				
		// try catch number values
		double convBid = selected.getCarPrice();
		try {
			long convCard = Long.parseLong(cardNumber);
			if(bidNumber != null) {
				convBid = Double.parseDouble(bidNumber);
			} 
			int convMonth = Integer.parseInt(expMonth);
			int convCvv = Integer.parseInt(cardCvv);
			int convYear = Integer.parseInt(expYear);
			

			buyer.setCardNumber(convCard);
			selected.setCarPrice(convBid);
			selected.setDateOfPurchase(LocalDate.now());
			selected.setAvailable(false);
			selected.setCustID(buyer.getCustID());
			buyer.setExpirationMonth(convMonth);
			buyer.setExpirationYear(convYear);
			buyer.setCvv(convCvv);
			
		} catch (NullPointerException n) {
			System.out.println(111);
		} catch (NumberFormatException n2) {
			System.out.println(222);
		}
		
		Car soldCar = new Car();
		ArrayList<Car> tempCars = new ArrayList<Car>();
		
		for (Car temp : vehicleList) {
			if (temp.getcarVIN().equals(thisVIN)) {
				soldCar = temp;
				System.out.println("Setting sold car");
				
			} else {
				tempCars.add(temp);
			}
		}
		
		
		soldCar.setAvailable(false);
		soldCar.setCustID(buyer.getCustID());
		
		tempCars.add(soldCar);
		
		myInventory.updateDataFile(tempCars);
		
		session.setAttribute("purchasedcar", soldCar);

		@SuppressWarnings("unchecked")
		ArrayList<Person> cardList = (ArrayList<Person>) session.getAttribute("cardlist");
		if (cardList == null) {
			cardList = new ArrayList<Person>();
		}
			
		ArrayList<Person> people = new ArrayList<Person>();
		for (Person temp : holdInfo) { 
			if (temp.getCustID() != buyer.getCustID()) {
				people.add(temp);
			}
		}
		people.add(buyer);
		
		System.out.println("Buyer card num= " + buyer.getCardNumber());
		
		list.updatePersonFile(people);		

		session.setAttribute("mymoney", cardList);

		RequestDispatcher rd = request.getRequestDispatcher("soldCar.jsp");
		rd.forward(request, response);
	}

}
