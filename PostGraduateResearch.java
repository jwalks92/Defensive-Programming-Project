package advancedprogramming.students;

import java.util.ArrayList;
import java.util.HashMap;

import advancedprogramming.identification.SmartCard;
import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;

public class PostGraduateResearch extends Student {

	private final int passPercentage = 50;
	private final static int MAX_CREDITS = 0;
	private HashMap<Integer, Supervisor> supervisorMap;

	// Same as the other two subclasses except supervisor replaces module.
	// Note that because there may only be one supervisor a map was used instead.

	private PostGraduateResearch(Name name, int credits, String dateOfBirth, SmartCard smartCard) {

		super(name, credits, dateOfBirth, smartCard);
		supervisorMap = new HashMap<Integer, Supervisor>();

	}
	
	// defensive copying for return hashmap

	public HashMap<Integer, Supervisor> getSupervisor() {
		return new HashMap<Integer, Supervisor>(supervisorMap);
	}

	public static PostGraduateResearch getInstance(Name n, String birthDate) {
		if (n == null)
			throw new IllegalArgumentException("name is null");
		if (birthDate == null)
			throw new IllegalArgumentException("birthDate is null");
		int credits = 0;
		PostGraduateResearch stu = new PostGraduateResearch(n, credits, birthDate, SmartCard.getInstance(n, birthDate));
		return stu;
	}

	public int getMaxCredits() {
		return MAX_CREDITS;
	}

	public boolean checkEnoughCredits() {
		if (getStudentType() == "PostGraduateResearch" && getMaxCredits() == 0) {
			return true;
		} else
			return false;
	}
	// overides the to string method.
	public String toString() {
		return "Name: " + getName() + " " + "D.O.B: " + getDateOfBirth() + "StudentID: " + getStudentID()
				+ "Supervisor: " + getSupervisor();

	}
	// adds a sueprvisor to the hashmap.
	public void addSupervisor(Supervisor x) {
		Integer intRep = x.hashCode();
		supervisorMap.put(intRep, x);
	}
	// these methods although not relevant to the class must be implemented because of the necessity of the student interface
	// making these methods applicable ot every student as required by the spec.
	@Override
	public ArrayList<Module> getModuleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSupervisorName() {
		// TODO Auto-generated method stub
		return supervisorMap.values().toString();
	}

	// checks whether or not the PostGraudateResearch student has a supervisor
	@Override
	public boolean checkCorrectRegistration() {
		if (supervisorMap.isEmpty()) {
			return false;
		}
		return true;
	}
	// overides the objects hashcode and equals methods, making it logically equivalent rather than referential equivalance. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + passPercentage;
		result = prime * result + ((supervisorMap == null) ? 0 : supervisorMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostGraduateResearch other = (PostGraduateResearch) obj;
		if (passPercentage != other.passPercentage)
			return false;
		if (supervisorMap == null) {
			if (other.supervisorMap != null)
				return false;
		} else if (!supervisorMap.equals(other.supervisorMap))
			return false;
		return true;
	}
	
	

}
