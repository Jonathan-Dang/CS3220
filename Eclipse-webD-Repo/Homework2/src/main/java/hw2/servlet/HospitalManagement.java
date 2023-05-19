package hw2.servlet;

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

import hw2.model.DoseEntry;
import hw2.model.PatientEntry;

/**
 * Servlet implementation class HospitalManagement
 */
@WebServlet( urlPatterns = "/HospitalManagement", loadOnStartup = 1)
public class HospitalManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalManagement() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        ArrayList<PatientEntry> pEntries = new ArrayList<PatientEntry>();
        
        List<DoseEntry> entries = new ArrayList<DoseEntry>();
        
        entries.add(new DoseEntry(
        		"Pfizer/BioNTech",
        		2,
        		21,
        		10000,
        		10000
        		));
        
        entries.add(new DoseEntry(
        		"Johnson & Johnson",
        		1,
        		0,
        		5000,
        		5000
        		));
        
        entries.add(new DoseEntry("Moderna",
        		2,
        		24,
        		1,
        		1
        		));

        getServletContext().setAttribute( "entries", entries );
        
        
        PatientEntry e = new PatientEntry("John Doe", 1);
        e.setFirst_dose(LocalDate.of(2021, 2, 18));
        e.setSecond_dose(LocalDate.of(2021, 3, 11));
        entries.get(0).useDose();
        pEntries.add(e);
        
        e = new PatientEntry("Jane Doe", 1);
        e.setFirst_dose(LocalDate.of(2021, 2, 18));
        entries.get(0).useDose();
        pEntries.add(e);
        
        e = new PatientEntry("Tom Smith", 2);
        e.setFirst_dose(LocalDate.of(2021, 3, 12));
        entries.get(1).useDose();
        pEntries.add(e);
        
        e = new PatientEntry("Jim Lee", 3);
        e.setFirst_dose(LocalDate.of(2021, 3, 12));
        entries.get(2).useDose();
        pEntries.add(e);
        
        getServletContext().setAttribute( "pEntries", pEntries );
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/HospitalManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
