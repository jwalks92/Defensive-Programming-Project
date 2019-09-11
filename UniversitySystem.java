package advancedprogramming.systems;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.students.PostGraduateResearch;
import advancedprogramming.students.PostGraduateTaught;
import advancedprogramming.students.Student;
import advancedprogramming.students.UnderGraduateStudent;

public class UniversitySystem {

	private static UniversitySystem SYSTEM = new UniversitySystem();
	// making a singleton class.
	// assumption - only want one University System.

	private HashMap<String, Student> studentMap;

	// HashMap of Students allows me to more effectively accomplish the amends
	// Student method as Student ID is an assigned key,and can act as such in the
	// constructor.

	public UniversitySystem() {

		studentMap = new HashMap<String, Student>();
	}

	//the below adds a Module or Supervisor to a given Student. It also changes a students name if necessary. 
	// assumption is that a single person cannot ovveride the modules that they have taken in the past.
	// although it is possible for them to change their name.
	// note that the assumption is that people can only change one attribute at a time, to ensure that information inputted it correct

	public void ammend(String studentID, Module module, Supervisor supervisor, Name naming)
			throws NullPointerException {

		try {
			for (String possibleKey : studentMap.keySet()) {
				if (possibleKey.equals(studentID)) {
					Student student = studentMap.get(possibleKey);
					if (student.getStudentType().equals("UnderGraduateStudent") && (supervisor == null)
							&& (naming == null)) {
						((UnderGraduateStudent) student).addModule(module);

					} else if (student.getStudentType().equals("PostGraduateTaught") && (supervisor == null)
							&& (naming == null)) {
						((PostGraduateTaught) student).addModule(module);
					} else if (student.getStudentType().equals("PostGraduateResearch") && (module == null)
							&& (naming == null)) {
						((PostGraduateResearch) student).addSupervisor(supervisor);
					} else if ((student.getStudentType() != null) && (module == null) && (supervisor == null)) {
						student.setName(naming);

					}

				}
			}
		} catch (NullPointerException e) {
			System.out.println("Please enter the correct information");
		}

	}

	// goes through all values of the HashMap and then checks whether the get Student type method is equal to the string specified in the parameter.
	//Count increases if it is and is returned. 
	public int noOfStudents(String type) {
		int count = 0;
		for (Student student : studentMap.values()) {
			if (student.getStudentType().equals(type)) {
				count++;
			}
		}
		return count;
	}

	// counts the number of students - necessary for overall system and for adequate
	// testing of the terminate student method.
	public int countStudent() {
		int count = 0;
		for (Student student : studentMap.values()) {
			count++;
		}
		return count;
	}

	//With a HashMap looping with a for each loop for example is not possible as removing an object simultaneously causes an error.
	//As such an iterator is necessary.
	public void terminateStudent(String studentID) throws NullPointerException {
		try {
			for (Iterator<Map.Entry<String, Student>> it = studentMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, Student> entry = it.next();
				if (entry.getKey().equals(studentID)) {
					it.remove();

				}
			}
		} catch (NullPointerException e) {
			System.out.println("No one of such name");
		}
	}

	//Combines the object factories specified in the Student subclasses. 
	//The string type uses the equals method (which works differently for strings as opposed to objects unless overridden).
	//Whatever type is specified is whatever student factory is instantiated. 
	//They are assigned their own unique Student ID's as their keys for their Hash Maps and then added.

	public void registerStudent(Name name, String dateOfBirth, String type) throws ParseException, NullPointerException {
		try {
			if (type.equals("UnderGraduateStudent")) {
				UnderGraduateStudent student = UnderGraduateStudent.getInstance(name, dateOfBirth);
				if (student != null) {
					if (student.checkAge() >= 17) {
						String idRep = student.getStudentID().toString();
						studentMap.put(idRep, student);
					} else {
						System.out.println("Student is too young to be registered for UndergraduateStudent");
					}
				}
			}
			if (type.equals("PostGraduateTaught")) {
				PostGraduateTaught student = PostGraduateTaught.getInstance(name, dateOfBirth);
				if (student != null) {
					if (student.checkAge() >= 17) {
						String idRep = student.getStudentID().toString();
						studentMap.put(idRep, student);
					} else {
						System.out.println("Student is too young to be registered for PostGraduateTaught");
					}
				}
			}
			if (type.equals("PostGraduateResearch")) {
				PostGraduateResearch student = PostGraduateResearch.getInstance(name, dateOfBirth);
				if (student != null) {
					if (student.checkAge() >= 20) {
						String idRep = student.getStudentID().toString();
						studentMap.put(idRep, student);
					} else {
						System.out.println("Student is too young to be registered for PostGraduateResearch");
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Please enter the correct information");
		}
		catch (ParseException e) {
			System.out.println("Cannot convert from number to string");
		}

	}

	// Returns the HashMap of Student Objects and their StudentId keys.

	public HashMap<String, Student> getStudentMap() {
		return studentMap;
	}

	// Prints out all overridden to String Student objects (the values of the Hash
	// Map.

	public void printAllStudents() {

		for (Student student : studentMap.values()) {
			System.out.println(student.toString());

		}

	}

}
