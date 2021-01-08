package src.com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
 * Servlet implementation class ShowVehicleServlet
 */
@WebServlet("/ShowVehicleServlet")
public class ShowVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Inventory myInventory = new Inventory();
		
		
		ArrayList<Car> displayInventory = myInventory.readFile();
		session.setAttribute("displayinventory", displayInventory);
		
		ArrayList<Car> unsoldInventory = myInventory.filterByUnsold();
		System.out.println("****" + unsoldInventory.size());
		session.setAttribute("vehicleunsold", unsoldInventory);
		
		System.out.println(unsoldInventory.size() + "***");
		
		ArrayList<Car> soldInventory = myInventory.filterBySold();
		session.setAttribute("vehiclesold", soldInventory);
		
		ArrayList<String> sortByModel = myInventory.filterByModel(unsoldInventory);
		System.out.println(sortByModel);
		Collections.sort(sortByModel);
		session.setAttribute("vehiclemodel", sortByModel);
		
		ArrayList<String> sortByMake = myInventory.filterByMake(unsoldInventory);
		Collections.sort(sortByMake);
		session.setAttribute("vehiclemake", sortByMake);
		
		
	}
	



}
