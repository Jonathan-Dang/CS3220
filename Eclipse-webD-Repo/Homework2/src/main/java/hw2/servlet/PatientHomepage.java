package hw2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw2.model.DoseEntry;
import hw2.model.PatientEntry;

/**
 * Servlet implementation class PatientHomepage
 */
@WebServlet("/PatientHomepage")
public class PatientHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/PatientHomepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("pId") == "" ? "-1" :
			request.getParameter("pId").strip());
		ArrayList<PatientEntry> pEntries = (ArrayList<PatientEntry>) getServletContext().getAttribute("pEntries");
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		
		for (PatientEntry e : pEntries)
		{
			if (e.getId() == pId)
			{
				for (DoseEntry entry : entries)
				{
					if (e.getVaccineId() == entry.getId())
					{
						entry.useDose();
						e.setSecond_dose(LocalDate.now());
					}
				}
			}
		}
		doGet(request, response);
	}

}
