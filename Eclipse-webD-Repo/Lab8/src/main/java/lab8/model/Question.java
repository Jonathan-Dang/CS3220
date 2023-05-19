package lab8.model;


public class Question {
	private String description;
	private String qA;
	private String qB;
	private String qC;
	private int correctIndex;
	
	public Question()
	{
		this.description = null;
		this.correctIndex = -1;
		this.qA = null;
		this.qB = null;
		this.qC = null;
	}
	
	public Question(String descrip, String qa, String qb, String qc, int correct)
	{
		this.qA = qa;
		this.qB = qb;
		this.qC = qc;
		this.description = descrip;
		this.correctIndex = correct;
	}
	
	public String getA()
	{
		return this.qA;
	}
	
	public String getB()
	{
		return this.qB;
	}
	
	public String getC()
	{
		return this.qC;
	}
	
	public int getCorrectNumber()
	{
		return this.correctIndex;
	}
	
	public String getCorrect()
	{
		switch(this.correctIndex)
		{
		case(1):
			return this.qA;
		case(2):
			return this.qB;
		case(3):
			return this.qC;
		default:
			return null;
		}
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	@Override
	public String toString()
	{
		return "" + this.description + "\n1. " + this.getA() + "\n2. " + this.getB() + "\n3. " + this.getC() + "\nCorrect Answer: " + this.correctIndex + "\n";
	}
}
