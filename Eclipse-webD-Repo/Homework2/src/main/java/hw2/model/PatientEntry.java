package hw2.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class PatientEntry {
	static int Id = 1;
	
	private int id;
	private String name;
	private int vaccineId;
	private LocalDate first_dose;
	private LocalDate second_dose;
	
	public PatientEntry(String name, int vId)
	{
		this.id = Id++;
		this.name = name;
		this.vaccineId = vId;
		this.first_dose = null;
		this.second_dose = null;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_dose() {
		return this.first_dose.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}

	public void setFirst_dose(LocalDate first_dose) {
		this.first_dose = first_dose;
	}

	public String getSecond_dose() {
		if(this.second_dose == null)
			return "";
		
		return this.second_dose.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}

	public void setSecond_dose(LocalDate second_dose) {
		this.second_dose = second_dose;
	}
	
	public void setSecondToCurr() {
		this.second_dose = LocalDate.now();
	}
	
	public void setFirstToCurr() {
		this.first_dose = LocalDate.now();
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
}
