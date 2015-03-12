import java.util.*;


public class HuffmanEncoding {
	private BinaryNode myRoot = null;
	private int[] result;
	private ArrayList<BinaryNode> nodes;
	protected TreeMap<String,String> table = new TreeMap<String,String>();
	public HuffmanEncoding() {
		nodes = new ArrayList<BinaryNode>();
		result = new int[256];
		myRoot = new BinaryNode("*",0);
	}

	public HuffmanEncoding(String symbol) {
		myRoot = new BinaryNode("",0);
	}

	public void countWord(FileCharIterator myIter) {
		while(myIter.hasNext()) {
			String s = myIter.next();  // s = 01100001 --> a
			int index = convertToDec(s);  // index = 97  --> a
			result[index]++;
		}
	}

	public int convertToDec(String s) {
		int i = 7;
		int result = 0;
		while(i >= 0){
			if(s.charAt(s.length() - i -1) == '1') {
				result += Math.pow(2,i);
			}
			i--;
		}
		return result;
	}

//----------------------------Create Node-----begin-----------------------------------------
	public void createNodes() {

		for(int index = 0; index< result.length; index++) {
			BinaryNode node = new BinaryNode(convertToBi(index),result[index]);
			nodes.add(node);
		}
		removeZero();
		insertionSort();
		Collections.reverse(nodes);
		// printNodes();
	}
	public void printNodes() {
		System.out.println("Size = " + nodes.size());
		for(BinaryNode node: nodes)  {
			System.out.println(node.symbol + ", " + node.freq);
		}
		System.out.println();
	}

	public String convertToBi(int index) {
		String result = "";
		int i = 7;
		while(i >= 0) {
			if(index/Math.pow(2,i) >= 1) {
				result += "1";
				index -= Math.pow(2,i);

			}
			else {
				result +="0";
			}
			i--;
		}
		return result;
	}

	public void removeZero() {
		ArrayList<BinaryNode> temp = new ArrayList<BinaryNode>();
		for(int i = 0; i < nodes.size() ; i++) {
			if(nodes.get(i).freq != 0) {
				temp.add(nodes.get(i));
			}
		}
		nodes = temp;
	}

	public void insert (ArrayList<BinaryNode> list, int k) {
        BinaryNode temp = list.get(k);
        int index = k;
        for(int i = 0; i < k ; i++) {
           if(temp.freq < list.get(i).freq){
               index = i;
               i = k;
           }
       }
       for(int j = k; j > index; j--){
       		list.set(j, list.get(j-1));
       }
       list.set(index,temp);
    }

    public void insertionSort() {
        ArrayList<BinaryNode> rtn = new ArrayList<BinaryNode>();
        for (int k = 0; k < nodes.size(); k++) {
            rtn.add(nodes.get(k));
        }
        for (int k = 0; k < rtn.size(); k++) {
            insert(rtn, k);
        }
        nodes = rtn;
    }

//-----------------------Create Nodes-------------end----------------------------------

//-------------------Construct the HuffMan Tree ----------begin------------------
    public void huffManConstruct() {
    	if(nodes.size() > 0 ) {
    		myRoot = myRoot.huffManConstruct(nodes);
    		createTable();
    	}	
    }
//---------------------------------------------------------end-------------------
	
//-------------------------------Output Encoding------------------begin------
    public void outputEncoding(FileCharIterator myIter, String outputFile) {
    	FileOutputHelper young = new FileOutputHelper();
    	String s = "";
		TreeMap<String,String> table = getTable();
		myIter = new FileCharIterator("test.txt");

		String key = "";
		String wholeString = "";
		while(myIter.hasNext()) {
			s = myIter.next();
		
			String value = table.get(s);
			while(value.length() % 8 != 0) {
				s = myIter.next();
				value = table.get(s);

				if(!myIter.hasNext()) {
					String endValue = "";
					for(int i = 0; (value.length() + endValue.length()) % 8 != 0; i++) {
						endValue += "1";
					}
					String end = "EOF";
					System.out.println (endValue);
					table.put(end, endValue);
					value += table.get(end);
					young.writeBinStrToFile(value, "output2");
					break;
				}
				value += table.get(s);
			}
			if (!myIter.hasNext()) {
				break;
			}
			young.writeBinStrToFile(value, "output2");
		}
    }


//-----------------------------------------------------end---------------



//--------------------------------------------------------begin-----
    public void outputDecoding(FileCharIterator myIter, String outputFile) {
    	ArrayList<Decoding> storeBytes = new ArrayList<Decoding>();
    	String remainder = "";
    	BinaryNode root = myRoot;
    	FileOutputHelper young = new FileOutputHelper();
    	myIter = new FileCharIterator("test.txt");

    	while(myIter.hasNext()) {
    		String word = myIter.next();

    	}
    }

