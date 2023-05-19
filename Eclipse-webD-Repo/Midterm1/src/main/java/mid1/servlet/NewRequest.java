package mid1.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mid1.model.Request;

/**
 * Servlet implementation class NewRequest
 */
@WebServlet("/NewRequest")
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String reason = request.getParameter("reason");
		
		Request r = new Request(
				name,
				dept,
				"Created",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a")),
				null,
				reason
				);
		
		ArrayList<Request> requests = (ArrayList<Request>) getServletContext().getAttribute("requests");
		
		requests.add(r);
		
		response.sendRedirect("RequestLandingPage");
	}

}
