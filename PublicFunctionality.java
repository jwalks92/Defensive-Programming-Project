package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.students.PostGraduateResearch;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.students.UnderGraduateStudent;
import advancedprogramming.systems.UniversitySystem;

public class PublicFunctionality {
	static UniversitySystem us = new UniversitySystem();

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
		String type3 = "PostGraduateTaught";
		String dateOfBirth3 = "02/02/1966";
		us.registerStudent(name3, dateOfBirth3, type3);

		String code = "CSC8010";
		String modName = "Advanced";
		int newcredits = 100;
		Module moduleObject1 = new Module(code, modName, newcredits);

		String code1 = "CSC9212";
		String modName1 = "Medium";
		int newcredits1 = 60;
		Module moduleObject2 = new Module(code1, modName1, newcredits1);

		String code2 = "CSC7533";
		String modName2 = "Easy";
		int newcredits2 = 20;
		Module moduleObject3 = new Module(code2, modName2, newcredits2);

		PostGraduateTaught taught = (PostGraduateTaught) us.getStudentMap().get("a1001");
		taught.addModule(moduleObject1);
		taught.addModule(moduleObject2);

		UnderGraduateStudent student = (UnderGraduateStudent) us.getStudentMap().get("a1002");
		student.addModule(moduleObject1);
		student.addModule(moduleObject3);
		
		System.out.println(us.getStudentMap().get("a1002").getModuleList());

		PostGraduateTaught post = (PostGraduateTaught) us.getStudentMap().get("a1003");
		post.addModule(moduleObject1);
		post.addModule(moduleObject2);
		post.addModule(moduleObject3);

		String first = "Suzy";
		String last = "Walker";
		Name name4 = new Name(first, last);
		Supervisor sup = new Supervisor(name4);

		PostGraduateResearch research = (PostGraduateResearch) us.getStudentMap().get("a1000");
		research.addSupervisor(sup);

	}

	@Test
	public void getStudentID1Test() {
		String result = us.getStudentMap().get("a1000").getStudentID();
		assertEquals("a1000", result);
	}

	@Test
	public void getStudentID2Test() {
		String result = us.getStudentMap().get("a1001").getStudentID();
		assertEquals("a1001", result);
	}

	@Test
	public void getStudentType1Test() {
		String result = us.getStudentMap().get("a1002").getStudentType().toString();
		assertEquals("UnderGraduateStudent", result);
	}

	@Test
	public void getStudentModuleList() {
		String result = us.getStudentMap().get("a1001").getModuleList().toString();
		assertEquals("[CSC8010:Advanced:100, CSC9212:Medium:60]", result);
	}

	@Test
	public void getStudentModuleList2() {
		String result = us.getStudentMap().get("a1002").getModuleList().toString();
		assertEquals("[CSC8010:Advanced:100, CSC7533:Easy:20]", result);
	}

	// shows that because of the differnt credit maxes and that one totals 120 and
	// one does not total 180,
	// the precediing results will be true and false as shown below for
	// getEnoughCreditsTest()

	@Test
	public void getEnoughCreditsTest() {
		boolean result = us.getStudentMap().get("a1002").checkEnoughCredits();
		assertEquals(true, result);
	}

	@Test
	public void getEnoughCreditsTest2() {
		boolean result = us.getStudentMap().get("a1001").checkEnoughCredits();
		assertEquals(true, result);
	}

	// For PostGraduateResearch student Brian Walker, this will return the name of
	// his supervisor

	@Test
	public void getSupervisorName() {
		String result = us.getStudentMap().get("a1000").getSupervisorName().toString();
		assertEquals("[Suzy Walker]", result);
	}

// returns true if the UnderGraduateStudent or PostGraduateTaught have credits equal to their respective modules
// returns true if PostGraudateResearch has been assigned
	@Test
	public void checkRegistrationTestPostGraduateTaught() {
		boolean result = us.getStudentMap().get("a1003").checkCorrectRegistration();
		assertEquals(true, result);
	}

	@Test
	public void checkRegistrationPostGraduateResearch() {
		boolean result = us.getStudentMap().get("a1000").checkCorrectRegistration();
		assertEquals(true, result);
	}

}
