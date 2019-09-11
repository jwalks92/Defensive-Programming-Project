package advancedprogramming.students;

import java.util.ArrayList;
import java.util.HashMap;

import advancedprogramming.identification.SmartCard;
import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;

// Everything in this class is the same as UnderGraduate Student except the max credits amount.

public class PostGraduateTaught extends Student {

	private final int passPercentage = 50;
	private static int credits = 0;
	private final static int MAX_CREDITS = 180;
	private ArrayList<Module> moduleList;
	private final static int Total_Marks = 100;
	private static double marks = 0;

	// constructor uses a super to inherit and initialise the parents fields.
	// constructor needs to be private in accordance with defensive program as
	// Johua Bloch recomennds to encapsulate as much as possible.
	private PostGraduateTaught(Name name, int credits, String dateOfBirth, SmartCard smartCard) {

		super(name, credits, dateOfBirth, smartCard);
		moduleList = new ArrayList<Module>();
	}

	// Object factory essentially creates objects within objects upon creation.
	// Creates a smart card which creates a smart card number for example.
	// Different parameters to other classes, for example differs to
	// PostGraduateResearch as it has a module array list, rather than a superivsor
	// map.

	// cannot make the getInstances private as they are never used locally, and have
	// to be utilized by the have to strike a balance between defensive programming
	// and how best the system can work.

	public static PostGraduateTaught getInstance(Name n, String birthDate) {
		if (n == null)
			throw new IllegalArgumentException("name is null");
		if (birthDate == null)
			throw new IllegalArgumentException("birthDate is null");
		int credits = 0;
		PostGraduateTaught student = new PostGraduateTaught(n, credits, birthDate, SmartCard.getInstance(n, birthDate));
		return student;
	}

	// returns the pass percentage
	public int getPassPercentage() {
		return passPercentage;
	}

	// returns the credit
	public int getCredits() {
		return credits;
	}

	// if a module is going to be added, this method makes sure that is cannot be
	// added unless the number of credits is below 180 and if the credits are added
	// to the existing credits they are this not more than 180.
	public void addModule(Module x) {

		if ((credits + x.getModuleCredits()) <= MAX_CREDITS) {
			moduleList.add(x);
			credits = credits + x.getModuleCredits();
		} else
			System.out.println("Max Credits exceeded");

	}
	// returns the max credit number
	public int getMaxCredits() {
		return MAX_CREDITS;
	}
	// checks whether or not the students credits are equal to max credits and returns a boolean 
	public boolean checkEnoughCredits() {
		if (getCredits() == getMaxCredits()) {
			return true;
		} else
			return false;
	}
	//performs the same function as add module but with marks instead.
	public void addMark(int markPoints) {
		if (marks + markPoints <= Total_Marks) {
			marks = marks + markPoints;
		}

	}
	// return marks
	public double getMarks() {
		return marks;
	}
	// converts the marks into a percentage. 
	//needed to change to a double as percentages can have decimal places.
	public double getMarkPercentage() {
		double percentage = getMarks() / Total_Marks;
		double newPercentage = percentage * 100;
		return newPercentage;
	}
	// returns a boolean if mark percentage is greater or equals pass percentage.
	public boolean checkPassedTest() {
		if (getMarkPercentage() >= passPercentage) {
			return true;
		} else
			return false;
	}

	// uses a series of if statements to provide a grade (including a fail) based on
	// the mark percentage.
	public String assignGrade() {
		String grade = "";
		if (getMarkPercentage() > 50 && getMarkPercentage() < 60) {
			grade = "Pass";
			return grade;
		}
		if (getMarkPercentage() > 60 && getMarkPercentage() < 70) {
			grade = "Merit";
			return grade;
		}
		if (getMarkPercentage() > 70) {
			grade = "Distinction";
			return grade;
		}

		else {
			grade = "fail";
			return grade;
		}

	}
	// defensive copying for returning the module list.
	@Override
	public ArrayList<Module> getModuleList() {

		return new ArrayList<Module>(moduleList);
	}

	@Override
	public String getSupervisorName() {
		// TODO Auto-generated method stub
		return null;
	}
	// checks if the PostGraduateTaught's check enough credits is equal to true, if it is return true.
	@Override
	public boolean checkCorrectRegistration() {
		if (checkEnoughCredits() == true) {
			return true;
		} else
			return false;
	}
	// overides the objects hashcode and equals methods, making it logically equivalent rather than referential equivalance. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((moduleList == null) ? 0 : moduleList.hashCode());
		result = prime * result + passPercentage;
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
		PostGraduateTaught other = (PostGraduateTaught) obj;
		if (moduleList == null) {
			if (other.moduleList != null)
				return false;
		} else if (!moduleList.equals(other.moduleList))
			return false;
		if (passPercentage != other.passPercentage)
			return false;
		return true;
	}

}
