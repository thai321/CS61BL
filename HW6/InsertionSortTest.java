import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class InsertionSortTest {
        
    @Rule
    public ExpectedException exception = ExpectedException.none();
        
    @Test
    public void isOK1() {
        int[] arr = {1, 5, 4, 6, 8};

        // This isOK call should return nothing because the array is sorted
        // up through the element at index 1.
        InsertionSort.isOK(arr, 1);

        // This isOK call should throw an exception because the element 4
        // makes the array up through the element at index 3 out of order.
        exception.expect(IllegalStateException.class);
        InsertionSort.isOK(arr, 3);
    }
    
    @Test
    public void isOK2() {
        int[] arr = {1,2,3,4,5,20,3,6};
      
        InsertionSort.isOK(arr, 0);
        InsertionSort.isOK(arr, 1);
        InsertionSort.isOK(arr, 3);
        
         exception.expect(IllegalStateException.class); //arr is not sorted
        InsertionSort.isOK(arr,6);
        
        exception.expect(IllegalStateException.class); //k exceeds the maximum list index
        InsertionSort.isOK(arr,8);
        
        exception.expect(IllegalStateException.class); //k is negative
        InsertionSort.isOK(arr,-3);
        
    }

    @Test
    public void insert1() {
        int[] arr = {4, 5, 6, 2, 3, 9, 1, 7, 8, 0};
        
        for (int i = 0; i < arr.length - 1; i++) {
            InsertionSort.insert(arr, i);
        }
    }

    @Test
    public void insert2() {
        int[] list = {1,2,4,5,3};
        InsertionSort.insert(list,4);
        for(int i = 0; i < list.length; i++) {
            assertEquals(i+1, list[i]);
        }

        //---------------------------------------
        int[] arr = {1,22,3,4,53,15,0,5,7,8,5,10};

        InsertionSort.insert(arr, 1);
        assertEquals(1,arr[0]);
        assertEquals(22,arr[1]);

        InsertionSort.insert(arr, 2);
        assertEquals(1,arr[0]);
        assertEquals(3,arr[1]);
        assertEquals(22,arr[2]);

        InsertionSort.insert(arr, 3);
        assertEquals(1,arr[0]);
        assertEquals(3,arr[1]);
        assertEquals(4,arr[2]);
        assertEquals(22,arr[3]);

        InsertionSort.insert(arr, 4);
        assertEquals(1,arr[0]);
        assertEquals(3,arr[1]);
        assertEquals(4,arr[2]);
        assertEquals(22,arr[3]);
        assertEquals(53,arr[4]);

        InsertionSort.insert(arr, 5);
        assertEquals(1,arr[0]);
        assertEquals(3,arr[1]);
        assertEquals(4,arr[2]);
        assertEquals(15,arr[3]);
        assertEquals(22,arr[4]);
        assertEquals(53,arr[5]);

        InsertionSort.insert(arr, 6);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(15,arr[4]);
        assertEquals(22,arr[5]);
        assertEquals(53,arr[6]);

        InsertionSort.insert(arr, 7);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(15,arr[5]);
        assertEquals(22,arr[6]);
        assertEquals(53,arr[7]);

        InsertionSort.insert(arr, 8);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(7,arr[5]);
        assertEquals(15,arr[6]);
        assertEquals(22,arr[7]);
        assertEquals(53,arr[8]);

        InsertionSort.insert(arr, 9);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(7,arr[5]);
        assertEquals(8,arr[6]);
        assertEquals(15,arr[7]);
        assertEquals(22,arr[8]);
        assertEquals(53,arr[9]);
        
        InsertionSort.insert(arr, 9);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(7,arr[5]);
        assertEquals(8,arr[6]);
        assertEquals(15,arr[7]);
        assertEquals(22,arr[8]);
        assertEquals(53,arr[9]);

        InsertionSort.insert(arr, 10);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(5,arr[5]);
        assertEquals(7,arr[6]);
        assertEquals(8,arr[7]);
        assertEquals(15,arr[8]);
        assertEquals(22,arr[9]);
        assertEquals(53,arr[10]);

        InsertionSort.insert(arr, 11);
        assertEquals(0,arr[0]);
        assertEquals(1,arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(4,arr[3]);
        assertEquals(5,arr[4]);
        assertEquals(5,arr[5]);
        assertEquals(7,arr[6]);
        assertEquals(8,arr[7]);
        assertEquals(10,arr[8]);
        assertEquals(15,arr[9]);
        assertEquals(22,arr[10]);
        assertEquals(53,arr[11]);

    }

    @Test
    public void insertionSort1() {
        int[] arr = {4, 5, 6, 2, 3, 9, 1, 7, 8, 0};
        int[] result = InsertionSort.insertionSort(arr);
        int[] check = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        assertEquals(Arrays.toString(result), Arrays.toString(check));
    }

    @Test
    public void insertionSort2() {
        int[] arr = {1,22,3,4,53,15,0,5,7,8,5,10};
        int[] result = InsertionSort.insertionSort(arr);
        assertEquals(0,result[0]);
        assertEquals(1,result[1]);
        assertEquals(3,result[2]);
        assertEquals(4,result[3]);
        assertEquals(5,result[4]);
        assertEquals(5,result[5]);
        assertEquals(7,result[6]);
        assertEquals(8,result[7]);
        assertEquals(10,result[8]);
        assertEquals(15,result[9]);
        assertEquals(22,result[10]);
        assertEquals(53,result[11]);

        int[] arr2 = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        result = InsertionSort.insertionSort(arr2);
        assertEquals(-5,result[0]);
        assertEquals(-4,result[1]);
        assertEquals(-3,result[2]);
        assertEquals(-2,result[3]);
        assertEquals(-1,result[4]);
        assertEquals(0,result[5]);
        assertEquals(1,result[6]);
        assertEquals(2,result[7]);
        assertEquals(3,result[8]);
        assertEquals(4,result[9]);
        assertEquals(5,result[10]);

    }

}
