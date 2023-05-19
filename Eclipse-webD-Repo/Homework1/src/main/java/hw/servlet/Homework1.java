package hw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import hw.model.DoseEntry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DosesHomepage
 */
@WebServlet(urlPatterns = "/DosesHomepage", loadOnStartup = 1)
public class Homework1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        List<DoseEntry> entries = new ArrayList<DoseEntry>();
        
        entries.add(new DoseEntry(
        		"Pfizer/BioNTech",
        		2,
        		21,
        		10000,
        		10000
        		));
        
        entries.add(new DoseEntry(
        		"Johnson & Johnson",
        		1,
        		0,
        		5000,
        		5000
        		));

        getServletContext().setAttribute( "entries", entries );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<DoseEntry> entries = (List<DoseEntry>) getServletContext()
	            .getAttribute( "entries" );
		
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Dose Record</title></head><body>" );
        out.println("<h2>Dose Record</h2>");
        
        out.println("<p><a href='NewVaccine1'>New Vaccine</a> "+
        				"| <a href='NewDoses1'>New Doses</a></p>");
        
        out.println("<table border='1' cellpadding='5'");
        
        out.println("<th>");
    	
    	out.println( "<td style='text-align:center; font-weight:bold;'>Vaccine</td>" );
    	out.println( "<td style='text-align:center; font-weight:bold;'>Doses Required</td>" );
    	out.println( "<td style='text-align:center; font-weight:bold;'>Days Between Doses</td>" );
    	out.println( "<td style='text-align:center; font-weight:bold;'>Total Doses Received</td>" );
    	out.println( "<td style='text-align:center; font-weight:bold;'>Total Doses Left</td>" );
    	out.println("<td></td>");
    	
    	out.println("</th>");
        
        for ( DoseEntry e : entries)
        {
        	out.println("<tr>");
        	
        	out.println( "<td>" + e.getVaccineName() + "</td>" );
            out.println( "<td>" + e.getDosesRequired() + "</td>" );
            out.println( "<td>" + e.getDaysBetweenDoses() + "</td>" );
            out.println( "<td>" + e.getTotalDoses() + "</td>" );
            out.println( "<td>" + e.getDosesRemaining() + "</td>" );
            out.println("<td><a href='EditVaccine1?id=" + e.getId() + "'>Edit</a></td>");
        	
        	out.println("</tr>");
        }
        
        out.println("</table>");
        
        out.println( "</body></html>" );
	}
}