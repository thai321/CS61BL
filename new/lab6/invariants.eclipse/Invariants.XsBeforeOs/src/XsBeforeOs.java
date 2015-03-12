public class XsBeforeOs {

    // Rearrange the elements of values so that all the X's
    // precede all the O's.
    public static void rearrange (char [ ] values) {
        int lastXpos = -1;
        for (int k=0; k<values.length; k++) {
            if (values[k]=='X') {

                // you fill this in

            }
            if (!isOK (values, k)) {
                System.out.println ("inconsistency at position " + k);
            }
        }
    }

    // Check for consistency.
    // All the X's in elements 0 to k of values should precede all the O's.
    public static boolean isOK (char [ ] values, int k) {

        // you fill this in
        return true;

    }
}
