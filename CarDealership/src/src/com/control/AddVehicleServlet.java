package src.com.control;

import java.io.IOException;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.back.Car;
import src.com.back.Inventory;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVehicleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Inventory myInventory = new Inventory();

		Car addInfo = new Car();

		// try-catch for string and boolean values
		String addManufacturer = request.getParameter("manufacturer");
		String addModel = request.getParameter("model");
		String addCondition = request.getParameter("condition");
		String addAvailable = "true";
		String addColor = request.getParameter("color");

		String addDescript = request.getParameter("description");

		String addVIN = request.getParameter("vin");

		try {
			addInfo.setCarMan(addManufacturer);
			addInfo.setCarModel(addModel);

			if (addCondition != "select") {
				addInfo.setCarCondition(addCondition);
			}

			boolean available = false;

			if (addAvailable.equals("true")) {
				available = true;
				addInfo.setAvailable(available);
			}

			addInfo.setCarColor(addColor);

			addInfo.setCarDescription(addDescript);

			addInfo.setCarVIN(addVIN);
			
			LocalDate defPurDate = LocalDate.now();
			addInfo.setDateOfPurchase(defPurDate);
			
			addInfo.setCustID(000000);
		} catch (NullPointerException str) {

		}

		// try catch for integers and dates
		String addYear = request.getParameter("year");
		String addPrice = request.getParameter("price");
		String addMileage = request.getParameter("mileage");
		LocalDate addInventory = LocalDate.now();

		try {
			Integer changeYear = (Integer.parseInt(addYear));
			addInfo.setCarYear(changeYear);

			Double changePrice = Double.parseDouble(addPrice);
			addInfo.setCarPrice(changePrice);

			Double changeMileage = (Double.parseDouble(addMileage));
			addInfo.setCarMileage(changeMileage);

			addInfo.setInventoryDate(addInventory);

		} catch (NullPointerException e1) {
			// null somewhere
		} catch (NumberFormatException e2) {
			// not a number - on controlled input - empty field.
		}

		session.setAttribute("color", addColor);

		session.setAttribute("vin", addVIN);

		// separate field for adding an image
		String addImg = request.getParameter("image");
		try {
			addInfo.setCarImage(addImg);
			session.setAttribute("image", addImg);
		} catch (Exception ex) {
			request.setAttribute("image", "file upload failed" + addManufacturer + " " + addModel);
		}

		ArrayList<Car> addList = myInventory.readFile();
		
		boolean isFound = false;
		
		for (Car temp : addList) {
			if (addInfo.getCarVIN().equals(temp.getCarVIN())) {
				isFound = true;
			}
		}
		
		if (!isFound) {
			addList.add(addInfo);
			
			String tempString = "";
			for (Car temp : addList) {
				tempString += temp.toString();
			}

			String newCar = myInventory.writeInventory(tempString);
			session.setAttribute("vehicle", newCar);
			session.setAttribute("vehiclenotsold", myInventory.filterByUnsold());
			session.setAttribute("vehiclesold", myInventory.filterBySold());

			RequestDispatcher rs = request.getRequestDispatcher("reporting.jsp");
			rs.forward(request, response);
			
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("addvehicle.jsp");
			rs.forward(request, response);
		}

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
