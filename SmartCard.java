package advancedprogramming.identification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import advancedprogramming.mutableclasses.Name;

public final class SmartCard {

	private final Name name;
	private final SmartCardNumber smartCardNumber;
	private final String dateOfBirth;
	private final ID id;

	private final static Map<String, SmartCard> cards = new HashMap<String, SmartCard>();

	// All fields are made final and private for immutable purposes.

	private SmartCard(Name name, String dateOfBirth, SmartCardNumber smartCardNumber, ID id) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.smartCardNumber = smartCardNumber;
		this.id = id;

	}

	// The below uses the object factory of smart card number and places it in the
	// smart card alongside other variable like get date of issue.
	// Uses same object factory approach as other classes such as the sub classes.

	public static SmartCard getInstance(Name name, String dateOfBirth) {

		SmartCardNumber sm = SmartCardNumber.getInstance(name);
		String carRep = sm.toString();
		SmartCard smart = cards.get(carRep);

		if (smart == null) {
			smart = new SmartCard(name, dateOfBirth, sm, ID.getInstance());
			cards.put(carRep, smart);
		}

		return smart;

	}

	// Converts date to a string and then gets the necessary substrings then
	// concatenates them.

	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}
	// coverts the date to a string and then takes the substring of the day the month and the year and then returns it. 
	public String getDateOfIssue() {
		Date date = new Date();
		String convertedString = date.toString();
		String fullString = (convertedString.substring(4, 7)) + "/" + (convertedString.substring(8, 10)) + "/"
				+ (convertedString.substring(24, 28));
		return fullString;
	}

	public String getDateOfBirth() throws NullPointerException {
		return dateOfBirth;
	}
// cannot do copying for this as by doing so it would increment the arbitrary number by one and therefore interfere with the rest of the system.
	public SmartCardNumber getSmartCardNumber() {
		return smartCardNumber;
	}

	public String getID() {
		return id.toString();
	}

	public String toString() {
		return String.valueOf(smartCardNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((smartCardNumber == null) ? 0 : smartCardNumber.hashCode());
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
		SmartCard other = (SmartCard) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smartCardNumber == null) {
			if (other.smartCardNumber != null)
				return false;
		} else if (!smartCardNumber.equals(other.smartCardNumber))
			return false;
		return true;
	}
	
	

}
