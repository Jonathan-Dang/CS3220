package finals.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finals.connector.DBConnector;
import finals.model.BloodPresureModel;

/**
 * Servlet implementation class viewReport
 */
@WebServlet("/viewReport")
public class viewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBConnector dbc = new DBConnector();
		ArrayList<BloodPresureModel> bloodEntries = (ArrayList<BloodPresureModel>) dbc.getEntries(Integer.parseInt(request.getParameter("id")));
		dbc.close();
		
		getServletContext().setAttribute("bEntries", bloodEntries);
		
		request.getRequestDispatcher("/WEB-INF/viewReport.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sys = Integer.parseInt(request.getParameter("sys"));
		int dia = Integer.parseInt(request.getParameter("dia"));
		DBConnector dbc = new DBConnector();
		dbc.addEntry(Integer.parseInt(request.getParameter("id")), sys, dia);
		dbc.close();
		response.sendRedirect("viewReport?id=" + request.getParameter("id"));
	}

}