    public void constructCodeWord(String bits, String remainder, BinaryNode root,ArrayList<Decoding> storeBytes, BinaryNode myRoot) {
    	if(bits == null) {
    		return;
    	}
    	if(root.left == null && root.right == null) {
    		storeBytes.add(new Decoding(root.symbol));
    		remainder = "";
    		root = myRoot;
    		constructCodeWord(bits.subString(1), remainder, root, storeBytes, myRoot);
    	}
    	else if(bits.charAt(0) == '1') {
    		remainder += "1";
    		constructCodeWord(bits.subString(1), remainder, root.right, storeBytes, myRoot);
    	}
    	else if(bits.charAt(0) == '0') {
    		remainder += "0";
    		constructCodeWord(bits.subString(1), remainder, root.left, storeBytes, myRoot);
    	}

    }

    private class Decoding {
    	public String byte;
    	public Decoding(String byte) {
    		this.byte = byte;
    	}
    }

//------------------------------------------------------end-----   
	public void print() {
		if(myRoot != null) {
			myRoot.print(0);
		}	
	}

	public void createTable(){
		if(myRoot != null) {
			myRoot.createTable("", table);
		}
	}

	public TreeMap<String,String> getTable() {
		return table;
	}

	public void printTable() {
		Iterator<String> keySetIterator = table.keySet().iterator();
		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + table.get(key));
		}
	}

	public static void main(String[] args){
		// char c = 'a';
		// System.out.println("a = " + (int) new char('c') );
		FileCharIterator myIter = new FileCharIterator("test.txt");
		HuffmanEncoding thai = new HuffmanEncoding();
		thai.countWord(myIter);
		thai.createNodes();
		thai.printNodes();
		thai.huffManConstruct();
		thai.print();

		thai.printTable();

		thai.outputEncoding(myIter, "output2");

		thai.printTable();
		
	}

	public static class BinaryNode {
		public String symbol;
		public int freq;
		public BinaryNode parent;
		public BinaryNode left; // zero
		public BinaryNode right; // one


		public BinaryNode(String sym, int freq) {
			symbol = sym;
			this.freq = freq;
			left = right = null;
		}
		public BinaryNode(BinaryNode left, BinaryNode right) {
			this.freq = left.freq + right.freq;
			this.symbol = Integer.toString(this.freq);
			this.left = left;
			this.right = right;
		}

		public BinaryNode huffManConstruct(ArrayList<BinaryNode> nodes) {
			// System.out.println("root = " + root.symbol);
			// System.out.println("left = " + left.symbol);
			// System.out.println("right = " + right.symbol);
			// System.out.println("Size = " + nodes.size());
			// System.out.println("root = " + nodes.get(nodes.size() - 1).freq);
			// System.out.println();
			// printNodes(nodes);
			if(nodes.size() == 1) {
				return nodes.get(0);
				// root = nodes.get(0);
			}
			else {
				BinaryNode temp = combine(nodes.get(nodes.size()-2), nodes.get(nodes.size()-1));
				nodes.remove(nodes.size()-1);
				nodes.remove(nodes.size()-1);
				Collections.reverse(nodes);
				nodes.add(temp);
				insert(nodes, nodes.size() -1);
				Collections.reverse(nodes);
				// printNodes(nodes);
				return huffManConstruct(nodes);
			}
		}

		public BinaryNode combine(BinaryNode node1, BinaryNode node2) {
			return new BinaryNode(node1 ,node2);
		}

		public void createTable(String s, TreeMap<String,String> table) {
			if(left == null && right == null) {
				table.put(symbol, s);
			}
			if(left != null) {
				left.createTable(s + "0", table);
			}
			if(right != null) {
				right.createTable(s + "1", table);
			}
		}

		public void printNodes(ArrayList<BinaryNode> nodes) {
			System.out.println("Size = " + nodes.size());
			for(int i = 0; i < nodes.size(); i++)  {
				System.out.println(nodes.get(i).symbol + ", " + nodes.get(i).freq);
			}
			System.out.println();
		}

		public static void insert (ArrayList<BinaryNode> list, int k) {
	        BinaryNode temp = list.get(k);
	        int index = k;
	        for(int i = 0; i < k ; i++) {
	           if(temp.freq < list.get(i).freq){
	               index = i;
	               i = k;
	           }
	       }
	       for(int j = k; j > index; j--){
	       		list.set(j, list.get(j-1));
	       }
	       list.set(index,temp);
	    }

	    private void print(int indent) {
	    	
            if(right != null && left != null) {
                right.print(indent + 2);
                println(symbol, indent);
                left.print(indent + 2);
            }
            else if(left != null) {
                left.print(indent + 2);
                println(symbol, indent);
            }
            else if(right != null) {
                right.print(indent + 2);
                println(symbol, indent);
            }
            else {
                println(symbol, indent);
            }
        }

        private static final String indent1 = "    ";
        private static void println (String sym, int indent) {
            for (int k = 0; k < indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(sym);
        }



	}
}
