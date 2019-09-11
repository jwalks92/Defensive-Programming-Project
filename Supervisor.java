package advancedprogramming.mutableclasses;

public class Supervisor {

	// given that supervisor has a set method inside of it, it is mutable.
	
	private final Name name;
	
	// throw illegal argments exceptions if name is null. Defensive programming.

	public Supervisor(Name name) {
		if (name == null)
			throw new IllegalArgumentException("name is null");
		this.name = new Name(name.getFirstName(), name.getLastName());
		
	}
	
	//Returns a new name object, defensive copying. 

	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}
	
	//set method. 
	
	public void setName(Name naming)
	{
		name.setFirstName(naming.getFirstName());
		name.setLastName(naming.getLastName());
	}
	
	public String toString()
	{
		return name.toString();
	}
}
