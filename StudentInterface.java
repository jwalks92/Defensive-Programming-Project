package advancedprogramming.students;

import java.util.ArrayList;

import advancedprogramming.mutableclasses.Module;

public interface StudentInterface {

	public String getStudentID();
	// gets student id 
	public String getStudentType();
	//gets the subclass of student as a string 
	public ArrayList<Module> getModuleList();
	//returns the module list of a given student 
	public boolean checkEnoughCredits();
	//check if the student has the same number of credits as their maximum number of credits
	public String getSupervisorName();
	// get a suerpvisor for PostGraduateResearch
	public abstract boolean checkCorrectRegistration();
	// checks whether or not the UnderGraduateStudent and PostGraudateTaught has the maximum level of credits and whether or not 
	// PostGraudateResearch has a Supervisor

}

// This is the Student interface. It is a collection of abstract methods which are implemented by the sub classes of Student.
// The course work specification suggested that all five methods should be applicable across all students which is why they are in the interface.
