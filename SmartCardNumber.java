package advancedprogramming.identification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import advancedprogramming.mutableclasses.Name;

public final class SmartCardNumber {

	private static final Map<String, SmartCardNumber> cardNumbers = new HashMap<String, SmartCardNumber>();
	private final String nameInitials;
	private static String yearOfIssue;
	private static int arbitraryNumber = 10;
	private int num;

	// made up of three parts. Object constructor takes similar procedure to the id
	// class in that the arbitrary number increments every time

	private SmartCardNumber(String nameInitials, String yearOfIssue, int arbitraryNumber) {
		this.nameInitials = nameInitials;
		this.yearOfIssue = getYearOfIssue();
		num = arbitraryNumber;
		arbitraryNumber++;

	}

	// Necessary to place in Hash Map as hash map does not allow for identical
	// objects.

	public static SmartCardNumber getInstance(Name name) {

		String strRep = name.getNameInitials() + getYearOfIssue();
		SmartCardNumber smart = cardNumbers.get(strRep);
		int numb = arbitraryNumber;
		arbitraryNumber++;
		if (smart == null) {
			smart = new SmartCardNumber(name.getNameInitials(), getYearOfIssue(), numb);
			cardNumbers.put(strRep, smart);
		}

		return smart;
	}

	// The date is converted to a string object and substring is used to extract its
	// year.

	public static String getYearOfIssue() {
		Date date = new Date();
		String convertedString = date.toString();
		String yearString = convertedString.substring(24, 28);
		return yearString;
	}
	// overrides to string method
	public String toString() {
		return nameInitials + "-" + yearOfIssue + "-" + num;
	}
	// defensive copying
	public Map<String, SmartCardNumber> getMap() {
		return new HashMap<String, SmartCardNumber>(cardNumbers);
	}
	//overrides hashcode and equals methods. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameInitials == null) ? 0 : nameInitials.hashCode());
		result = prime * result + num;
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
		SmartCardNumber other = (SmartCardNumber) obj;
		if (nameInitials == null) {
			if (other.nameInitials != null)
				return false;
		} else if (!nameInitials.equals(other.nameInitials))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}
