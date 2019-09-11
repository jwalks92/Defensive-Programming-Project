package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.students.UnderGraduateStudent;
import advancedprogramming.systems.UniversitySystem;
// testing how differnt modules can be added to differnt student types.
public class ModuleTests {
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
		student.addModule(moduleObject3);

	}
	// testing that module objects can be added, and how differnt sub classes react to them being added.
	@Test
	public void testModuleList() {
		String result = us.getStudentMap().get("a1001").getModuleList().toString();
		assertEquals("[CSC8010:Advanced:100, CSC9212:Medium:60]",result);
	}
	
	@Test
	public void testCredits() {
		int result = us.getStudentMap().get("a1001").getCredits();
		assertEquals(160,result);
	}
	
	@Test
	public void testModuleListUnderGrad() {
		String result = us.getStudentMap().get("a1002").getModuleList().toString();
		assertEquals("[CSC7533:Easy:20]",result);
	}
	
	@Test
	public void testModuleListPostGradResearch() {
		ArrayList<Module> result = us.getStudentMap().get("a1000").getModuleList();
		assertEquals(null,result);
	}
	
}
