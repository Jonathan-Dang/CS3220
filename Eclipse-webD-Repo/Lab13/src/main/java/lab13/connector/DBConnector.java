package lab13.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab13.model.Department;
import lab13.model.Faculty;

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
    
    public ArrayList<Department> getDepartments(){
    	ArrayList<Department> depts = new ArrayList<Department>();
    	String sqlDept = "select * from departments";
    	String sqlFaculty = "select * from faculty f inner join departments d on f.dept_id = d.id where d.id = ?";
    	try {
			PreparedStatement PSDept = connection.prepareStatement(sqlDept, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement PSFaculty = connection.prepareStatement(sqlFaculty, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet RSDept = PSDept.executeQuery();
			
			while(RSDept.next())
			{
				PSFaculty.setInt(1,RSDept.getInt("id"));
				ResultSet RSFaculty = PSFaculty.executeQuery();
				Department dept = new Department();
				
				dept.setId(RSDept.getInt("id"));
				dept.setName(RSDept.getString("name"));
				
				List<Faculty> faculty = new ArrayList<Faculty>();
				while (RSFaculty.next())
				{
					Faculty fentry = new Faculty();
					fentry.setId(RSFaculty.getInt("id"));
					fentry.setName(RSFaculty.getString("name"));
					fentry.setChair(RSFaculty.getBoolean("isChair"));
					faculty.add(fentry);
				}
				dept.setFaculty(faculty);
				
				depts.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return depts;
    }
    
    public void addFaculty(int dept_id, Faculty f)
    {
    	String sql = "insert into faculty (name, isChair, dept_id) values (?,?,?)";
    	try {
    		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		
    		ps.setString(1, f.getName());
    		ps.setBoolean(2, f.isChair());
    		ps.setInt(3, dept_id);
    		
    		ps.executeUpdate();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void addDept(String name) {
    	String sql = "insert into departments (name) values (?)";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(sql);
    		
    		ps.setString(1, name);
    		
    		ps.executeUpdate();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
}
