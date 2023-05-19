package lab13.model;

public class Faculty {
	static int ID;
	
    private String name;
    private int id;
    private boolean isChair;

    public Faculty()
    {
        isChair = false;
        id = ID++;
    }

    public Faculty( String name )
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

    public boolean isChair()
    {
        return isChair;
    }

    public void setChair( boolean isChair )
    {
        this.isChair = isChair;
    }
    
    @Override
    public String toString() {
    	return this.getName() + (this.isChair() ? ", Chair Person" : "");
    }
}
