public class StartsWithA implements Function<String, Boolean> {
    public Boolean apply(String s) {
        return s.charAt(0) == 'A';
    }
}

