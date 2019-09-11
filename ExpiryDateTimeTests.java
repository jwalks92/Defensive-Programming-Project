package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.systems.UniversitySystem;

public class ExpiryDateTimeTests {
	static UniversitySystem us = new UniversitySystem();
// test checks and tests expiry dates and date of issue by using calendar for testing purposes as per the spec. 
	@BeforeClass
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

	}

	@Test
	public void underGraduateExpiryTest() {
		int result = us.getStudentMap().get("a1002").getExpiry();
		assertEquals(2023, result);
	}

	@Test
	public void postGraduateTaughtTest() {
		int result = us.getStudentMap().get("a1001").getExpiry();
		assertEquals(2021, result);
	}

	@Test
	public void postGraduateResearchTest() {
		int result = us.getStudentMap().get("a1000").getExpiry();
		assertEquals(2024, result);
	}

	// in regards to my get year of issue test, I replicated my get year of issue
	// method found in SmartCardNumber
	// and used it in here. I could not replicate it as per the other methods as it
	// uses the date class,
	// which depracated methods cannot be used to test it. Therefore using calendar
	// in the format below
	// seemed like the best design choice.
	@Test
	public void dateOfIssueTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		Calendar calendar = new GregorianCalendar(2013, 1, 28);
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.MINUTE, 33);
		java.util.Date date = calendar.getTime();
		String convertedString = date.toString();
		String yearString = convertedString.substring(24, 28);
		assertEquals("2014", yearString);

	}

}
