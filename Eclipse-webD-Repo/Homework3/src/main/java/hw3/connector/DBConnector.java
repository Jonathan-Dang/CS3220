package hw3.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hw3.model.DoseEntry;
import hw3.model.PatientEntry;

public class DBConnector {
	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu64";

    private String username = "cs3220stu64";

    private String password = "vk3vUEYer6Gx";

    private Connection connection;
    
    public DBConnector()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    public void addPatient(int vaccineId, String pName)
    {
    	String sql = "insert into Patients (name, first_dose, vaccine_id) values (?,?,?)";
    	try {
			PreparedStatement PS = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			PS.setString(1, pName);
			PS.setString(2, LocalDate.now().toString());
			PS.setInt(3, vaccineId);
			PS.executeUpdate();
			this.useDose(vaccineId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void addVaccine(String name, int daysBetween, int doses, int dosesRequired)
    {
    	String sql = "insert into Vaccines (name, doses_required, days_between, doses_remaining, total_doses) values (?,?,?,?,?)";
    	//5 input
    	try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setInt(2, dosesRequired);
			ps.setInt(3, daysBetween);
			ps.setInt(4, doses);
			ps.setInt(5, doses);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void useDose(int vaccineId)
    {
    	String sql = "update Vaccines set doses_remaining = doses_remaining - 1 where id = ?";
    	try {
			PreparedStatement PS = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			PS.setInt(1, vaccineId);
			PS.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void useDose(int vaccineId, int patientId)
    {
    	String pSql = "update Patients set second_dose = ? where id = ?";
    	try {
			PreparedStatement ps = connection.prepareStatement(pSql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, LocalDate.now().toString());
			ps.setInt(2, patientId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.useDose(vaccineId);
    }
    
    public void newDoses(int vaccineId, int newDosesAmount)
    {
    	String sql = "update Vaccines set total_doses = total_doses + ?, doses_remaining = doses_remaining + ? where id = ?";
    	try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, newDosesAmount);
			ps.setInt(2, newDosesAmount);
			ps.setInt(3, vaccineId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void updateVaccine(int vaccineId, String newName, int newDaysBetween, int doses_required)
    {
    	String sql = "update Vaccines set name = ?, days_between = ?, doses_required = ? where id = ?";
    	try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, newName);
			ps.setInt(2, newDaysBetween);
			ps.setInt(3, doses_required);
			ps.setInt(4, vaccineId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public List<DoseEntry> getDoseEntries()
    {
    	List<DoseEntry> dEntries = new ArrayList<DoseEntry>();
    	
    	String sqlDEntries = "select * from Vaccines";
    	
    	try {
    		PreparedStatement PSdEntries = connection.prepareStatement(sqlDEntries
    				, Statement.RETURN_GENERATED_KEYS);
    		ResultSet rse = PSdEntries.executeQuery();
    		
    		while (rse.next())
    		{
    			int id = rse.getInt("id");
    			String name = rse.getString("name");
    			int dRequired = rse.getInt("doses_required");
    			int dBD = rse.getInt("days_between");
    			int dRem = rse.getInt("doses_remaining");
    			int total = rse.getInt("total_doses");
    			
    			DoseEntry entry = new DoseEntry(name, dRequired, dBD, total, dRem);
    			entry.setId(id);
    			dEntries.add(entry);
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return dEntries;
    }
    
    public List<PatientEntry> getPatients()
    {
    	List<PatientEntry> patients = new ArrayList<PatientEntry>();
    	
    	String sqlPatients = "select * from Patients";
    	
    	try {
    		PreparedStatement PSPatients = connection.prepareStatement(sqlPatients
    				, Statement.RETURN_GENERATED_KEYS);
    		ResultSet RSPatients = PSPatients.executeQuery();
    		
    		while(RSPatients.next())
    		{
    			int id = RSPatients.getInt("id");
    			int vaccine_id = RSPatients.getInt("vaccine_id");
    			LocalDate fd = LocalDate.parse(RSPatients.getString("first_dose"));
    			String sd = RSPatients.getString("second_dose");
    			String name = RSPatients.getString("name");
    			
    			PatientEntry e = new PatientEntry(name, vaccine_id);
    			e.setId(id);
    			e.setFirst_dose(fd);
    			if (sd != null)
    			{
    				e.setSecond_dose(LocalDate.parse(sd));
    			}
    			
    			patients.add(e);
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return patients;
    }
}
