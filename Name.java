package advancedprogramming.mutableclasses;

public class Name  {

	private String firstName;
	private String lastName;
	
	public Name (String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
	// throw illegal argments exceptions if first name is null. Defensive programming. 
	// set methods - name is mutable. 
	 public void setFirstName(String firstName) { 
	        if (firstName.length() == 0)
	            throw new IllegalArgumentException("Empty first name");
	        
	        this.firstName = firstName;
	    }
	 // return the string of firstName
	public String getFirstName ()
	{
		return firstName;
	}
	/// throw illegal argments exceptions if last name is null. Defensive programming. 
	// set methods - name is mutable. 
	 public void setLastName(String lastName) { 
	        if (lastName.length() == 0)
	            throw new IllegalArgumentException("Empty last name");
	        
	        this.lastName = lastName;
	    }
	
	public String getLastName()
	{
		return lastName;
	}
	// uses char at of the first and last names to get the initals and then concatanates them together
	public String getNameInitials() {
		 char f = getFirstName().charAt(0);
		 char l = getLastName().charAt(0);
		 String full = f + "" + l;
		 return full;
	}
	
	// overiding equals to gain logical equivalence rather than referential equivalence if the name is the same as someone else's name object. 
		public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        
	        if (!(obj instanceof Name))
	            return false;
	        
	        final Name name = (Name) obj;
	        
	       
	        return firstName.equals(name.firstName)
	                && lastName.equals(lastName);
	    }
		// hashcode needs to be overidden with equals.
		 public int hashCode() {
		        int hc = 17;
		        
		        hc = 37 * hc + firstName.hashCode();
		        
		        return 37 * hc + lastName.hashCode();
		    }
		 
		 public String toString() {
		        return firstName + " " + lastName;
		    }

}

	