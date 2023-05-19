package lab9.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lab9.model.DoseEntry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DosesHomepage
 */
@WebServlet(urlPatterns = "/updated-doses-homepage", loadOnStartup = 1)
public class DosesHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DosesHomepage() {
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
		request.getRequestDispatcher("/WEB-INF/jsps/DosesHomepage2.jsp").forward(request, response);
	}
}