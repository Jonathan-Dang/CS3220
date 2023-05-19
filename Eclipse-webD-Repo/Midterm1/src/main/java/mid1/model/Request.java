package mid1.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Request {
	static int ID = 1;
	
	private int id;
	private String rTime;
	private String name;
	private String status;
	private String assignedTo;
	private String dept;
	private String reason;
	
	public Request(String name, String dept , String status, String rTime)
	{
		this.name = name;
		this.status = status;
		this.rTime = rTime;
		this.assignedTo = null;
		this.dept = dept;
		this.id = ID++;
	}
	
	public Request(String name, String dept , String status, String rTime, String assignedTo, String reason)
	{
		this.name = name;
		this.status = status;
		this.rTime = rTime;
		this.assignedTo = null;
		this.dept = dept;
		this.assignedTo = assignedTo;
		this.reason = reason;
		this.id = ID++;
	}
	
	public String getReason() {
		return this.reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getRTime() {
		return this.rTime;
	}
	
	public void setRTime(String rTime) {
		this.rTime = rTime;
	}
	
	public String getDept() {
		return this.dept;
	}
	
	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		if( this.assignedTo == null)
			return "";
		
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
}
