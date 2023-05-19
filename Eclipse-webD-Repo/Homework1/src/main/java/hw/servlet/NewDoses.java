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
 * Servlet implementation class NewDoses
 */
@WebServlet("/NewDoses1")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDoses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );

		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>New Doses</title></head><body>" );
        out.println("<form method='POST' action='NewDoses1'><table border=1 cellpadding=2>");
       
        out.println("<tr><th align='center' style='font-weight:bold;'>Vaccine</td><td>");
        out.println("<select name='id'>");
        
        for (DoseEntry e : entries) {
        	String name = e.getVaccineName();
        	out.println("<option value="+e.getId()+">"+name+"</option>");
        }
        
        out.println("</select>");
        out.println("</td></tr>");

        out.println("<tr><th align='center' style='font-weight:bold;'>New Doses Recieved</td><td><input type='text' name='DosesRecieved'></input></td></tr>");
        
        out.println("<tr><td colspan=2><button type='submit'>Save</button></td></tr>");
        
        out.println("</table></form></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int DosesGained = Integer.parseInt(request.getParameter("DosesRecieved") == "" ? "0" : request.getParameter("DosesRecieved"));
		

		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext().getAttribute( "entries" );
		
		for (DoseEntry e: entries)
		{
			if (e.getId() == id )
			{
				e.setTotalDoses(DosesGained + e.getTotalDoses());
				e.setDosesRemaining(DosesGained + e.getDosesRemaining());
			}
		}

		response.sendRedirect("DosesHomepage");
	}

}
