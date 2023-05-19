package hw2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw2.model.DoseEntry;

/**
 * Servlet implementation class EditVaccine
 */
@WebServlet("/EditVaccine2")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/EditVaccine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idRecieved = Integer.parseInt(request.getParameter("id"));

		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		
		DoseEntry target = null;
		for (DoseEntry e: entries)
		{
			if (e.getId() == idRecieved)
				target = e;
		}
		

		String name = request.getParameter("name");
		String rawDaysBetween = request.getParameter("DaysBetween");
		int Doses = Integer.parseInt(request.getParameter("numOfDoses"));
		int daysBetween = (rawDaysBetween.length() < 1) ? 0 : Integer.parseInt(rawDaysBetween);
		
		target.setVaccineName(name);
		target.setDosesRequired(Doses);
		target.setDaysBetweenDoses(daysBetween);
		
		response.sendRedirect("DosesHomepage2");
	}

}
