public class Trie {

    // Indices 0, 1, 2 represent the letters a, b, c, etc.
    // This array contains the nodes at the top level of the trie.
    private TrieNode[] myWords;
    public Trie() {
        myWords = new TrieNode[26];
    }

    public void insertWord(String word) {
        int value = charToIndex(word.charAt(0));
        String s = word.substring(0,1);
        myWords[value] = new TrieNode(s);
        myWords[value].insertWord(word.substring(1),s);
    }

    // Returns true only for words that were inserted.
    public boolean containsWord(String word) {
        // YOUR CODE HERE
        int value = charToIndex(word.charAt(0));
        String s = word.substring(0,1);
        if(myWords[value] != null) {
            return myWords[value].contains(word.substring(1), word.substring(0,1));
        }
        return false;
    }

    // Returns the index of myWords that the input char corresponds to.
    // You can also use this in TrieNode.
    // Assumes that the input is a lowercase alphabetic char.
    public static int charToIndex(char c) {
        return ((int) c) - 97;
    }

    public void print() {
        TrieNode temp[] = myWords; 
        System.out.println("1st = " + temp[0].myPrefix + ", " + temp[0].isCompleteWord);
        System.out.println("2nd = " + temp[0].myDescendants[1].myPrefix + ", " + temp[0].myDescendants[1].isCompleteWord);
        System.out.println("3rd = " + temp[0].myDescendants[1].myDescendants[2].myPrefix + ", " + temp[0].myDescendants[1].myDescendants[2].isCompleteWord);
    }

    public static void main(String[] args) {
        Trie thai = new Trie();
        thai.insertWord("abc");
        thai.print();
        String s = "a";
        System.out.println("substring = " + s.substring(1));


       System.out.println(thai.containsWord("abc"));

    }


    private class TrieNode {
        private String myPrefix;
        
        // This array contains the nodes just below this trie node.
        private TrieNode[] myDescendants;
        private boolean isCompleteWord;

        private TrieNode(String prefix){
            myPrefix = prefix;
            myDescendants = new TrieNode[26];
        }

        public void insertWord(String word, String s) { 
            if(word.length() != 0){   
                isCompleteWord = false;
                int value = charToIndex(word.charAt(0));
                if(myDescendants[value] == null) {
                    myDescendants[value] = new TrieNode(s + word.charAt(0)); 
                    s = myDescendants[value].myPrefix;
                }

                if(word.length() == 1) {
                    myDescendants[value].insertWord("",s); 
                }
                if(word.length() > 1) {
                    myDescendants[value].insertWord(word.substring(1),s); 
                }
                isCompleteWord = false;
            }
            else {
                isCompleteWord = true;
            }   
        }
        public boolean contains(String word, String s) {
            if(word.length() == 0) {
                return s.equals(myPrefix) && isCompleteWord;
            }
            else {
                int value = charToIndex(word.charAt(0));
                if(myDescendants[value] == null) {
                    return false;
                }
                else {
                    s += word.substring(0,1);
                    return myDescendants[value].contains(word.substring(1), s);
                }
            }
        }
    }
}