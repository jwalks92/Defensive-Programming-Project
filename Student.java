package advancedprogramming.students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import advancedprogramming.identification.SmartCard;
import advancedprogramming.identification.SmartCardNumber;
import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;

public abstract class Student implements StudentInterface {

	private final Name name;
	private final int credits;
	private final String dateOfBirth;
	private final SmartCard smartCard;

	// The purpose of the student superclass is to make the subclass's immutable.
	// As such all the fields are set to final.
	// There are no set methods.

	// The student when created in the object factories across the subclasses will
	// create a smart card and an id simultaneously.
	// No object factory in this class as it is an abstract class, due to the
	// methods below and because it needs to implement the
	// methods of the interface.

	public Student(Name name, int credits, String dateOfBirth, SmartCard smartCard) {

		this.name = new Name(name.getFirstName(), name.getLastName());
		this.credits = credits;
		this.dateOfBirth = dateOfBirth;
		this.smartCard = smartCard;

	}

	// returns Name object stored within the Student object.

	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}

	// returns the date String.

	public void setName(Name naming) {
		name.setFirstName(naming.getFirstName());
		name.setLastName(naming.getLastName());
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	// The below creates a date object and gets the current time in milliseconds.
	// It does the same with the date of birth which has to be placed in the
	// constructor
	// It subtracts the two and then converts milliseconds to years and casts it to
	// an integer.
	// This gives the age of the student in question.
	// throws parse exception because of simple date format and that the string
	// might not be set out correctly (it is).
	// It is more telling the compiler that all is well in the possible case of an
	// exception.
	public int checkAge() throws ParseException

	{
		Date date = new Date(); // creates a date Object
		long now = date.getTime(); // gets the time now in miliseconds
		Date soon = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth); // changes the string date of birth into a //
																			// date
		long then = soon.getTime(); // gets that date in miliseconds
		long calculation = (now - then) / 31556952000L; // converts milieconds to years
		int newCalculation = (int) calculation; // chose to cast it as int rather than long or double/float as no one
		return newCalculation; // wants their age to be 17.8 for example.

	}

	// The below uses instance of in order to determine the class to which the
	// object belongs and then returns a string accordingly.

	public String getStudentType() {
		String returntype = "";
		if (this instanceof UnderGraduateStudent) {
			returntype = "UnderGraduateStudent";

		}

		if (this instanceof PostGraduateResearch) {
			returntype = "PostGraduateResearch";

		}

		if (this instanceof PostGraduateTaught) {
			returntype = "PostGraduateTaught";

		}

		return returntype;
	}

	// returns student id.

	public String getStudentID() {
		return smartCard.getID().toString();
	}

	// Below takes the string representation of year found in smart card, changes it
	// to an integer and then adds a number specified by the course work
	// according to student type, number is returned.

	private int setExpiryDate() {
		int expiry = 0;
		if (getStudentType().equals("UnderGraduateStudent")) {
			expiry = Integer.parseInt(SmartCardNumber.getYearOfIssue()) + 4;

		}

		if (getStudentType().equals("PostGraduateTaught")) {
			expiry = Integer.parseInt(SmartCardNumber.getYearOfIssue()) + 2;

		}

		if (getStudentType().equals("PostGraduateResearch")) {
			expiry = Integer.parseInt(SmartCardNumber.getYearOfIssue()) + 5;

		}

		return expiry;
	}

	// returns smart card object - cannot use defensive programming as each
	// instantiated smart card number will rise by one each time.

	public SmartCard getSmartCard() {

		return smartCard;
	}

	// gets expiry date as specified by the course work

	public int getExpiry() {
		return setExpiryDate();
	}

	// Overrides the to String method and returns variables in string form.

	public String toString() {
		return "Name: " + name + " " + "D.O.B: " + dateOfBirth;

	}
	// returns credits
	public int getCredits()
	{
		return credits;
	}

	// The above methods were not made abstract as they refer to all student object
	// types, regardless of their type.
	// The below have been made abstract as each type has different layouts which
	// affect the methods differently.
	// It was therefore more efficient to override the methods accordingly which
	// shall be shown for the sub classes.
	// The below where either specified in the student interface or necessary for
	// the amends student method, found in the UniversitySystem class.

	public abstract boolean checkEnoughCredits();

	public abstract ArrayList<Module> getModuleList();

	public abstract String getSupervisorName();

	public abstract boolean checkCorrectRegistration();
	
	// decided not to override equals in the student parent class and the student subclass, just one or the other
	// chose to do it for the subclasses instead.
	
}
