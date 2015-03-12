//    #3: Classroom Object Diagram
//    Draw an object diagram for the objects created by the main method below.

public class Student {
	String name;
	int sid;

	public Student(String person, int sid) {
		this.name = person;
		this.sid = id;
	}
}

public class Classroom {
	String teacher;
	String subject;
	int myCount = 0;
	int myCountw = 0;
	Student[] roster;
	Student[] waitlist;

	public Classroom(String name, String topic, int capacity) {
		this.teacher = name;
		this.subject = topic;
		this.roster = new Student[capacity];
		this.waitlist = new Student[capacity * 2];
	}

	public static void main(String[] args) {
	    Classroom cs61bl = new Classroom(“Edwin”, “Data Structures”, 4);
	    cs61bl.roster[0] = new Student(“James”, 007);
	    cs61bl.roster[1] = new Student(“Pippy”, 102);
    }
	
}

// #4: Classroom Invariants
// Note: This problem builds upon the skeleton code in problem #3.
// Implement the following method headers:

// public void enroll(Student p);

// public void addToWaitlist(Student p);

// public void drop(Student p);

// public void removeFromWaitlist(Student p);

// Change the code in the Classroom class above so that it follows the following invariants. 
// If something violates an invariant, the code should throw an IllegalArgumentException with a descriptive error message.

// 1. Student cannot be in both waitlist and class roster.
// 2. Student cannot be in the waitlist (or roster) more than once.
// 3. If the number of students is equal to the capacity, students can no longer be enrolled into the roster.
// 4. If the number of students on the waitlist is greater than twice the capacity of the class, students can no longer get onto the waitlist.
// 5. If there are empty seats in the roster, the waitlist should be empty.

public void enroll (Student p) {

	if(myCountw >= roster.length){
		throw new IllegalArgumentException("students can no longer be enrolled into the roster");
	}
	for(Student s: roster) {
		if(s.name.equals(p.name)) {
			throw new IllegalArgumentException("student is allready in the roster");
		}
	}
	for(Student s: waitlist) {
		if(s.name.equals(p.name)) {
			throw new IllegalArgumentException("student is allready in the waitlist");
		}
	}
	for(int i = 0; i < roster.length; i++) {
		if(roster[i] == null) {
			roster[i] = p;
		}
	}
}

public void addToWaitlist(Student p) {

	if(myCount >= roster.length){
		throw new IllegalArgumentException("students can no longer be enrolled into the roster");
	}
	for(Student s: roster) {
		if(s.name.equals(p.name)) {
			throw new IllegalArgumentException("student is allready in the roster");
		}
	}
	for(int i = 0; i < roster.length; i++) {
		if(roster[i] == null) {
			roster[i] = p;
		}
	}

	for(int i = 0; i < waitlist.length; i++) {
		if(waitlist[i] == null) {
			waitlist[i] = p;
		}
	}
}

public void drop(Student p) {
	for(int i = 0; i < waitlist.length; i++) {
		if(roster[i].name.equals(p.name)) {
			roster[i] = null;
		}
	}
}

public removeFromWaitlist(Student p) {
	for(int i = 0; i < waitlist.length; i++) {
		if(waitlist[i].name.equal(p.name)) {
			waitlist[i] = null;
		}
	}
}

// #1: Inverse Mapper: Generics, Inheritance, Interfaces

public interface Function<Input, Output> {
public Output apply(Input item);
}

public interface InvertibleFunction<Input, Output> extends Function<Input, Output> {

    public Input invert(Output item);

}
public class AddsTen implements Function<Integer, Integer> {

    public Integer apply (Integer num) {
        return num + 10;
    }
}
public class InvertibleAddsTen extends AddsTen implements InvertibleFunction<Integer, Integer> {
    // YOUR CODE HERE
	public Integer invert(Integer num) {
		return num - 10;
	}
}


// #2: Filter: Generics, Inheritance, Interfaces

// Note: There are three parts to this question.

 

// ArrayList methods: add(E elem), get(int index), size(), remove(Object o), remove(int index)

 

public interface Function<Input, Output> {

    public Output apply(Input item);

}

 

public interface BooleanFunction<T> extends Function<T, Boolean> {

}

public class LongerThanFiveChars implements BooleanFunction<String> {

    // PART A: YOUR CODE HERE

}

 

public class Filter<T> {

 

    private BooleanFunction<T> func;

 

    public Filter(BooleanFunction<T> function) {

        this.func = function;

    }

 

    /* This should be a non-destructive function. It should not change the contents of the

     * input ArrayList. */

    public ArrayList<T> filter(ArrayList<T> in) {

        // PART B: YOUR CODE HERE

    }

 

    public static void main(String[] args) {

        Filter<String> longNames = new Filter<String>(new LongerThanFiveChars());

        List<String> names = Arrays.asList("green", "black", "chai", "oolong", "assam",

	"english breakfast", "earl grey", "milk", "genmai", "hibiscus", "white", "thai iced", "iced");

        ArrayList<String> teas = new ArrayList<String>(names);

        ArrayList<String> longTeas = longNames.filter(teas);

        System.out.println(longTeas);

    }

}

 

// PART C: What does main print out?