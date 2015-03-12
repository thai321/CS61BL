public class CheckDigit {

    public static void main (String [ ] args) {
        int id = 0;
        try {
            id = Integer.parseInt (args[0]);
        } catch (NumberFormatException e) {
            System.out.println ("The argument has to be a sequence of digits.");
            System.exit (1);
        }
        boolean isLegal = true;
        // your missing code goes here
        int check_digit = id%10;
        int id_copy = id/10, sum = 0;

        while(id_copy > 0) {
            sum = sum + id_copy%10;
            id_copy = id_copy/10;
        }
        if(sum%10 != check_digit)
            isLegal = false;

        if (isLegal) {
            System.out.println (id + " is legal");
        } else {
            System.out.println (id + " is not legal");
        }
    }
}
