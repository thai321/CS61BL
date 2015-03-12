public class Debug {

    String myString;

    public Debug (String s) {
        myString = s;
    }

    // Return true when myString is the result of inserting
    // exactly one character into s, and return false otherwise.
    public boolean contains1MoreThan (String s) {
        if (myString.length ( ) == 0) {
            return false;
        } else if (s.length ( ) == 0) {
            return myString.length ( ) == 1;
        } else if (myString.charAt(0) == s.charAt(0)) {
            Debug remainder = new Debug (myString.substring(1));
            return remainder.contains1MoreThan (s.substring(1));
        } else {
            // return myString.substring(1) == s; 
            return myString.substring(1).equals(s);
        }
    }

    public static void main (String [ ] args) {
        check ("abc", "def");  // should be false
        check ("abc2", "abc"); // should be true

        System.out.println("\n1)Test case for contains1MoreThan correctly return true\n");
        check("hello2","hello");
        check("bingo1", "bingo");
        check("a","");

        System.out.println("\n2)Test case for cocontains1MoreThan correctly returns false.\n");
        check("bingo123", "2bingo31");
        check("match23", "match");
        check("john","katy");
        check("1","123");
        check("abcd", "ab");

        System.out.println("\n3) There is no pairs of strings for which contains1Morethan incorrectly returns true\n");
       
        System.out.println("\n4)Test case for contains1MoreThan incorrectly returns false.\n");
        check("5computer","computer");
        check("ab2c","abc");
        check("3there", "there");

        System.out.println("\n4)Test case for contains1MoreThan crashes.\n");
        check (null, "abc");
        check ("abc", null);
        check(null, null);
    }

    public static void check (String s1, String s2) {
        Debug d = new Debug (s1);
        if (d.contains1MoreThan (s2)) {
            System.out.println (s1 + " is the result of adding a single character to " + s2);
        } else {
            System.out.println (s1 + " is not the result of adding a single character to " + s2);
        }
    }
}
