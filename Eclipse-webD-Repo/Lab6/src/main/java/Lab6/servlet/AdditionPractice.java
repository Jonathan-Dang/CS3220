package Lab6.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random r = new Random();
		int a = r.nextInt(9);
		int b = r.nextInt(9);
		
		a += 1;
		b += 1;
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Addition Practice</title></head><body>");

        out.println("<form method=\"POST\" action=\"AdditionPractice\">");
        
        out.println("<label for=\"sum\"></label>");
        out.println(a + " + " + b + " = <input name=\"sum\" type=\"text\">");
        out.println("<button type=\"Submit\">Submit</button>");
        
        out.println("<label for=\"a\"></label>");
        out.println("<input name=\"a\" type=\"hidden\" value=" + a +">");
        
        out.println("<label for=\"b\"></label>");
        out.println("<input name=\"b\" type=\"hidden\" value="+b+">");
        
        out.println("</form></body></html>");
        out.close();
		
		
		/*
		 * <form method="POST" action="AdditionPractice">
			<label for="sum"></label>
			${a} + ${b} = <input name="sum" type="text">
			<button type="Submit">Submit</button>
			
			
			<label for="a"></label>
			<input name="a" type="hidden" value=a>
			
			<label for="b"></label>
			<input name="b" type="hidden" value=${b}>
			
			</form>
		 */
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rawSum = request.getParameter("sum");
        int sum = (rawSum == null || rawSum.trim().length() == 0) ? 0 : Integer.parseInt(rawSum);
        
        String rawA = request.getParameter("a");
        int a = (rawA == null || rawA.trim().length() == 0) ? 0 : Integer.parseInt(rawA);
        
        String rawB = request.getParameter("b");
        int b = (rawB == null || rawB.trim().length() == 0) ? 0 : Integer.parseInt(rawB);
        
        boolean correct = (a + b) == sum;
        

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Addition Practice Submitted</title></head><body>");

        out.println("<p> " + a + " + " + b + " = " + (a+b) + "</p>");
        out.println("<p>Your answer of " + sum + " is " + (correct ? "correct" : "incorrect") +"</p>");
        
        out.println("<form method=\"GET\" action=\"AdditionPractice\">");
        
        out.println("<button>Try Again</button>");
        
        out.println("</form></body></html>");
        out.close();

	}

}
