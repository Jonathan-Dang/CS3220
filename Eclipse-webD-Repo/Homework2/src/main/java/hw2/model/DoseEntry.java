package hw2.model;

public class DoseEntry {
	static int idDose = 1;
	
	private int id;
	private String vaccineName;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int totalDoses;
	private int dosesRemaining;
	
	public DoseEntry(String name, int required, int between, int total, int remaining)
	{
		this.id = idDose++;
		this.vaccineName = name;
		this.dosesRequired = required;
		this.daysBetweenDoses = between;
		this.totalDoses = total;
		this.dosesRemaining = remaining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public int getDosesRequired() {
		return dosesRequired;
	}

	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}

	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}

	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}

	public int getTotalDoses() {
		return totalDoses;
	}

	public void setTotalDoses(int totalDoses) {
		this.totalDoses = totalDoses;
	}

	public int getDosesRemaining() {
		return dosesRemaining;
	}

	public void setDosesRemaining(int dosesRemaining) {
		this.dosesRemaining = dosesRemaining;
	}
	
	public void useDose() {
		this.dosesRemaining -= 1;
	}
	
	public void useDose(int amount) {
		this.dosesRemaining -= amount < 0 ? -amount : amount;
	}
}