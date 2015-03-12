import java.util.Iterator;
import java.util.ArrayList;
// YOU ARE NOT allowed to import any library function related to hashmaps
// if you feel the need you may import the ArrayList or LinkedList class

public class HashMap<K,V> implements Iterable<K> {
	private final int DEFAULT_SIZE = 30; // default size of hash map if none selected
	private float loadFactor = 0.7f; // frequency of elements the array can reach before needing resizing
	private int arraySize = DEFAULT_SIZE; // current size of the array
	private int totalRelations; // number of new KEYS in database currently
    private HashItem[] mappings;

	// no argument constructor
	public HashMap() {
        mappings = new HashMap.HashItem[arraySize];
	}
	
	// the initial size of the hashMap can be set
	// here "size" refers to the size of the underlying array
	// which will hold your HashItems
	public HashMap(int initialSize) {
        arraySize = initialSize;
        mappings = new HashMap.HashItem[arraySize];
	}

	// 2 arg constructor
	// can both set initial size as well as load factor
	public HashMap(int initialSize, float lf) {
        this.arraySize = initialSize;
        this.loadFactor = lf;
	}
		
	// CORE FUNCTIONALITY
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	// returns whether or not a given key is in the HashMap
	// should take O(1) or more precisely amoritized constant time
	public boolean hasKey(K key) {
        int hashValue = key.hashCode() % arraySize;
		if (mappings[hashValue] != null) {
            HashItem bucket = mappings[hashValue];
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    return true;
                }
                bucket = bucket.next;
            }
        }
        return false;
    }
	
	// returns whether or not a given value is stored in hashMap
	// Q: what would you expect the runtime of this function to be?
	public boolean hasValue(V value) {
        for (int i = 0; i < mappings.length - 1; i++) {
            HashItem bucket = mappings[i];
            while (bucket != null) {
                if (bucket.value == value) {
                    return true;
                }
                bucket = bucket.next;
            }
        }
        return false;
	}
		
	// standard dictionary put method (see Java docs if you have questions)
	public V put(K key, V value) {
        V previousValue = null;
        int hashValue = key.hashCode() % arraySize;
        HashItem bucket = mappings[hashValue];
        HashItem previousBucket = new HashItem();
        if (bucket != null) {
            while (bucket != null) {
                if (key.equals(bucket.key)) {
                    previousValue = bucket.value;
                    bucket.setValue(value);
                    return previousValue;
                }
                previousBucket = bucket;
                bucket = bucket.next; 
            }
            bucket = new HashItem(key, value);
            previousBucket.next = bucket;
            totalRelations++;
            return previousValue;
        } else {
            bucket = new HashItem(key, value);
            mappings[hashValue] = bucket;
            totalRelations++;
        }
        return previousValue;
    }
	
	// standard hashMap remove method (see Java docs if you have questions)
	public V remove(K key) {
        V previousValue = null;
        int hashValue = key.hashCode() % arraySize;
        HashItem bucket = mappings[hashValue];
        HashItem previous = new HashItem();
        while (bucket != null) {
            if (bucket.key == key) {
                previousValue = bucket.value;
                previous.next = bucket.next;
                bucket = null;
                break;
            } else if (bucket.next == null) {
                bucket = null;
                break;
            }
            previous = bucket;
            bucket = bucket.next;
        }
        totalRelations--;
        return previousValue;
	}
	
	// standard hashMap get method (see Java docs if you have questions)
	// should take O(1) or more precisely amoritized constant time
	public V get(K key) {
        V rtnValue = null;
        int hashValue = key.hashCode() % arraySize;
        HashItem bucket = mappings[hashValue];
        while (bucket != null) {
            if (key.equals(bucket.key)) {
                rtnValue = bucket.value;
                break;
            }
            bucket = bucket.next;
        }
        return rtnValue;
	}
	
	// returns the number of items currently in the hashMap
	public int size() {
        return this.totalRelations;
	}

    public static void main (String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(5);
        map.put("Aa", 1);
        map.put("BB", 2);
        System.out.println (map.hasKey("BB"));
        System.out.println (map.hasKey("Aa"));
        map.resize(10);
        System.out.println (map.hasKey("BB"));
        System.out.println (map.hasKey("Aa"));
    }

	// HASHMAP ITERATOR
	// HINT: THIS IS SIMILAR TO VOTEITERATOR
	// why would you need an iterator for a hash map?
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public class HashMapIterator implements Iterator<K> {
        private int mapIndex;
        private int bucketIndex;
		
		public HashMapIterator() {
            
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public Iterator<K> iterator() {
		return new HashMapIterator();
	}
	
	// RESIZING FUNCTIONS
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// boolean helper function which indicates whether you have 
	// gone above the load factor
	public boolean aboveLoad() {
        return (totalRelations / arraySize) > loadFactor;
	}
	
	// expands the size of the hashMap
	public void resize(int newSize) {
        HashItem[] newArray = new HashMap.HashItem[newSize];
        for (int i = 0; i < arraySize - 1; i++) {
            HashItem bucket = mappings[i];
            while (bucket != null) {
                int hashValue = bucket.key.hashCode() % newSize;
                HashItem previousBucket = newArray[hashValue];
                if (previousBucket != null) {
                    while (previousBucket.next != null) {
                        previousBucket = previousBucket.next;
                    }
                    previousBucket.next = new HashItem(bucket.key, bucket.value);
                } else {
                    newArray[hashValue] = new HashItem(bucket.key, bucket.value);
                }
                bucket = bucket.next;
            }
        }
        mappings = newArray;
        arraySize = newSize;
	}

	// calculates what the new size of the hashMap should be
	public int calculateNewSize() {
		return arraySize * 2;
	}
	// Q: How do you calculate the new size and what is your reasoning behind it?
	// COMMENT HERE:
	
	
	
	// INTERNAL TESTING/INVARIANT CHECKING
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// check that there are no duplicate keys
	// check that all keys are hashed to the right location
	public boolean isOk() {
		return noDuplicateKeys() && hasCorrectHashing();
	}
	
	// verifies that all entries are appropriately hashed
	public boolean hasCorrectHashing() {
		return true; // replace this!
	}
	
	// verfies that there exists only one copy of a key 
	// for all keys in all indicies in internal array
	public boolean noDuplicateKeys() {
		return true; // replace this!
	}
		
	// rekey rehashes every key in the hashMap
	public void rekey() {

	}
	
	
	// THE HASHITEM CLASS
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	// the "node" of a hashmap. Should never be accessed out of class
	private class HashItem { 
		public final K key;
		public V value;
        private HashItem next;

        public HashItem ( ) {
            this.key = null;
            this.value = null;
            this.next = null;
        }
		
		public HashItem(K inputKey, V inputValue) {
			this.key = inputKey;
			this.value = inputValue;
            this.next = null;
		}
		
		public void setValue(V val) {
			this.value = val;
		}

	}
	
	// FUNCTIONS FOR TESTING
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	// you may add what functions you like to the public interface
	// the only constraint in that of the hashItem class
	// hashItem should NEVER be accessed/returned outside of this class
	// by extension you cannot return the internal array of the hashMap
	// provide it as an argument

	// returns the array size
	public int arraySize() {
	    return this.arraySize;
	}
}
