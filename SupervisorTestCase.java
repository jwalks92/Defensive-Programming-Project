package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.students.PostGraduateResearch;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.systems.UniversitySystem;

// testing if adding a sueprvisor to student 
public class SupervisorTestCase {
	static UniversitySystem us = new UniversitySystem();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		String firstName = "Brian";
		String lastName = "Walker";
		Name name = new Name(firstName, lastName);
		String type = "PostGraduateResearch";
		String dateOfBirth = "20/09/1966";
		us.registerStudent(name, dateOfBirth, type);

		Name name3 = new Name("maria", "Walker");
		String type3 = "PostGraduateTaught";
		String dateOfBirth3 = "02/02/1966";
		us.registerStudent(name3, dateOfBirth3, type3);

		String first = "Suzy";
		String last = "Walker";
		Name name4 = new Name(first, last);
		Supervisor sup = new Supervisor(name4);

		PostGraduateResearch post = (PostGraduateResearch) us.getStudentMap().get("a1000");
		post.addSupervisor(sup);

	}
//first test will show the Supervisor as the student is of PostgraudateResearch type

	@Test
	public void test1() {
		String result = us.getStudentMap().get("a1000").getSupervisorName();
		assertEquals("[Suzy Walker]", result);
	}

}
