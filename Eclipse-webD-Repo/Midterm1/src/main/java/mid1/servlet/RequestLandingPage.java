package mid1.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import mid1.model.Request;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestLandingPage
 */
@WebServlet(urlPatterns = "/RequestLandingPage", loadOnStartup = 1)
public class RequestLandingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLandingPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add( new Request(
        		"John Doe",
        		"Computers",
        		"Completed",
        		"2022-10-27 11:30 AM",
        		"Amy",
        		"Looking for a new Laptop"
        		));
        
        requests.add( new Request(
        		"Jane Doe",
        		"Video Games",
        		"Created",
        		"2022-10-27 1:30 PM",
        		null,
        		"Unable to Update AMD drivers"
        		));
        
        requests.add( new Request(
        		"Jack Smith",
        		"Appliances",
        		"Assigned",
        		"2022-10-27 3:00 PM",
        		"Bob",
        		"Coffee Machine Broken"
        		));

        requests.add( new Request(
        		"Jack Smith",
        		"Appliances",
        		"Assigned",
        		"2022-10-27 3:00 PM",
        		"Amy",
        		"Printer Malfunction"
        		));
        
        getServletContext().setAttribute("requests", requests);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method st
		request.getRequestDispatcher("/WEB-INF/RequestLandingPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
