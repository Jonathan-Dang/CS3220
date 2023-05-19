package hw3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hw3.connector.DBConnector;
import hw3.model.DoseEntry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DosesHomepage
 */
@WebServlet("/DosesHomepage")
public class DosesHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DosesHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DBConnector db = new DBConnector();
	     getServletContext().setAttribute( "entries", db.getDoseEntries());
	     getServletContext().setAttribute( "pEntries", db.getPatients());
	     db.close();
		request.getRequestDispatcher("/WEB-INF/DosesHomepage.jsp").forward(request, response);
	}
}
