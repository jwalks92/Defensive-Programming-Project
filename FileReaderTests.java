package advancedprogramming.testclasses;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.systems.ReadingFiles;
import advancedprogramming.systems.UniversitySystem;

public class FileReaderTests {
	static ReadingFiles rf = new ReadingFiles();
	static UniversitySystem us = new UniversitySystem();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rf.ModuleReader();
		rf.SupervisorReader();
		rf.StudentReader();
	}

	@Test
	public void moduleTest() {
		String result = rf.getModuleList().toString();
		assertEquals("[CSC8010:Advanced Programming:80, CAC8111:Module Design:100]", result);
	}

	@Test
	public void superviosrTest() {
		String result = rf.getSupervisorMap().values().toString();
		assertEquals("[Darth  Vader, Buzz  Lightyear]", result);
	}

	@Test
	public void studentReaderTest() {
		String result = rf.getStudentReaderMap().values().toString();
		assertEquals(
				"[Jacob Walker, 13/09/1992, PostGraduateTaught, Aidan Walker, 02,12/1994, UnderGraduateStudent, Brian Walker,05/10/1964,PostGraduateResearch, Maria Walker, 10/02/1064,PostGraduateResearch]",
				result);

	}
}
