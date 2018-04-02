import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//'InterfaceClass' is a functional interface
interface InterfaceClass{
	ArrayList<Integer> helperSortFunction(ArrayList<Integer> array);
}
public class Assessment1Q4 {
	public static int[] bucketSort(int[] numbers, int bucketCount,InterfaceClass myhelper) {

		 if (numbers.length <= 1) return numbers;
		 int maxVal = numbers[0];
		 int minVal = numbers[0];

		 for (int i = 1; i < numbers.length; i++) {
		 if (numbers[i] > maxVal) maxVal = numbers[i];
		 if (numbers[i] < minVal) minVal = numbers[i];
		 }

		 double interval = ((double)(maxVal - minVal + 1)) / bucketCount; // range of bucket
		 ArrayList<Integer> buckets[] = new ArrayList[bucketCount];

		 for (int i = 0; i < bucketCount; i++) // initialize buckets (initially empty)
		 buckets[i] = new ArrayList<Integer>();

		 for (int i = 0; i < numbers.length; i++) // distribute numbers to buckets
		 buckets[(int)((numbers[i] - minVal)/interval)].add(numbers[i]);

		 int k = 0;

		 for (int i = 0; i < buckets.length; i++) {

		 myhelper.helperSortFunction(buckets[i]); // calls Java's built-in merge sort (as a kind of “helper” sort)

		 for (int j = 0; j < buckets[i].size(); j++) { // update array with the bucket content
		 numbers[k] = buckets[i].get(j);
		 k++;
		 }
		 }

		 return numbers;
		 }
	
	public static void main(String[] args) {
		int array[]=new int[]{10,8,6,9,5,3,4,2};
		
		//printing the original array
		System.out.println("Original Array is as follows:");
		for(int i=0; i < array.length;i++){
			System.out.print(" "+array[i]);
		}
		//creating an instance of the 'InterfaceClass'
		InterfaceClass icici = new InterfaceClass() {

			public ArrayList<Integer> helperSortFunction(ArrayList<Integer> array1) {
				Collections.sort(array1); 
				return array1;
			}
			
		};
		
		int[] arrayNew =Assessment1Q4.bucketSort(array, 10, icici);
		//Printing the Sorted Array
		System.out.println("\nSorted Array is as follows");
		for(int i = 0; i<arrayNew.length;i++)
			System.out.print(" "+array[i]);
		
		
		int[] arraylambdas=new int[] {100,90,80,60,70,50,40,30,10,20};
		
		System.out.println("\nPrinting another unsorted array");
		for(int i=0;i< arraylambdas.length ; i++)
			System.out.print(" "+arraylambdas[i]);
		//USING LAMBDA EXPRESSIONS on the interface class
		InterfaceClass ic=(myhelper) -> {
			Collections.sort(myhelper);
			return myhelper;
		};
		
		int [] lambdaArrays = Assessment1Q4.bucketSort(arraylambdas, 10, ic);
		//Printing the sorted array
		System.out.println("\nSorted array is as follows:");
		for(int i = 0; i<arraylambdas.length;i++)
			System.out.print(" "+ arraylambdas[i]);
	}
}