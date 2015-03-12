public class Date implements Comparable<Date> {
    
    // You may need to change the modifiers of the instance variables below
    int month;
    int dayOfMonth;
    int year;
    
    public Date(int month, int dayOfMonth, int year) {
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.year = year;
    }
    
    /**
     *  Assume the date is well-formed.
     *  If the current date occurs before ARG, return -1
     *  If the current date is the same day as ARG, return 0
     *  Otherwise, return 1
     */
    @Override
    public int compareTo(Date ARG) {
        // TODO to be implemented
        if (this.year < ARG.year) {
            return -1;
        }
        else if(this.year == ARG.year) {
            if(this.month == ARG.month) {
                if(this.dayOfMonth == ARG.dayOfMonth) {
                    return 0;
                }
                else if(this.dayOfMonth < ARG.dayOfMonth) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else if(this.month < ARG.month) {
                return -1;
            }
            else {
                return 1;
            }
        }
        return 1;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(this == o) {
            return true;
        }
        if(!(o instanceof Date)) {
            return false;
        }
        Date s = (Date) o;

        boolean a = new Integer(this.year).equals(new Integer(s.year));
        boolean b = new Integer(this.month).equals(new Integer(s.month));
        boolean c = new Integer(this.dayOfMonth).equals(new Integer(s.dayOfMonth));
        return a && b && c;
    }
}