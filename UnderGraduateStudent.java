package advancedprogramming.students;

import java.util.ArrayList;
import java.util.HashMap;

import advancedprogramming.identification.SmartCard;
import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;

public class UnderGraduateStudent extends Student {
	// please note that i added total marks and marks as a method of testing and
	// distinguishing between pass percentages
	// between UnderGraduateStudent and PostGraudateStudent
	// because of this these variables have their own methods assigned to them as
	// well as
	// one methods to calculate the percentage
	// another method calculates whether or not this percentage is over the assigned
	// percentage mark and if it is return true
	private final int passPercentage = 40;
	private static int credits = 0;
	private final static int MAX_CREDITS = 120;
	private ArrayList<Module> moduleList;
	private final static int Total_Marks = 100;
	private double marks = 0;

	// Max credits are set to 120 as they are constant throughout, used as a limit
	// to make sure that they are never exceeded by credits, which can increase.

	private UnderGraduateStudent(Name name, int credits, String dateOfBirth, SmartCard smartCard) {

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

	public static UnderGraduateStudent getInstance(Name n, String birthDate) {
		if (n == null)
			throw new IllegalArgumentException("name is null");
		if (birthDate == null)
			throw new IllegalArgumentException("birthDate is null");
		int credits = 0;
		UnderGraduateStudent stu = new UnderGraduateStudent(n, credits, birthDate, SmartCard.getInstance(n, birthDate));
		return stu;
	}
	// returns the pass percentage of the undergrad
	public int getPassPercentage() {
		return passPercentage;
	}
	//returns the total number of credits of the undergrad
	public int getCredits() {
		return credits;
	}
	// get the maximum number of credits - differs for eachs student.
	public int getMaxCredits() {
		return MAX_CREDITS;
	}

	// if a module is going to be added, this method makes sure that is cannot be
	// added unless the number of credits is below 120 and if the credits are added
	// to the existing credits they are this not more than 120.

	public void addModule(Module x) {
		if ((credits + x.getModuleCredits()) <= MAX_CREDITS) {
			moduleList.add(x);
			credits = credits + x.getModuleCredits();
		} else
			System.out.println("Max Credits exceeded");
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
		if (marks + markPoints < Total_Marks) {
			marks = marks + markPoints;
		}

	}
	// returns the number of marks
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
	// uses a series of if statements to provide a grade (including a fail) based on the mark percentage. 
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

	// below methods are returned null as they are not relevant to this class,
	// although implementation was necessary because of the requirements of the
	// student interface otherwise they would not be in. 
	// Otherwise there are no methods relevant 
	
	// checks if the undergrad's check enough credits is equal to true, if it is return true.
	@Override
	public boolean checkCorrectRegistration() {
		if (checkEnoughCredits() == true) {
			return true;
		} else
			return false;
	}

	@Override
	public String getSupervisorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Module> getModuleList() {
		return new ArrayList<Module>(moduleList);
	}
	// overides hashcode and equals methods.
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
		UnderGraduateStudent other = (UnderGraduateStudent) obj;
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