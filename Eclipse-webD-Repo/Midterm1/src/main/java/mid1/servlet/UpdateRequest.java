package mid1.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mid1.model.Request;

/**
 * Servlet implementation class UpdateRequest
 */
@WebServlet("/UpdateRequest")
public class UpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/UpdateRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Request> requests = (ArrayList<Request>) getServletContext().getAttribute("requests");
		int idRecieved = Integer.parseInt(request.getParameter("id"));
		int complete = Integer.parseInt(request.getParameter("status"));
		
		for (Request r : requests)
		{
			if (r.getId() == idRecieved)
			{
				switch(complete)
				{
				//Set a person to be assigned
				case(0):
				{
					String newAssigned = request.getParameter("assigned");
					r.setAssignedTo(newAssigned);
					r.setStatus("Assigned");
					break;
				}
				//Status Change
				case(1):
				{
					String choice = request.getParameter("choice");
					
					if(choice.equals("Y"))
					{
						r.setStatus("Completed");
					}
					else if (choice.equals("C"))
					{
						r.setStatus("Canceled");
					}
					break;
				}
				}
				
				response.sendRedirect("RequestLandingPage");
			}
		}
	}

}
