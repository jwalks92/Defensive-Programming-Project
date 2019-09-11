package advancedprogramming.systems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import advancedprogramming.mutableclasses.Module;
import advancedprogramming.mutableclasses.Name;
import advancedprogramming.mutableclasses.Supervisor;
import advancedprogramming.students.Student;

public class ReadingFiles {
	// files AdvancedProgramming.txt and SupervisorDocument.txt are saved in the
	// eclipse document. Means that they can be accessed
	// alongside the rest of the code for inspection and testing purposes.
	// the assumption is that whilst modules and supervisors will need to be presented onto a seperate HashMap or arraylist 
	// to be stored later.
	// however with students the assumption is that this is a list of individuals who are going to be signed up to a univeristy
	// may not pass certain requirements, i.e their A level requirements or their research gets funded for example. 
	// Therefore like module and supervisor they are also stored into a list until future notice.
	// it also presents the opportunity to effectively use the valueOf String method as specified in the coursework assessment document.
	UniversitySystem us = new UniversitySystem();
	private ArrayList<Module> moduleList;
	private HashMap<Integer, Supervisor> supervisorMap ;
	private HashMap<Integer, String> studentReaderMap ;
	 
	
	public ReadingFiles() {

		moduleList = new ArrayList<Module>();
		supervisorMap = new HashMap<Integer, Supervisor>();
		studentReaderMap = new HashMap<Integer, String>();
		
	}

	public void ModuleReader() throws IOException, NumberFormatException, FileNotFoundException {

		try {
			BufferedReader br = new BufferedReader(new FileReader("AdvancedProgramming.txt"));
			// BufferedReader was used as I wanted faster performance than a Scanner.
			// It seemed logical to use BufferedReader as the was no interface with the user
			// and so scanner seemed unnecessary.

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] details = line.split(",");
				String moduleCode = details[0];
				String moduleName = details[1];
				String Credits = details[2];
				int moduleCredits = Integer.parseInt(Credits);
				Module moduleObject = new Module(moduleCode, moduleName, moduleCredits);
				moduleList.add(moduleObject);

				// the code above splits the line according to the commas.
				// Because the assumption is that the layout of both files are always
				// consistent,
				// the program therefore therefore splits up each line and assigns them to
				// respective primitive types
				// these are then assigned to a moduleObject and placed in a module Hash Map for
				// uniqueness purposes.
				// Assumption made is that an ideal system would want a list or collection of
				// Modules before they are assigned to anyone.
				// This makes more sense as certain types of students would only takes certain
				// Modules.
				// All this applies to supervisor below as well.
			}
				br.close();
		} catch (IOException e) {
			System.err.println("Error: " + e);
		} catch (NumberFormatException e) {
			System.err.println("Invalid number");
		}

	}

	public void SupervisorReader() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("SupervisorDocuments.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] details = line.split(",");
			String firstName = details[0];
			String lastName = details[1];
			Name name = new Name(firstName, lastName);
			Supervisor supervisorObject = new Supervisor(name);
			int numRep = supervisorObject.hashCode();
			supervisorMap.put(numRep, supervisorObject);
			
		}
		br.close();
	}
	
	public void StudentReader() throws IOException, NullPointerException, ParseException {
		BufferedReader br = new BufferedReader(new FileReader("StudentList.txt"));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			String help = String.valueOf(line);
			studentReaderMap.put(help.hashCode(), help);
		}
		br.close();
	}
	//defesnive copying and returning a new module
	public ArrayList<Module> getModuleList() {
		return new ArrayList<Module>(moduleList);
	}
	// adds a module
	public void addModule(Module x) {
		moduleList.add(x);
	}
	// prints out all modules
	public void printModule() {
		for (Module m : moduleList) {
			System.out.println(m);
		}
	}
	// defensive copying
	public HashMap<Integer, String> getStudentReaderMap() {
		return new HashMap<Integer, String>(studentReaderMap);
	}

	public HashMap<Integer, Supervisor> getSupervisorMap() {
		return new HashMap<Integer, Supervisor>(supervisorMap);

	}
}
