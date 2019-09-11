package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.systems.UniversitySystem;

public class TerminateStudentTest {
	static UniversitySystem us = new UniversitySystem();

	@BeforeClass

	// this class mirrors the class UniversitySystemTesting, except it uses the
	// count function to show that the number has been reduced
	// by one using exactly the same students as the previous test class.
	// number of student was originally four (see univeristy system)
	// reduced by one after it is terminated
	// can print the people in the university system for further proof

	public static void setUpBeforeClass() throws Exception {
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
		
	}

	@Test
	public void termainteTest() {
		us.terminateStudent("a1001");
		int result = us.countStudent();
		assertEquals(3, result);
	}

}
