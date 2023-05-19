package lab8.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab8.model.Question;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet(urlPatterns = "/DrivingTestBrowser", loadOnStartup = 1)
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        String filename = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");
        ArrayList<Question> questions = new ArrayList<Question>();
        Scanner ins = null;
		try {
			ins = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        while(ins.hasNextLine())
        {
        	try {
	        	String desc = ins.nextLine();
	        	String qA = ins.nextLine();
	        	String qB = ins.nextLine();
	        	String qC = ins.nextLine();
	        	int correct = Integer.parseInt(ins.nextLine());
	        	Question q = new Question(desc,qA,qB,qC,correct);
	        	questions.add(q);
	        	ins.nextLine();
        	} catch (Exception e) {
        		continue;
        	}
        	
        }
        ins.close();
        getServletContext().setAttribute( "questions", questions );
        getServletContext().setAttribute( "index", 0 );
        getServletContext().setAttribute( "nextIndex", 1 );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index") == null ? "0" : request.getParameter("index"));
		ArrayList<Question> questions = (ArrayList<Question>) getServletContext().getAttribute("questions");
		
		getServletContext().setAttribute( "index", index );
		
		if ((int) getServletContext().getAttribute("nextIndex") == questions.size() - 1)
			getServletContext().setAttribute( "nextIndex", 0 );
		else
			getServletContext().setAttribute( "nextIndex", index + 1 );
		
		request.getRequestDispatcher("/WEB-INF/questionView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
