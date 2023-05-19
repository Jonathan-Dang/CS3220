package lab7.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Log In</title></head><body>" );
        
        out.println("<form method='POST' action='Login'>");
        
        out.println("Username: <input type='text' name='User'><br><br>");
        out.println("Password: <input type='password' name='Pass'><br><br>");
        out.println("<button type='Submit'>Login</button>");
        
        out.println("</form>");
        
        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("User");
		String pass = request.getParameter("Pass");
		
		if (user.equals("cysun") && pass.equals("abcd"))
		{
			HttpSession curr = request.getSession();
			curr.setAttribute("user", user);
			
			response.sendRedirect("Members");
		}
		else
		{
			response.sendRedirect("Login");
		}
	}

}
