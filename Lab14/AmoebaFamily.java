import java.util.*;

public class AmoebaFamily implements Iterable<AmoebaFamily.Amoeba>{

	private Amoeba myRoot = null;

	// A constructor that starts an Amoeba family with an amoeba
	// with the given name.
	public AmoebaFamily(String name) {
		myRoot = new Amoeba(name, null);
	}

	// Add a new amoeba named childName as the youngest child
	// of the amoeba named parentName.
	// Precondition: the amoeba family contains an amoeba named parentName.
	public void addChild(String parentName, String childName) {
		if (myRoot != null) {
            myRoot.addChild(parentName, childName);
		}
	}

	// Makes all Amoeba names only lower case letters.
	public void makeNamesLowercase() {
		// Your goal is to make this as similar as possible to addChild
		if(myRoot != null) {
			myRoot.reName();
		}

	}

	// Replaces the name of an amoeba named currentName with the name newName.
	// Precondition: the amoeba family contains an amoeba named currentName.
	public void replaceName(String currentName, String newName) {
		// Your goal is to make this as similar as possible to addChild
		if(myRoot != null) {
			myRoot.rePlace(currentName, newName);
		}
	}

	// Print the names of all amoebas in the family.
	// later you will write print() that has more interesting formatting
	public void printFlat() {
		// Your goal is to make this as similar as possible to addChild
		if(myRoot != null) {
			myRoot.printPretty(0);
		}
	}

	// Print the names of all amoebas in the family.
	// Names should appear in preorder, with children's names
	// printed oldest first.
	// Members of the family constructed with the main program above
	// should be printed in the following sequence:
	// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
	// Bill, Hilary, Fred, Wilma, auntie
    // This is the pretty print exercise.
	public void print() {
		if(myRoot != null) {
			myRoot.print();
		}
	}

	// returns the length of the longest name in the Amoeba Family
	public int longestNameLength() {
		if (myRoot != null) {
			return myRoot.longestNameLength();
		}
		return 0;
	}
    
	// instead of returning the length of the longest name, this method should
	// return the name that is longest.
	public String longestName() {
		// your goal is to make this look as similar as possible to
		// longestNameLength
		if(myRoot != null) {
			return myRoot.longestName();
		}
		return "";
	}

	public int size(){
		if(myRoot != null) {
			return myRoot.familySize();
		}
		return 0;
	}
	// Return an iterator of the amoeba family.
	public Iterator<Amoeba> iterator() {
		return new AmoebaIterator();
	}

	public static void main(String[] args) {
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.addChild("Marge", "Bill");
		family.addChild("Marge", "Hilaryyyyyyyyyyyyyyyy");
		System.out.println("Here's the family:");
		family.printFlat();
		System.out.println("longestName = " + family.longestName());
		System.out.println("Family Size = " + family.size());

		for(Amoeba a: family) {
			System.out.println(a.myName);
		}

	}

	public class AmoebaIterator implements Iterator<Amoeba> {
		// Amoebas in the family are enumerated in preorder,
		// with children enumerated oldest first.
		// Members of the family constructed with the main program above
		// should be enumerated in the following sequence:
		// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
		// Bill, Hilary, Fred, Wilma
		// Complete enumeration of a family of N amoebas should take
		// O(N) operations.

		// You will supply the details of this class in a future lab.

		//Stack version Depth first iteration
		// private Stack fringe = new Stack();
		//##################################
		//Queue version Bradth-First Iteration
		private Queue fringe = new LinkedList();

		public AmoebaIterator() {
			//Stack version Depth first iteration
			// if(myRoot != null) {
			// 	fringe.push(myRoot);
			// }

			//##################################
			//Queue version Bradth-First Iteration
			if(myRoot != null) {
				fringe.add(myRoot);
			}
		}

		public boolean hasNext() {
			return !fringe.isEmpty();
		}

		public Amoeba next() {
			//Stack version Depth first iteration

			// if(!hasNext()) {
			// 	throw new NoSuchElementException("tree ran out of elements");
			// }
			// Amoeba node = (Amoeba) fringe.pop();
			// for(int i = node.myChildren.size()-1; i >= 0; i--) {
			// 	fringe.push(node.myChildren.get(i));
			// }
			// return node;

			//##################################
			//Queue version Bradth-First Iteration

			if(!hasNext()) {
				throw new NoSuchElementException("tree ran out of elements");
			}
			Amoeba node = (Amoeba) fringe.poll();
			for(Amoeba a: node.myChildren) {
				fringe.add(a);
			}
			return node;

		}

		public void remove() {
			// Not used for now -- removal from a tree can be difficult.
			// Once you've learned about different ways to remove from
			// trees, it might be a good exercise to come back and 
			// try to implement this.
		}

	} // end of AmoebaIterator nested class

	public static class Amoeba {

		public String myName; // amoeba's name
		public Amoeba myParent; // amoeba's parent
		public ArrayList<Amoeba> myChildren; // amoeba's children


		public Amoeba(String name, Amoeba parent) {
			myName = name;
			myParent = parent;
			myChildren = new ArrayList<Amoeba>();
		}

		public String toString() {
			return myName;
		}

		public Amoeba parent() {
			return myParent;
        }

        //Add a child if parent name matches an amoeba's name,
        //or if parentName matches any of the descendents
        public void addChild(String parentName, String childName) {
            if (myName.equals(parentName)) {
                Amoeba child = new Amoeba(childName, this);
                myChildren.add(child);
            } else {
                for (Amoeba a : myChildren) {
                    a.addChild(parentName, childName);
                }
            }
        }

        //Add more void recursive functions below
        public void reName() {
        	myName = myName.toLowerCase();
        	for(Amoeba a: myChildren) {
        		a.reName();
        	}
        }

        public void rePlace(String currentName, String newName) {
        	if(myName.equals(currentName)) {
        		myName = newName;
        	}
        	for(Amoeba a: myChildren) {
        		a.rePlace(currentName, newName);
        	}
        }

        public void print(){
        	System.out.println(myName + ", ");
			for(Amoeba a: myChildren) {
        		a.print();
        	}
        }

        public String indent(int level) {
        	String result = "";
        	while(level-- != 0) {
        		result += "  ";
        	}
        	return result;
        }

        public void printPretty(int level) {
        	System.out.println(indent(level) + myName);
        	for(Amoeba a: myChildren) {
        		a.printPretty(level+2);
        	}
        }

        public String longestName() {
        	if(this.myChildren.size() == 0) {
        		return myName;
        	}
 			String longest = myName;
 			for(Amoeba a: myChildren) {
 				String child = a.longestName();
 				if(myName.length() < child.length()) {
 					longest = child;
 				}
 			}       	
        	return longest;
        }

        //Returns the length of the longest name of this Amoeba's children
        public int longestNameLength() {
            int maxLengthSeen = myName.length();
            for (Amoeba a : myChildren) {
                maxLengthSeen = Math.max(maxLengthSeen, a.longestNameLength());
            }
            return maxLengthSeen;
        }

        public int familySize() {
        	int members = 1;
        	if(myChildren.size() == 0) {
        		return 1 ;
        	}

        	for(Amoeba a: myChildren) {
        		members += a.familySize();
        	}
        	return members;
        }

        // In Amoeba
		// private int height(Amoeba x) {
		// 	if (myChildren.isEmpty()) {
		// 		return 1;
		// 	} 
		// 	else {
		// 		int bestSoFar = 1;
		// 		for (Amoeba a : myChildren) {
		// 			bestSoFar = 1 + Math.max(a.height, bestSoFar);
		// 		}
		// 		return bestSoFar;
		// 	}
		// } 
	}
} 
