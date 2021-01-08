package src.com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.back.Car;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String searchValue = request.getParameter("searchbutton");

		@SuppressWarnings("unchecked")
		ArrayList<Car> search = (ArrayList<Car>) session.getAttribute("vehicleunsold");
		ArrayList<Car> storeValue = new ArrayList<Car>();
		
		for(Car tempSearch : search) {
			if (tempSearch.getCarModel().toLowerCase().contains(searchValue.toLowerCase())) {
				storeValue.add(tempSearch);
				System.out.println(search.size() + "***");
			}
		}
		
		for(Car tempSearch : search) {
			if (tempSearch.getCarMan().toLowerCase().contains(searchValue.toLowerCase())) {
				storeValue.add(tempSearch);
				System.out.println(search.size() + "***");
			}
		}
		System.out.println("**********Find Me*********" + searchValue);

		session.setAttribute("search", storeValue);
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
