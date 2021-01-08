package src.com.control;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//A user should also be able to search for a type (model) car from the inventory.
//
import javax.servlet.http.HttpSession;

import src.com.back.Car;
//import src.com.back.Inventory;

/**
 * Servlet implementation class FilterByModel
 */
@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterServlet() {
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
		String thisModel = request.getParameter("carmodeldropdown");
		String thisMake = request.getParameter("carmakedropdown");
		
		@SuppressWarnings("unchecked")
		ArrayList<Car> vehicles = (ArrayList<Car>) session.getAttribute("vehicleunsold");
		ArrayList<Car> results = new ArrayList<Car>();
		if (thisMake != null) {
			System.out.println("this is the make!" + thisMake);
			for (Car tempMake : vehicles) {
				if (tempMake.getCarMan().equals(thisMake)) {
					results.add(tempMake);
						
				}
			}
		}
		
		if (thisModel != null) {
			System.out.println("this is the moodle" + thisModel);
			for (Car tempModel : vehicles) {
				if (tempModel.getCarModel().equals(thisModel)) {
					results.add(tempModel);
				}
			}
		}
		System.out.println(results.size() + "***");

		session.setAttribute("results", results);
		
		RequestDispatcher rd = request.getRequestDispatcher("filterAndSort.jsp");
		rd.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}
}
