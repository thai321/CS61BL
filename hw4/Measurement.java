public class Measurement {

	/*
	 * Constructor: initialize this object to be a measurement of 0 feet, 0
	 * inches.
	 */
	private int feet;
	private int inches;
	
	public Measurement() {
		this.feet = 0;
		this.inches = 0;
	}

	/*
	 * Constructor: takes a number of feet as its single argument, using 0 as
	 * the number of inches
	 */
	public Measurement(int feet) {
		this.feet = feet;
		this.inches = 0;
	}
	/*
	 * Constructor: takes the number of feet in the measurement and the number
	 * of inches as arguments (in that order), and does the appropriate
	 * initialization
	 */
	public Measurement(int feet, int inches) {
		int remain = 0;
		if(inches >= 12) {
			remain = inches/12;
			this.inches = inches%12;
		}
		else {
			this.inches = inches;
		}
			this.feet = feet + remain;
	}

	/*
	 * Adds the argument m2 to the current measurement
	 */
	public Measurement plus(Measurement m2) {	
		return new Measurement(this.feet + m2.feet, this.inches + m2.inches);
	}

	/*
	 * Subtracts the argument m2 from the current measurement. You may assume
	 * that m2 will always be smaller than the current measurement.
	 */
	public Measurement minus(Measurement m2) {
		int myInches = (this.feet*12 + this.inches) - (m2.feet*12 + m2.inches);
		return new Measurement(0, myInches);

	}

	/*
	 * Takes a nonnegative integer argument n, and returns a new object that
	 * represents the result of multiplying this object's measurement by n. For
	 * example, if this object represents a measurement of 7 inches, multiple
	 * (3) should return an object that represents 1 foot, 9 inches.
	 */
	public Measurement multiple(int multipleAmount) {
		if(multipleAmount == 0)
			return new Measurement();
		else if(multipleAmount == 1)
			return new Measurement(this.feet, this.inches);
		else if(this.inches == 0)
			return new Measurement(this.feet*multipleAmount, 0);
		
		int myInches = (this.feet*12 + this.inches)*multipleAmount;
		return new Measurement(0, myInches);		
	}

	/*
	 * toString should return the String representation of this object in the
	 * form f'i" that is, a number of feet followed by a single quote followed
	 * by a number of inches less than 12 followed by a double quote (with no
	 * blanks).
	 */
	public String toString() {
		return new String(this.feet + "\'" + this.inches + "\"");
	}
}
