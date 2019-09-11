package advancedprogramming.mutableclasses;

public class Module {

	private final String moduleName;
	private final String moduleCode;
	private final int moduleCredits;
	// all have been set to final for defensive programming purposes. String and integers are immutable. 
	
	public Module(String moduleName, String moduleCode,int moduleCredits) {
		this.moduleName = moduleName;
		this.moduleCode = moduleCode;
		this.moduleCredits = moduleCredits;
		
	}
	// returns the module name 
	public String getModuleName() {
		return moduleName;
	}
	// returns the module code 
	public String getModuleCode() {
		return moduleCode;
	}
	//returns the module credits
	public int getModuleCredits() {
		return moduleCredits;
	}
	//overides the to string method and returns all three variables.
	public String toString() {
		return getModuleName() + ":" + getModuleCode() +":" + getModuleCredits();
	}
	// overides the equals method and the hashcode. 
	// both must be overidden together as per Joshua Bloch. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moduleCode == null) ? 0 : moduleCode.hashCode());
		result = prime * result + moduleCredits;
		result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (moduleCode == null) {
			if (other.moduleCode != null)
				return false;
		} else if (!moduleCode.equals(other.moduleCode))
			return false;
		if (moduleCredits != other.moduleCredits)
			return false;
		if (moduleName == null) {
			if (other.moduleName != null)
				return false;
		} else if (!moduleName.equals(other.moduleName))
			return false;
		return true;
	}
	
	

	}


