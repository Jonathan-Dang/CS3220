package hw2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw2.model.DoseEntry;
import hw2.model.PatientEntry;

/**
 * Servlet implementation class NewPatient
 */
@WebServlet("/NewPatient")
public class NewPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName = request.getParameter("pName");
		int vaccineId = Integer.parseInt(request.getParameter("vaccine"));
		
		ArrayList<PatientEntry> pEntries = (ArrayList<PatientEntry>) getServletContext().getAttribute("pEntries");
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		
		PatientEntry pE = new PatientEntry(pName, vaccineId);
		for (DoseEntry e : entries)
		{
			if (e.getId() == vaccineId)
			{
				e.useDose();
			}
		}
		pE.setFirst_dose(LocalDate.now());
		pEntries.add(pE);
		
		response.sendRedirect("PatientHomepage");
	}
}
