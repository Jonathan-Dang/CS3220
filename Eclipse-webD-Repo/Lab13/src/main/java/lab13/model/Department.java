package lab13.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	static int ID;
	
    private String name;
    private int id;
    private List<Faculty> faculty;

    public Department()
    {
        faculty = new ArrayList<Faculty>();
        id = ID++;
    }

    public Department( String name )
    {
        this();
        this.name = name;
    }
    
    public int getId()
    {
    	return id;
    }
    
    public void setId(int newID)
    {
    	id = newID;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Faculty> getFaculty()
    {
        return faculty;
    }

    public void setFaculty( List<Faculty> faculty )
    {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
    	return this.getName();
    }
}
