package hw3.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3.connector.DBConnector;
import hw3.model.DoseEntry;

/**
 * Servlet implementation class NewVaccine
 */
@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewVaccine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String rawDaysBetween = request.getParameter("DaysBetween");
		int Doses = Integer.parseInt(request.getParameter("numOfDoses"));
		int daysBetween = (rawDaysBetween.length() < 1) ? 0 : Integer.parseInt(rawDaysBetween);
		
		
		DBConnector db = new DBConnector();
		db.addVaccine(name, daysBetween, 0, Doses);
		db.close();
		
		response.sendRedirect("DosesHomepage");
	}

}
