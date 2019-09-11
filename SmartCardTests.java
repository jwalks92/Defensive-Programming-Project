package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.systems.UniversitySystem;

// tests for all smart card methods excluding the date ones which have been tested in their own seperate classes.
public class SmartCardTests {
	static UniversitySystem us = new UniversitySystem();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		Name name1 = new Name("Jacob", "Walker");
		String type1 = "PostGraduateTaught";
		String dateOfBirth1 = "13/09/1992";
		us.registerStudent(name1, dateOfBirth1, type1);

		Name name2 = new Name("Aidan", "Walker");
		String type2 = "UnderGraduateStudent";
		String dateOfBirth2 = "02/12/1994";
		us.registerStudent(name2, dateOfBirth2, type2);

		System.out.println(us.getStudentMap().get("a1000").getSmartCard().getName());

		// tests that both smart cards work with initials and incrementing additional
		// number.

	}

	@Test
	public void smartCardTest1() {
		String result = us.getStudentMap().get("a1000").getSmartCard().toString();
		assertEquals("JW-2019-10", result);
	}

	@Test
	public void smartCardTest2() {
		String result = us.getStudentMap().get("a1001").getSmartCard().toString();
		assertEquals("AW-2019-11", result);
	}

	// tests smartcard methods get date of birth, get name, get student id and get
	// issue of the card.

	@Test
	public void nameTest() {
		String result = us.getStudentMap().get("a1000").getSmartCard().getName().toString();
		assertEquals("Jacob Walker", result);

	}

	@Test
	public void dateOfBirthTest() {
		String result = us.getStudentMap().get("a1001").getSmartCard().getDateOfBirth();
		assertEquals("02/12/1994", result);

	}

	@Test
	public void getIDtest1() {
		String result = us.getStudentMap().get("a1001").getSmartCard().getID().toString();
		assertEquals("a1001", result);

	}

	@Test
	public void getIDtest2() {
		String result = us.getStudentMap().get("a1000").getSmartCard().getID().toString();
		assertEquals("a1000", result);

	}

	public void getIssueTest() {
		String result = us.getStudentMap().get("a1000").getSmartCard().getDateOfIssue().toString();
		assertEquals("a1000", result);
	}

}
