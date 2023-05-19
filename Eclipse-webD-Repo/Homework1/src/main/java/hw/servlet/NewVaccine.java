package hw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw.model.DoseEntry;

/**
 * Servlet implementation class NewVaccine
 */
@WebServlet("/NewVaccine1")
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

		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>New Vaccine</title></head><body>" );
        out.println("<form method='POST' action='NewVaccine1'><table border=1 cellpadding=2>");
        
        out.println("<tr><th align='center' style='font-weight:bold;'>Name</td><td><input type='text' name='name'></input></td></tr>");
        
        out.println("<tr><th align='center' style='font-weight:bold;'>Doses Required</td><td>");
        out.println("<select name='numOfDoses'>");
        out.println("<option value=1>1</option>");
        out.println("<option value=2>2</option>");
        out.println("</select>");
        out.println("</td></tr>");

        out.println("<tr><th align='center' style='font-weight:bold;'>Days Between Doses</td><td><input type='text' name='DaysBetween'></input></td></tr>");
        
        out.println("<tr><td colspan=2><button type='submit'>Add</button></td></tr>");
        
        out.println("</table></form></body></html>");
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
		

		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		entries.add(new DoseEntry(name, Doses, daysBetween,0,0));
		
		response.sendRedirect("DosesHomepage");
	}

}
