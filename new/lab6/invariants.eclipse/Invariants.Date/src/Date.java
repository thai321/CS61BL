
public class Date {
    
    private int myDateInMonth;  // dates-in-month range from 1 through the number of days in the month
    private int myMonth;        // months range from 1 (January) through 12 (December)
    private int myYear;         // years are between 1900 and 2100 (arbitrary decision)

    public Date (int dateInMonth, int month, int year) {
        myDateInMonth = dateInMonth;
        myMonth = month;
        myYear = year;
    }
    
    // Determine if the date information is internally consistent.
    public boolean isOK ( ) {
        int leapDay;
        if (myYear % 4 != 0) {
            leapDay = 0;
        } else if (myYear % 100 != 0) {
            leapDay = 1;
        } else if (myYear % 400 != 0) {
            leapDay = 0;
        } else {
            leapDay = 1;
        }

        // you fill in the rest of this method
    }
}
