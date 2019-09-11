package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.systems.UniversitySystem;

public class AmmendsStudentTest {
	static UniversitySystem us = new UniversitySystem();
// set up four individuals who i can add to the system, each with differing ages and student types and names so i can test them accordingly. 
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

		Name name3 = new Name("maria", "Walker");
		String type3 = "PostGraduateResearch";
		String dateOfBirth3 = "02/02/1966";
		us.registerStudent(name3, dateOfBirth3, type3);
// a module and a supervisor have been placed in for further testing purposes. 
		String code = "CSC8010";
		String modName = "Advanced";
		int newcredits = 120;
		Module moduleObject1 = new Module(code, modName, newcredits);

		String first = "Suzy";
		String last = "Walker";
		Name name4 = new Name(first, last);
		Supervisor sup = new Supervisor(name4);

		us.ammend("a1002", moduleObject1, null, null);
		us.ammend("a1003", null, sup, null);
		us.ammend("a1001", null, sup, null);
		us.ammend("a1000", moduleObject1, null, null);

	}

	// The ammends adds a module list to it.

	@Test
	public void ammendsModuletest() {
		String result = us.getStudentMap().get("a1002").getModuleList().toString();
		assertEquals("[CSC8010:Advanced:120]", result);
	}

	// despite a module being added to a postGraduateResearch student it only
	// returns null as PostGradResearch cannot have Modules, as specified by the
	// coursework requirements.

	@Test
	public void ammendsModuletest2() {
		ArrayList<Module> result = us.getStudentMap().get("a1000").getModuleList();
		assertEquals(null, result);
	}

	// The ammends adds a supervisor to the PostGraudateResearch
	@Test
	public void ammendsSupervisorTest() {
		String result = us.getStudentMap().get("a1003").getSupervisorName();
		assertEquals("[Suzy Walker]", result);
	}

	// ammends method will not add to any student who is not PostGraduateResearch
	// and will instead return null.

	@Test
	public void ammendsSupervisorTest2() {
		String result = us.getStudentMap().get("a1001").getSupervisorName();
		assertEquals(null, result);

	}

	// the bottom two tests show that the name is changed by using the ammends
	// method.

	@Test
	public void nameTest1() {
		String result = us.getStudentMap().get("a1000").getName().toString();
		assertEquals("Brian Walker", result);

	}

	@Test
	public void nameTest2() {

		Name name1 = new Name("Bruce", "Wayne");
		us.ammend("a1001", null, null, name1);
		String result = us.getStudentMap().get("a1001").getName().toString();
		assertEquals("Bruce Wayne", result);

	}

}