package hw3.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw3.connector.DBConnector;
import hw3.model.DoseEntry;
import hw3.model.PatientEntry;

/**
 * Servlet implementation class PatientHomepage
 */
@WebServlet("/PatientHomepage")
public class PatientHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientHomepage() {
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
		request.getRequestDispatcher("/WEB-INF/PatientHomepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector db = new DBConnector();
		
		int pId = Integer.parseInt(request.getParameter("pId") == "" ? "-1" :
			request.getParameter("pId").strip());
		
		int vId = Integer.parseInt(request.getParameter("vId") == "" ? "-1" : request.getParameter("vId").strip());
		
		db.useDose(vId, pId);
		
        db.close();
		doGet(request, response);
	}

}
