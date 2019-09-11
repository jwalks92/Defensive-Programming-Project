package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.students.UnderGraduateStudent;
import advancedprogramming.systems.UniversitySystem;

public class PassPercentageTest {
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
		//cast that over to a specific student type and then create the method from there.
		
		PostGraduateTaught taught = (PostGraduateTaught) us.getStudentMap().get("a1000");
		taught.addMark(50);
		
		UnderGraduateStudent student = (UnderGraduateStudent) us.getStudentMap().get("a1001");
		student.addMark(40);
		
		System.out.println(student.getMarks());
		System.out.println(taught.getMarks());
		System.out.println(student.getMarkPercentage());
		System.out.println(taught.getMarkPercentage());
	}
	
	//Checks if the student has passed their tests.
	// note that it will be differnt for both students despite having the same mark as they have differnt pass percentages.
	@Test
	public void passedGradeTest() {
		PostGraduateTaught taught = (PostGraduateTaught) us.getStudentMap().get("a1000");
		boolean result = taught.checkPassedTest();
		assertEquals(true, result);
	
	}

	@Test
	public void passedGradeTest2() {
		UnderGraduateStudent student = (UnderGraduateStudent) us.getStudentMap().get("a1001");
		boolean result = student.checkPassedTest();
		assertEquals(true, result);
	}
}
