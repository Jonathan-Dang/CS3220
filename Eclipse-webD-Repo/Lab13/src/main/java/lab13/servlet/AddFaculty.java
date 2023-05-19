package lab13.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab13.connector.DBConnector;
import lab13.model.Faculty;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" )
            .forward( request, response );
    }
    
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int departmentID = Integer.parseInt(request.getParameter( "department" ));
        Faculty faculty = new Faculty( request.getParameter( "faculty" ) );
        if( request.getParameter( "chair" ) != null ) faculty.setChair( true );

        DBConnector db = new DBConnector();
        db.addFaculty(departmentID, faculty);
        db.close();
        
        response.sendRedirect( "DisplayFaculty" );
    }

}
