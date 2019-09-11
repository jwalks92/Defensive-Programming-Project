package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.systems.UniversitySystem;

public class UniversitySystemTesting {
	static UniversitySystem us = new UniversitySystem();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// adding each student to the map of students and then checking if their name is
		// on the system.

		String firstName = "Brian";
		String lastName = "Walker";
		Name name = new Name(firstName, lastName);
		String type = "PostGraduateResearch";
		String dateOfBirth = "20/09/1966";
		us.registerStudent(name, dateOfBirth, type);

		Name name1 = new Name("Jacob", "Walker");
		String type1 = "PostGraduateTaught";
		String dateOfBirth1 = "13/09/1992";
		us.registerStudent(name1, dateOfBirth1, type1);

		Name name2 = new Name("Aidan", "Walker");
		String type2 = "UnderGraduateStudent";
		String dateOfBirth2 = "02/12/1994";
		us.registerStudent(name2, dateOfBirth2, type2);

		Name name3 = new Name("maria", "Walker");
		String type3 = "PostGraduateResearch";
		String dateOfBirth3 = "02/02/1966";
		us.registerStudent(name3, dateOfBirth3, type3);

		Name name4 = new Name("Nic", "Simon");
		String type4 = "PostGraduateResearch";
		String dateOfBirth4 = "02/02/2007";
		us.registerStudent(name4, dateOfBirth4, type4);

		Name name5 = new Name("Matt", "Bentley");
		String type5 = "UnderGraduateStudent";
		String dateOfBirth5 = "02/02/20010";
		us.registerStudent(name5, dateOfBirth5, type5);

		// when registeting Nic Simon the program will print out that he is too young to
		// be registered as per the spec.
		// when registeting Matt Bentley the program will print out that he is too young
		// to be registered as per the spec.
	}

// the first two test cases will check if the student are registered onto the map by finding their names according to their assigned students ID's.
//more efficient than printing out the entire Hash Map, although printing them out also proves it works.
	@Test
	public void registrationTest1() {
		String result = us.getStudentMap().get("a1000").getName().toString();
		assertEquals("Brian Walker", result);
	}

	@Test
	public void registrationTest2() {
		String result = us.getStudentMap().get("a1001").getName().toString();
		assertEquals("Jacob Walker", result);
	}

	// below gets the age of the 3rd registered student Aidan walker

	@Test
	public void registrationTest3getDateOfBirth() {
		String result = us.getStudentMap().get("a1002").getDateOfBirth();
		assertEquals("02/12/1994", result);
	}

	// below tests whether or not it returns the right age for Maria Walker
	@Test
	public void registrationTest3getAge() throws ParseException {
		int result = us.getStudentMap().get("a1003").checkAge();
		assertEquals(53, result);
	}

	@Test
	public void getNumberOfStudentsTest1() throws ParseException {
		int result = us.noOfStudents("PostGraduateResearch");
		assertEquals(2, result);
	}

	@Test
	public void getNumberOfStudentsTest2() throws ParseException {
		int result = us.noOfStudents("UnderGraduateStudent");
		assertEquals(1, result);
	}

	// this tests countes how many students have been entered.
	@Test
	public void countStudents() throws ParseException {
		int result = us.countStudent();
		assertEquals(4, result);
	}

}