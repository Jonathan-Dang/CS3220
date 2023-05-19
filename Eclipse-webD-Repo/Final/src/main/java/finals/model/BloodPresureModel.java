package finals.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BloodPresureModel {
	private int Id;
	private Timestamp time;
	private int SystoicEntry;
	private int DiastolicEntry;
	
	public BloodPresureModel(int id, Timestamp time, int s, int d)
	{
		this.Id = id;
		this.time = time;
		this.SystoicEntry = s;
		this.DiastolicEntry = d;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getSystoicEntry() {
		return SystoicEntry;
	}
	public void setSystoicEntry(int systoicEntry) {
		SystoicEntry = systoicEntry;
	}
	public int getDiastolicEntry() {
		return DiastolicEntry;
	}
	public void setDiastolicEntry(int diastolicEntry) {
		DiastolicEntry = diastolicEntry;
	}
	
}
