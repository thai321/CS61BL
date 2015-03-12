import java.util.ArrayList;
public class Mapper{
	public Mapper() {}

	public static<Y,T> ArrayList<Y> map(ArrayList<T> A, Function<T,Y> F) {
		ArrayList<Y> result = new ArrayList<Y>();
		for(T temp: A) {
			result.add(F.apply(temp));
		}
		return result;
	}
	public static void main(String[] args) {
		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		ArrayList<Integer> result = new ArrayList<Integer>();
		Function f = new AddOne();
		result = Mapper.map(number, f);

		for(int n: result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}

