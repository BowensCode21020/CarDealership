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

/**
 * Servlet implementation class DetailVehicleServlet
 */
@WebServlet("/DetailVehicleServlet")
public class DetailVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thisVIN = request.getParameter("carVIN");
		
		HttpSession session = request.getSession(true);
		
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("vehicleunsold");
		
		for(Car tempCar : cars) {
			if (tempCar.getcarVIN().equals(thisVIN)) {
				session.setAttribute("detailvehicle", tempCar);
				session.setAttribute("over120", tempCar.isBidWorthy());
				System.out.println(cars.size() + "***");
			}
		}
		
		RequestDispatcher rdif = request.getRequestDispatcher("detail.jsp");
		rdif.forward(request, response);
	}

}
