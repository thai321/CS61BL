public class Test {
	public static void main(String[] args) {
		int[] value = new int[5];
		int i = 0;
		while(i < value.length)
			value[i++] = i;
		i = 2;
		while(i < value.length - 1)
			value[i++] = value[i];
		for(int n : value)
			System.out.print(n + " ");
		System.out.println(); 
	}
}