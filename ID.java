package advancedprogramming.identification;
import java.util.HashMap;
import java.util.Map;

public class ID {

	//Student ID has two single attributes hence the char variable and the integer variable.
	
	private static final Map <String, ID> idMap = new HashMap <String, ID>();
	private final int numID;
	private final char charID;
	private static String iD;
	private static int regularNumber = 1000;
	private static char regularChar = 'a';

	//letter starts with a and has 1000 after it.
	//the number increments every time in the constructor and once higher than 9999 is reset to zero and the char is incremented.
	// if char increments above z it is set to a as there are hundreds of char characters.
	//Necessary to put in the constructor due to it being instantiated every time in its object factory. 
	// The incrementing number ensures uniqueness. 
	
	private ID() {
		
			numID = regularNumber;
			charID = regularChar;
			regularNumber ++;
			if (regularNumber > 9999) {
				regularNumber = 1000;
				regularChar++;
				if (regularChar>'z')
				{
					regularChar = 'a';
				}
			}
			
		}
	
	// Object factory. 
		public static ID getInstance()
		
		{
			ID id = new ID();
			return id;
		}
	// below return numID and char Id two separate components of the Id.
	public int getRegularNumber()
	{
		return numID;
	}
	
	public char getRegularChar()
	{
		return regularChar;
	}
	
	public String toString()
	{
		String number = Integer.toString(getRegularNumber());
		String id = getRegularChar() + number;
		return id;
	}
	
	public Map<String, ID> getHashMap()
	{
		return new HashMap<String,ID>(idMap);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charID;
		result = prime * result + numID;
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
		ID other = (ID) obj;
		if (charID != other.charID)
			return false;
		if (numID != other.numID)
			return false;
		return true;
	}
	
	

	}
