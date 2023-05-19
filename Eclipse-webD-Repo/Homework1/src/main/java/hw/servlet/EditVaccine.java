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
 * Servlet implementation class EditVaccine
 */
@WebServlet("/EditVaccine1")
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
		int idRecieved = Integer.parseInt(request.getParameter("id"));

		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		
		DoseEntry target = null;
		for (DoseEntry e: entries)
		{
			if (e.getId() == idRecieved)
				target = e;
		}
		
		if (target == null)
		{
			//TODO:Fatal Error, 404?
		}
		
		
		
		//(target.getDosesRequired() == 1) ? "selected" : ""
		

		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Edit Vaccine</title></head><body>" );
        out.println("<form method='POST' action='EditVaccine1'><table border=1 cellpadding=2>");
        
        out.println("<input name='id' type='text' value="+idRecieved+" style='visibility:hidden; height:0; width:0;'>");
        
        out.println("<tr><th align='center' style='font-weight:bold;'>Name</td><td><input type='text' name='name' value="+target.getVaccineName()+"></input></td></tr>");
        
        out.println("<tr><th align='center' style='font-weight:bold;'>Doses Required</td><td>");
        out.println("<select name='numOfDoses'>");
        if (target.getDosesRequired() == 1)
        {

            out.println("<option value=1 selected>1</option>");
            out.println("<option value=2>2</option>");
        }
        else
        {

            out.println("<option value=1>1</option>");
            out.println("<option value=2 selected>2</option>");
        }
        out.println("</select>");
        out.println("</td></tr>");

        out.println("<tr><th align='center' style='font-weight:bold;'>Days Between Doses</td><td><input type='text' name='DaysBetween' value="+target.getDaysBetweenDoses()+"></input></td></tr>");
        
        out.println("<tr><td colspan=2><button type='submit'>Save</button></td></tr>");
        
        out.println("</table></form></body></html>");


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
		
		response.sendRedirect("DosesHomepage");
	}

}
