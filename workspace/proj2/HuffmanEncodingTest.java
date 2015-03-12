import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class HuffmanEncodingTest {

	@Test
	public void testSorted() {
		HuffmanEncoding tree = new HuffmanEncoding();
		FileCharIterator myIter = new FileCharIterator("test.txt");
		
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes = sortedNodes(nodes);

		for(BinaryNode node: nodes) {
			System.out.println(node.symbol + ", "+ node.freq);
		}
	}
}
