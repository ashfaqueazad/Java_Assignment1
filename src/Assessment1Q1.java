import java.util.ArrayList;
import java.util.Collections;


public class Assessment1Q1 {
	
	public static int[] bucketSort(int[] numbers, int bucketCount) {
		
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
		
			 
		 Collections.sort(buckets[i]); // calls Java's built-in merge sort (as a kind of “helper” sort)

		 for (int j = 0; j < buckets[i].size(); j++) { // update array with the bucket content
		 numbers[k] = buckets[i].get(j);
		 k++;
		 }
		 }

		 return numbers;
		 }
	
	public static void main(String[] args){
		//Defining an array of numbers
		int[] arr=new int[]{1,3,5,7,9,2,4,6,10,12,11};
		
		//Printing the original array 'arr'
		System.out.println("Original Array:");
		for(int i=0; i<arr.length; i++){
			System.out.print(" "+ arr[i]);
		}
		
		//array 'arr1' contains the sorted array
		int[] arr1=Assessment1Q1.bucketSort(arr, 5);
		
		//Printing the sorted array 'arr1'
		System.out.println("\nSorted Array:");
		for(int i=0; i<arr1.length;i++)
		{
			System.out.print(" "+arr1[i]);
		}
	}

}
