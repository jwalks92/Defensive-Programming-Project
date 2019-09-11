package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.students.PostGraduateResearch;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.students.UnderGraduateStudent;
import advancedprogramming.systems.UniversitySystem;
// following shows how since how each student type has differnt module credit maximum ammounts, their maximum limit and the Modules
// that they can hold will differ
//also note the system out print line when a student goes over the top of their max. 
public class ModuleExceededTest {
 static UniversitySystem us = new UniversitySystem();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
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
		
		Name name2 = new Name("Aidan", "Walker");
		String type2 = "UnderGraduateStudent";
		String dateOfBirth2 = "02/12/1994";
		us.registerStudent(name2, dateOfBirth2, type2);
	
		Name name3 = new Name("maria", "Walker");
		String type3 = "PostGraduateResearch";
		String dateOfBirth3 = "02/02/1966";
		us.registerStudent(name3, dateOfBirth3, type3);
		
		Name name4 = new Name("Brian", "Walker");
		String type4 = "PostGraduateTaught";
		String dateOfBirth4 = "02/02/1966";
		us.registerStudent(name4, dateOfBirth4, type4);
		
		UnderGraduateStudent student = (UnderGraduateStudent) us.getStudentMap().get("a1000");
		student.addModule(moduleObject3);
		student.addModule(moduleObject1);
		student.addModule(moduleObject2);
		student.addModule(moduleObject3);
		
		// from the testing we can see that max credits have been exceeded by what is printed on the console. 
		
		PostGraduateResearch research = (PostGraduateResearch) us.getStudentMap().get("a1001");
		
		PostGraduateTaught post = (PostGraduateTaught) us.getStudentMap().get("a1002");
		post.addModule(moduleObject1);
		post.addModule(moduleObject2);
		post.addModule(moduleObject3);
		
	}

	@Test
	public void underGraduateStudentTest() {
		int result = us.getStudentMap().get("a1000").getCredits();
		assertEquals(120, result);
		//note that despte the credits total being 180, it maxes out at 120. This is because of the Max_Credits variable placed upon
		// each student.
	}
	
	@Test
	public void postGraduateResearchTest() {
		int result = us.getStudentMap().get("a1001").getCredits();
		assertEquals(0, result);
		//The credits total is 0. This is because PostGradResearchStudent's cannot have any credits or have any credits added to it.
	}
	
	@Test
	public void postGraduateTaught() {
		int result = us.getStudentMap().get("a1002").getCredits();
		assertEquals(180, result);
		//note that despte the credits total being 180, the credit total is also 180, this is because the Max_Credits ammount for a PostGraduateTaught student is 180.
	}

}
